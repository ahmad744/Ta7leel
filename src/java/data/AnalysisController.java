/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ahmed
 */
import com.myjeeva.digitalocean.DigitalOcean;
import com.myjeeva.digitalocean.LogsAnalysis;
import com.myjeeva.digitalocean.exception.DigitalOceanException;
import com.myjeeva.digitalocean.exception.RequestUnsuccessfulException;
import com.myjeeva.digitalocean.impl.DigitalOceanClient;
import com.myjeeva.digitalocean.pojo.Droplet;
import com.myjeeva.digitalocean.pojo.Droplets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import javax.servlet.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import logsv3.logAN;

public class AnalysisController extends AbstractController {

    private JdbcTemplate jdbcTemplate;
    DigitalOcean apiClient;
    int Check, dropLetId1;
    String dataCenter, ip, status, createdDate, dropLetId;
    LogsAnalysis logs;
    List<String> DataCenters, AddedDataCenters, AddedDataCenters1, DataCenter1, test;
    List<Droplet> dro;
    List<Integer> IDs, IDs1;
    Droplets droplets;
    logAN logAn;

    public AnalysisController() throws ClassNotFoundException, SQLException {
        dataCenter = null;
        ip = null;
        status = null;
        createdDate = null;
        Check = 0;

        logAn = new logAN();
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
        //resource.setContentType ("text/html;charset=utf-8");

        WebApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request, this.getServletContext());
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        // List<ServerInfo> server = new ArrayList<ServerInfo>();       
        // List<IpLogs> logs = new ArrayList<IpLogs>(); 
        int k = 1;
        while (k == 1) {
            CreatInsetDB();
            CheckStatus();
            Thread.sleep(120000);
            CreatInsetDB();
            CheckStatus();
            Thread.sleep(120000);
            Analysis();

        }

        Map<String, List> pageData = new HashMap<String, List>();

