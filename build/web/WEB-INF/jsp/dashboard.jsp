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
        </c:forEach>
        </table>
        <br>
        <br>
        <br>
        <table cellpadding="10" cellspacing="0">
            <tr>
                <td>
                    ipLogsId
                </td>
                <td>
                    ip
                </td>
                <td>
                    serverInfoId
                </td>
                <td>
                    date
                </td>
                <td>
                    time
                </td>
                <td>
                    userName
                </td>
                <td>
                    port
                </td>
            </tr>
        <c:set var="counter" value="${1}"/>
        <c:forEach items="${data.logs}" var="logs"> 
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
                        ${logs.ip}
                    </td>
                    <td>
                        ${logs.serverInfoId}
                    </td>
                    <td>
                        ${logs.date}
                    </td>
                    <td>
                        ${logs.time}
                    </td>
                    <td>
                        ${logs.userName}
                    </td>
                    <td>
                        ${logs.port}
                    </td>
                </tr> 
                <c:set var="counter" value="${counter+1}"/>
                
        </c:forEach>
        </table>
    </body>
</html>
