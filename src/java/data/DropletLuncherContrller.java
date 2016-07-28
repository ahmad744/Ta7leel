/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ahmed
 */

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



public class DropletLuncherContrller extends AbstractController
{
    
 
    private JdbcTemplate jdbcTemplate;
    
    public DropletLuncherContrller() {}

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
        //resource.setContentType ("text/html;charset=utf-8");

        WebApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request, this.getServletContext());
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
                
        
        
        
        List<ServerInfo> server = new ArrayList<ServerInfo>();       
        server = getAllServerInfo();
        
        List<IpLogs> logs = new ArrayList<IpLogs>();       
        logs = getAllIpLogs();
        
        Map<String, List> pageData =  new HashMap<String, List>();
        
        pageData.put("server", server);
        pageData.put("logs", logs);
        
        return new ModelAndView("dropletluncher", "data", pageData);
    }
    
    
    public List<ServerInfo> getAllServerInfo() 
    {        
        return jdbcTemplate.query("SELECT * FROM ip3.server_info", new Object[] {}, new int[]{}, new RowMapper() 
        {
              public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
              {
                ServerInfo s = new ServerInfo();
                s.setServerInfoId(rs.getInt(1));
                s.setDropLetId(rs.getInt(2));
                s.setIp(rs.getString(3));
                s.setDataCenter(rs.getString(4));
                s.setStatus(rs.getString(5));
                s.setCreateDate(rs.getString(6));
                s.setDestroyDate(rs.getString(7));
                s.setCountryName(rs.getString(8));
                s.setRegionName(rs.getString(9));
                s.setCityName(rs.getString(10));
                s.setTimeZone(rs.getString(11));
                s.setLatitude(rs.getDouble(12));
                s.setLongitude(rs.getDouble(13));
                return s;
              }
        });
    }
    
    public List<IpLogs> getAllIpLogs() 
    {        
        return jdbcTemplate.query("SELECT * FROM ip3.ip_logs", new Object[] {}, new int[]{}, new RowMapper() 
        {
              public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
              {
                IpLogs il = new IpLogs();
                il.setIpLogsId(rs.getInt(1));
                il.setIp(rs.getString(2));
                il.setServerInfoId(rs.getInt(3));
                il.setDate(rs.getString(4));
                il.setTime(rs.getString(5));
                il.setUserName(rs.getString(6));
                il.setPort(rs.getInt(7));
                return il;
              }
        });
    }
}