        //  pageData.put("server", server);
        //  pageData.put("logs", logs);
        return new ModelAndView("Analysis", "data", pageData);

    }

    public List<String> Creat() throws DigitalOceanException, RequestUnsuccessfulException {
        dro = new ArrayList<Droplet>();
        DataCenters = new ArrayList<String>();
        AddedDataCenters = new ArrayList<String>();

        String userData = "";
        logs = new LogsAnalysis();
        DataCenters.add("nyc1");
        //DataCenters.add("lon1");
        DataCenters.add("fra1");
        // DataCenters.add("sgp1");
        //DataCenters.add("ams2");
        // DataCenters.add("tor1");
         DataCenters.add("blr1");
        List<String> avDataCenters = new ArrayList<String>();
        List<String> emDataCenters = new ArrayList<String>();
        apiClient = new DigitalOceanClient("API TOKEN HERE");
        droplets = apiClient.getAvailableDroplets(1, null);
        dro = droplets.getDroplets();
        int SlaveNb = 0;
        for (int i = 0; i < dro.size(); i++) {
            if (dro.get(i).getName().contains("Master") && !dro.get(i).isLocked()) {
                String IP = dro.get(i).getNetworks().getVersion4Networks().get(0).getIpAddress();
                userData = "#!/bin/sh\n"
                        + "echo '#!/bin/sh\n"
                        + "export ID=$(curl -s http://169.254.169.254/metadata/v1/id)\n"
                        + "mv /var/log/secure /var/log/$ID\n"
                        + "ftp -n " + IP + " <<END_SCRIPT\n"
                        + "quote USER analysis\n"
                        + "quote PASS Ta7leel\n"
                        + "lcd /var/log\n"
                        + "put $ID\n"
                        + "quit\n"
                        + "END_SCRIPT\n"
                        + "> /var/log/$ID' >/root/script.sh\n"
                        + "cd /root\n"
                        + "chmod +x script.sh\n"
                        + "echo \"*/5 * * * * sh /root/script.sh\" | tee -a /var/spool/cron/root\n"
                        + "yum -y install vsftpd\n"
                        + "systemctl enable vsftpd\n"
                        + "systemctl start vsftpd\n"
                        + "yum -y install ftp";
            }
            if (dro.get(i).getName().contains("Slave") && !dro.get(i).isLocked()) {
                avDataCenters.add(dro.get(i).getRegion().getSlug());

                SlaveNb++;
            }
        }
        int c = 0;
        for (int i = 0; i < DataCenters.size(); i++) {
            for (int j = 0; j < avDataCenters.size(); j++) {
                if (DataCenters.get(i).equals(avDataCenters.get(j))) {
                    c = 1;

                }
            }
            if (c == 0) {
                emDataCenters.add(DataCenters.get(i));
            } else {
                c = 0;
            }

        }

        if (SlaveNb < DataCenters.size()) {
            for (int i = 0; i < emDataCenters.size(); i++) {
                logs.newDroplet("Slave-" + emDataCenters.get(i), emDataCenters.get(i), userData);
                Check = 0;
                AddedDataCenters.add(emDataCenters.get(i));
            }
        } else {
            Check = 1;
        }
        return AddedDataCenters;
    }

    public String CreatInsetDB() throws DigitalOceanException, RequestUnsuccessfulException, ClassNotFoundException, SQLException, InterruptedException {
        AddedDataCenters1 = new ArrayList<String>();
        AddedDataCenters1 = Creat();
        logAn = new logAN();

        if (Check == 0) {
            Thread.sleep(60000);
             apiClient = new DigitalOceanClient("API TOKEN HERE");
            droplets = apiClient.getAvailableDroplets(1, null);
            dro = droplets.getDroplets();
            Droplet droplet = new Droplet();
            for (int i = 0; i < dro.size(); i++) {
                if (dro.get(i).getName().contains("Slave") && !dro.get(i).isLocked()) {
                    droplet = dro.get(i);

                    dropLetId = droplet.getId().toString();
                    dataCenter = droplet.getRegion().getSlug();
                    ip = droplet.getNetworks().getVersion4Networks().get(0).getIpAddress();//1 for public 0 for private
                    status = droplet.getStatus().toString();
                    createdDate = droplet.getCreatedDate().toString();
                    for (int j = 0; j < AddedDataCenters1.size(); j++) {
                        if (dataCenter.equals(AddedDataCenters1.get(j))) {
                            logAn.ser_info(ip, dropLetId, dataCenter, status, createdDate);
                        }
                    }

                }
            }

        }
        return ip;
    }

    public void Analysis() throws SQLException, IOException, ClassNotFoundException {
        logAn = new logAN();
        IDs = new ArrayList<Integer>();
        IDs = logAn.getActivIDs();

        for (int i = 0; i < IDs.size(); i++) {
            String path = getServletContext().getRealPath("/LogsFiles/") + IDs.get(i).toString();

            // String path = "../LogsFiles/" + test.get(i);
            File file = new File(path);

            if (file.exists()) {
                String[] KEYs = logAn.GetSerKey(IDs.get(i));
                int LastID = logAn.GetLogId();
                logAn.LogsAnalysis(path, KEYs[0], "00:00", LastID);
                // file.delete();

                Path path1 = Paths.get(path);
                Files.delete(path1);

            }

        }
    }

    public void CheckStatus() throws DigitalOceanException, RequestUnsuccessfulException, SQLException {
        IDs = new ArrayList<Integer>();
        IDs1 = new ArrayList<Integer>();
        DataCenters = new ArrayList<String>();
        DataCenters.add("nyc1");
        //DataCenters.add("lon1");
        DataCenters.add("fra1");
        // DataCenters.add("sgp1");
        //DataCenters.add("ams2");
        // DataCenters.add("tor1");
         DataCenters.add("blr1");
        DataCenter1 = new ArrayList<String>();
        DataCenter1 = logAn.getActivDataCenter();
        IDs1 = logAn.getActivIDs();
        apiClient = new DigitalOceanClient("API TOKEN HERE");
        droplets = apiClient.getAvailableDroplets(1, null);
        dro = droplets.getDroplets();
        Droplet droplet = new Droplet();
        for (int i = 0; i < dro.size(); i++) {
            droplet = dro.get(i);

            if (dro.get(i).getName().contains("Slave")) {
                dropLetId1 = droplet.getId();
                status = droplet.getStatus().toString();
                dataCenter = droplet.getRegion().getSlug();
                    logAn.UpdateStatus(dropLetId1, status);
                IDs.add(dropLetId1);

            }
        }

        int c = 0;
        for (int i = 0; i < IDs1.size(); i++) {
            for (int j = 0; j < IDs.size(); j++) {
                if (IDs1.get(i).equals(IDs.get(j))) {
                    c = 1;
                }
            }
            if (c == 0) {
                logAn.UpdateStatus(IDs1.get(i), "destroyed");
            } else {
                c = 0;
            }

        }

//        int s = 0;
//        for (int i = 0; i < DataCenters.size(); i++) {
//            for (int j = 0; j < DataCenter1.size(); j++) {
//                if (DataCenters.get(i).equals(DataCenter1.get(j))) {
//                    s++;
//                }
//            }
//            if (s > 1) {
//                //Delet Here
//                    int ID = logAn.getDublicateID(DataCenters.get(i));
//                    apiClient.deleteDroplet(ID);
//            } else {
//                s = 0;
//            }
//
//        }
    }

}
