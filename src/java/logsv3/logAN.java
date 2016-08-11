/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logsv3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 * @author slom
 */
public class logAN {

    private final Connection con;
    private final Statement st;
    private ResultSet rs;
    BufferedReader in, in1;
    int count, check, count1 , ser;
    String Time,Time3 ,  DateY, DateM, DateD, IP, PORT, skip, UserName, x1, Date, currentZone;
    LinkedList IPs;
    Object[] Info, Inf;

    public logAN() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip3", "root", "AO-ip3");
        st = con.createStatement();
        in = null;
        in1 = null;
        count = 0;
        
        x1 = null;
        Time = null;
        Time3 = null ;
        Date = null;
        DateY = "2016";
        DateM = null;
        DateD = null;
        IP = null;
        PORT = null;
        skip = null;
        currentZone = "+3:00";
        UserName = null;

    }

    public String[] Coun(String IP) throws SQLException {

        String address = IP;
        String[] Info = new String[6] ;

        String[] o1;

        o1 = address.split(Pattern.quote("."));
        BigInteger I0 = new BigInteger(o1[0]);
        BigInteger I1 = new BigInteger(o1[1]);
        BigInteger I2 = new BigInteger(o1[2]);
        BigInteger I3 = new BigInteger(o1[3]);

        BigInteger I00 = new BigInteger("16777216");
        BigInteger I11 = new BigInteger("65536");
        BigInteger I22 = new BigInteger("256");

        I0 = I0.multiply(I00);
        I1 = I1.multiply(I11);
        I2 = I2.multiply(I22);

        I0 = I0.add(I1);
        I0 = I0.add(I2);
        I0 = I0.add(I3);

        String query = " SELECT * FROM ip3.ip2_db WHERE " + I0 + " BETWEEN ip_from AND ip_to ";
        rs = st.executeQuery(query);

        while (rs.next()) {
            Info[0] = rs.getString("country_name");
            Info[1] = rs.getString("region_name");
            Info[2] = rs.getString("city_name");
            Info[3] = rs.getString("time_zone");
            Info[4] = rs.getString("latitude");
            Info[5] = rs.getString("longitude");

        }

        return Info;
    }

    public void ser_info(String IP, String id, String dataCenter, String status, String cDate) throws SQLException {
        String[] Inf = Coun(IP);
        // String ID = id.toString();
        String query = "INSERT INTO server_info (dropLetId, ip,dataCenter, status, createDate, countryName, regionName, cityName, timeZone, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(query);
        insertStatement.setString(1, (String) id);
        insertStatement.setString(2, (String) IP);
        insertStatement.setString(3, (String) dataCenter);
        insertStatement.setString(4, (String) status);
        insertStatement.setString(5, (String) cDate);
        insertStatement.setString(6, (String) Inf[0]);
        insertStatement.setString(7, (String) Inf[1]);
        insertStatement.setString(8, (String) Inf[2]);
        insertStatement.setString(9, (String) Inf[3]);
        insertStatement.setString(10, (String) Inf[4]);
        insertStatement.setString(11, (String) Inf[5]);
        insertStatement.execute();
    }

    public String[] GetSerKey(int id) throws SQLException {
        String zone = null;
        int key1 = 0;

        String selectSQL = "SELECT * FROM ip3.server_info WHERE dropLetId LIKE ?";
        PreparedStatement statement = con.prepareStatement(selectSQL);
        statement.setInt(1, id);
        rs = statement.executeQuery();

        while (rs.next()) {
            key1 = rs.getInt("serverInfoId");
            zone = rs.getString("timeZone");
        }
        String[] ar = new String[2];
        ar[0] = Integer.toString(key1);
        ar[1] = zone;

        return ar;
    }

    public void InsertInfo(Object[] Inf) throws SQLException {
        String query = "INSERT INTO ip_info (ip, countryName, regionName, cityName, timeZone, latitude, longitude)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(query);
        insertStatement.setString(1, (String) Inf[0]);
        insertStatement.setString(2, (String) Inf[2]);
        insertStatement.setString(3, (String) Inf[3]);
        insertStatement.setString(4, (String) Inf[4]);
        insertStatement.setString(5, (String) Inf[5]);
        insertStatement.setString(6, (String) Inf[6]);
        insertStatement.setString(7, (String) Inf[7]);
        insertStatement.execute();

    }

    public void InsertLogs(Object ip, Object ser, Object date, Object time, Object user, Object port) throws SQLException {
        String x1 = Integer.toString((int) ser);
        String query = "INSERT INTO ip_logs (ip, serverInfoId, date, time, userName, port) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(query);
        insertStatement.setString(1, (String) ip);
        insertStatement.setString(2, (String) x1);
        insertStatement.setString(3, (String) date);
        insertStatement.setString(4, (String) time);
        insertStatement.setString(5, (String) user);
        insertStatement.setString(6, (String) port);
        insertStatement.execute();

    }

    public void InsertAllLine(String ip, int idLog, String key, String x3) throws SQLException {
        String x1 = Integer.toString((int) idLog);
        //String x2 = Integer.toString((int) key);

        String query = "INSERT INTO all_lines(ipLogsId, ip, serverInfoId ,allLine) VALUES(?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(query);
        insertStatement.setString(1, (String) x1);
        insertStatement.setString(2, (String) ip);
        insertStatement.setString(3, (String) key);
        insertStatement.setString(4, (String) x3);
        insertStatement.execute();

    }

    public int GetLogId() throws SQLException {
        int id = 0;
        String selectSQL = " SELECT MAX(ipLogsId) FROM ip_logs";
        rs = st.executeQuery(selectSQL);
        while (rs.next()) {

            id = rs.getInt("MAX(ipLogsId)");
        }
        //System.out.println("id" +id );
        return id;
    }
    
    
   public void UpdateStatus(int ID , String Status) throws SQLException{
        
        String selectSQL = "UPDATE ip3.server_info SET status = ? WHERE dropLetId LIKE "+ID;
        PreparedStatement statement = con.prepareStatement(selectSQL);
        statement.setString(1, Status);
        statement.executeUpdate();
        
    }

    public void LogsAnalysis(String Path, String key, String zone, int idcount) throws IOException, SQLException {
        IPs = new LinkedList();
        in = new BufferedReader(new FileReader(Path));
        in1 = new BufferedReader(new FileReader(Path));
        Object[] Ports;
        Object[] UserNames;
        Object[] Dates;
        Object[] Times;
        ser = Integer.parseInt(key);
        while ((x1 = in.readLine()) != null) {
            StringTokenizer Splitter = new StringTokenizer(x1);
            StringTokenizer CheckSplitter = new StringTokenizer(in1.readLine());
            check = 0;
            while (CheckSplitter.hasMoreElements()) {
                skip = CheckSplitter.nextToken();
                switch (skip) {
                    case "for":
                        check++;
                        break;
                    case "Failed":
                        check++;
                        break;
                }
            }

            if (check == 2) {

                count++;
                DateM = Splitter.nextToken();
                DateD = Splitter.nextToken();
                Time = Splitter.nextToken();
                skip = Splitter.nextToken();
                skip = Splitter.nextToken();

                while (Splitter.hasMoreElements()) {

                    skip = Splitter.nextToken();
                    switch (skip) {
                        case "for":
                            String o = Splitter.nextToken();
                            if (o.equals("invalid")) {
                                Splitter.nextToken();
                                UserName = Splitter.nextToken();
                            } else {
                                UserName = o;
                            }

                            break;
                        case "from":
                            IP = Splitter.nextToken();
                            break;
                        case "port":
                            PORT = Splitter.nextToken();
                            break;
                        default:
                            break;
                    }

                }
                idcount++;
                InsertAllLine(IP, idcount, key, x1);
                Time3 = Time;
                Time = conTime(Time3, zone, currentZone);
                Date = DateY + "/" + DateM + "/" + DateD;

                if (IPs.Search(IP) == 0) {
                    Inf = Coun(IP);
                    IPs.add(IP, ser, Inf[0], Inf[1], Inf[2], Inf[3], Inf[4], Inf[5]);
                    int index = IPs.Search(IP);
                    IPs.addPort(PORT, index);
                    IPs.addUser(UserName, index);
                    IPs.addUTime(Time, index);
                    IPs.addDate(Date, index);
                } else {
                    // if(IPs.Search(IP)>0)
                    int index = IPs.Search(IP);
                    IPs.addPort(PORT, index);
                    IPs.addUser(UserName, index);
                    IPs.addUTime(Time, index);
                    IPs.addDate(Date, index);
                }

            }

        }
        for (int i = 1; i <= IPs.size(); i++) {
            double Size = IPs.getSizeofPorts(i);
            Ports = IPs.getPorts(i);
            UserNames = IPs.getUsers(i);
            Dates = IPs.getDate(i);
            Times = IPs.gettime(i);
            double p = ((Size / count) * 100);
            Info = IPs.getInfo(i);
            InsertInfo(Info);
            for (int j = 1; j <= Size; j++) {
                InsertLogs(Info[0], Info[1], Dates[j], Times[j], UserNames[j], Ports[j]);
            }
        }
        // return count;
    }
    
    
    public List<Integer> getActivIDs() throws SQLException{
       // ArrayList(int) list = new ArrayList();
       List<Integer> list = new ArrayList<Integer>() ;
       int i = 0;
        String selectSQL = "SELECT dropLetId FROM ip3.server_info WHERE status != ?";
        PreparedStatement statement = con.prepareStatement(selectSQL);
        statement.setString(1, "destroyed");
        rs = statement.executeQuery();

        while (rs.next()) {
        list.add(rs.getInt("dropLetId")); 
        }
        
        return list;
    }
    
    
    public int getDublicateID(String dataCenter) throws SQLException{

        String selectSQL = "SELECT dropLetId FROM ip3.server_info WHERE dataCenter LIKE ? AND status LIKE ?";
        PreparedStatement statement = con.prepareStatement(selectSQL);
        statement.setString(1, dataCenter);
        statement.setString(2, "active");
        rs = statement.executeQuery();
        int IDD=0;
        while (rs.next()) {
       IDD = rs.getInt("dropLetId");
        }
        
        return IDD;
    }
    
    
    public List<String> getActivDataCenter() throws SQLException{
       // ArrayList(int) list = new ArrayList();
       List<String> list = new ArrayList<String>() ;
       int i = 0;
        String selectSQL = "SELECT dataCenter FROM ip3.server_info WHERE status LIKE ?";
        PreparedStatement statement = con.prepareStatement(selectSQL);
        statement.setString(1, "active");
        rs = statement.executeQuery();

        while (rs.next()) {
        list.add(rs.getString("dataCenter")); 
        }
        
        return list;
    }

    public String conTime(String Time1, String zone, String czone) {
        String[] splt = Time1.split(":");
        String[] splt1 = zone.split(":");
        String[] splt2 = czone.split(":");

        int day = Integer.parseInt(DateD);
        int t, z, cz;
        t = Integer.parseInt(splt[0]);
        z = Integer.parseInt(splt1[0]);
        cz = Integer.parseInt(splt2[0]);

        if (z > 0) {
            for (int i = 0; i < z; i++) {

                if (t > 0) {
                    t = t - 1;
                } else {
                    t = 23;
                    day--;
                }
            }

        } else {
            for (int i = 0; i > z; i--) {

                if (t < 23) {
                    t = t + 1;
                } else {
                    t = 0;
                    day++;
                }
            }
        }

        if (cz > 0) {
            for (int i = 0; i < cz; i++) {
                if (t < 23) {
                    t = t + 1;
                } else {
                    t = 0;
                    day++;
                }
            }

        } else {
            for (int i = 0; i > cz; i--) {
                if (t > 0) {
                    t = t - 1;
                } else {
                    t = 23;
                    day--;
                }
            }
        }
        String Time2 = Integer.toString(t) + ":" + splt[1] + ":" + splt[2];
        DateD = Integer.toString(day);
        return Time2;
    }

}