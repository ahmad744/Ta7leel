<%-- 
    Document   : dashboard
    Created on : Jul 24, 2016, 1:00:36 PM
    Author     : User
--%>
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
        <p>This is a Test</p>
        <table cellpadding="10" cellspacing="0">
                <tr>
                    <td>
                        serverInfoId
                    </td>
                    <td>
                        dropLetId
                    </td>
                    <td>
                        ip
                    </td>
                    <td>
                        dataCenter
                    </td>
                    <td>
                        status
                    </td>
                    <td>
                        createDate
                    </td>
                    <td>
                        destroyDate
                    </td>
                    <td>
                        countryName
                    </td>
                    <td>
                        regionName
                    </td>
                    <td>
                        cityName
                    </td>
                    <td>
                        timeZone
                    </td>
                    <td>
                        latitude
                    </td>
                    <td>
                        longitude
                    </td>
                </tr>
        <c:set var="counter" value="${1}"/>
        <c:forEach items="${data.server}" var="server">
            <c:choose>
                <c:when test="${counter%2 == 1}">
                <tr bgcolor="#ADD8E6">
                </c:when>
                <c:when test="${counter%2 == 0}">
                <tr>
                </c:when>
            </c:choose>
                    <td>
                        ${server.serverInfoId}
                    </td>
                    <td>
                        ${server.dropLetId}
                    </td>
                    <td>
                        ${server.ip}
                    </td>
                    <td>
                        ${server.dataCenter}
                    </td>
                    <td>
                        ${server.status}
                    </td>
                    <td>
                        ${server.createDate}
                    </td>
                    <td>
                        ${server.destroyDate}
                    </td>
                    <td>
                        ${server.countryName}
                    </td>
                    <td>
                        ${server.regionName}
                    </td>
                    <td>
                        ${server.cityName}
                    </td>
                    <td>
                        ${server.timeZone}
                    </td>
                    <td>
                        ${server.latitude}
                    </td>
                    <td>
                        ${server.longitude}
                    </td>
                </tr>
                <c:set var="counter" value="${counter+1}"/>
        </c:forEach>
        </table>
        <br>
        <br>
        <br>
        <table cellpadding="10" cellspacing="0">
            <tr>
                <td>
                    IP Log ID
                </td>
                <td>
                    Attacker IP
                </td>
                <td>
                    Attacker City
                </td>
                <td>
                    Attacker Country
                </td>
                <td>
                    Server IP
                </td>
                <td>
                    Server DataCenter
                </td>
                <td>
                    Attacker Username
                </td>
                <td>
                    Attacked Port
                </td>
                <td>
                    Attacked date
                </td>
                <td>
                    Attacked time
                </td>
            </tr>
        <c:set var="counter" value="${1}"/>
        <c:forEach items="${data.logViewList}" var="logs"> 
            <c:choose>
                <c:when test="${counter%2 == 1}">
                <tr bgcolor="#ADD8E6">
                </c:when>
                <c:when test="${counter%2 == 0}">
                <tr>
                </c:when>
            </c:choose>
                    <td>
                        ${logs.ipLogsId}
                    </td>
                    <td>
                        ${logs.attackerIp}
                    </td>
                    <td>
                        ${logs.attckerCity}
                    </td>
                    <td>
                        ${logs.attckerCountry}
                    </td>
                    <td>
                        ${logs.dropletIp}
                    </td>
                    <td>
                        ${logs.dropletDataCenter}
                    </td>
                    <td>
                        ${logs.attackerUsername}
                    </td>
                    <td>
                        ${logs.attackedPort}
                    </td>
                    <td>
                        ${logs.attackDate}
                    </td>
                    <td>
                        ${logs.attackTime}
                    </td>
                </tr> 
                <c:set var="counter" value="${counter+1}"/>
                
        </c:forEach>
        </table>
    </body>
</html>
