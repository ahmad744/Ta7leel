/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author slom
 */
public class LogView {
    
    
    private String ipLogsId;
    private String attackerIp;
    private String attckerCity;
    private String attckerCountry;
    private String dropletIp;
    private String dropletDataCenter;
    private String attackerUsername;
    private String attackedPort;
    private String attackDate;
    private String attackTime;
    
    public String getIpLogsId() 
    {
        return ipLogsId;
    }
    
    public void setIpLogsId(String id) 
    {
        this.ipLogsId = id;
    }
    
    public String getAttackerIp() 
    {
        return attackerIp;
    }
    
    public void setAttackerIp(String ip) 
    {
        this.attackerIp = ip;
    }
    
    public String getAttckerCity() 
    {
        return attckerCity;
    }
    
    public void setAttckerCity(String city) 
    {
        this.attckerCity = city;
    }
    
    public String getAttckerCountry() 
    {
        return attckerCountry;
    }
    
    public void setAttckerCountry(String country) 
    {
        this.attckerCountry = country;
    }
    
    
    public String getDropletIp() 
    {
        return dropletIp;
    }
    
    public void setDropletIp(String dropIp) 
    {
        this.dropletIp = dropIp;
    }
    
    
    public String getDropletDataCenter() 
    {
        return dropletDataCenter;
    }
    
    public void setDropletDataCenter(String dataCenter) 
    {
        this.dropletDataCenter = dataCenter;
    }
    
    
    public String getAttackerUsername() 
    {
        return attackerUsername;
    }
    
    public void setAttackerUsername(String username) 
    {
        this.attackerUsername = username;
    }
    
    
    public String getAttackedPort() 
    {
        return attackedPort;
    }
    
    public void setAttackedPort(String port) 
    {
        this.attackedPort = port;
    }
    
    
    public String getAttackDate() 
    {
        return attackDate;
    }
    
    public void setAttackDate(String date) 
    {
        this.attackDate = date;
    }
    
    public String getAttackTime() 
    {
        return attackTime;
    }
    
    public void setAttackTime(String time) 
    {
        this.attackTime = time;
    }
}
