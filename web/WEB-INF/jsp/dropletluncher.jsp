<%-- 
    Document   : dropletIuncher
    Created on : Jul 28, 2016, 9:13:33 AM
    Author     : M3
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.myjeeva.digitalocean.pojo.Droplet"%>
<%@page import="com.myjeeva.digitalocean.pojo.Droplet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.myjeeva.digitalocean.pojo.Droplets"%>
<%@page import="com.myjeeva.digitalocean.LogsAnalysis"%>
<%@page import="com.myjeeva.digitalocean.LogsAnalysis"%>
<%@page import="com.myjeeva.digitalocean.pojo.Sizes"%>
<%@page import="com.myjeeva.digitalocean.impl.DigitalOceanClient"%>
<%@page import="com.myjeeva.digitalocean.impl.DigitalOceanClient"%>
<%@page import="com.myjeeva.digitalocean.DigitalOcean"%>
<%@page import="com.myjeeva.digitalocean.DigitalOcean"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            int dropLetId = 0;
            String dataCenter = null, ip = null, status = null, createdDate = null;

            //******* DigitalOcean Client
            DigitalOcean apiClient = new DigitalOceanClient("API TOKEN HERE");

            LogsAnalysis logs = new LogsAnalysis();
            Sizes sizes = apiClient.getAvailableSizes(1);
            Droplets droplets = apiClient.getAvailableDroplets(1, null);
            List<Droplet> dro = new ArrayList<Droplet>();
            dro = droplets.getDroplets();
            //*********** The Data Centers that we need
            List<String> DataCenters = new ArrayList<String>();
            DataCenters.add("nyc1");
            DataCenters.add("lon1");
            DataCenters.add("fra1");
            DataCenters.add("sgp1");
            DataCenters.add("ams2");
            DataCenters.add("tor1");
            DataCenters.add("blr1");
            List<String> avDataCenters = new ArrayList<String>();
            List<String> emDataCenters = new ArrayList<String>();

            //*********** check the slaves number & DataCenters
            int SlaveNb = 0;
            for (int i = 0; i < dro.size(); i++) {
                if (dro.get(i).getName().contains("Slave") && dro.get(i).isLocked()) {
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

            //*********** Creat the missing slaves
            Droplet droplet = new Droplet();
            if (SlaveNb < 7) {
                for (int i = 0; i < emDataCenters.size(); i++) {
                    droplet = logs.newDroplet("Slave-" + emDataCenters.get(i), emDataCenters.get(i), "USER DATA HERE");
                    dropLetId = droplet.getId();
                    dataCenter = droplet.getRegion().getSlug();
                    // ip = droplet.getNetworks().getVersion4Networks().get(0).getIpAddress();//0 for public 1 for private
                    status = droplet.getStatus().toString();
                    createdDate = droplet.getCreatedDate().toString();
                    out.println("ID:" + dropLetId + "|dataCenter:" + dataCenter + "|ip:" + ip + "|status:" + status + "|createdDate:" + createdDate);

                }
                   }

        %>
    </body>
</html>