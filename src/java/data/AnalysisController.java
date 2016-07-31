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



public class AnalysisController extends AbstractController
{
    
 
    private JdbcTemplate jdbcTemplate;
    
    public AnalysisController() {}

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
        //resource.setContentType ("text/html;charset=utf-8");

        WebApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request, this.getServletContext());
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
                
        
        
        
        List<ServerInfo> server = new ArrayList<ServerInfo>();       
        
        
        List<IpLogs> logs = new ArrayList<IpLogs>();       
       
        
        Map<String, List> pageData =  new HashMap<String, List>();
        
        pageData.put("server", server);
        pageData.put("logs", logs);
        
        return new ModelAndView("Analysis", "data", pageData);
    }
    
    
    
    
    
}
