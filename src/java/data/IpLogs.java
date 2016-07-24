/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmad
 */
@Entity
@Table(name = "ip_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IpLogs.findAll", query = "SELECT i FROM IpLogs i"),
    @NamedQuery(name = "IpLogs.findByIpLogsId", query = "SELECT i FROM IpLogs i WHERE i.ipLogsId = :ipLogsId"),
    @NamedQuery(name = "IpLogs.findByIp", query = "SELECT i FROM IpLogs i WHERE i.ip = :ip"),
    @NamedQuery(name = "IpLogs.findByServerInfoId", query = "SELECT i FROM IpLogs i WHERE i.serverInfoId = :serverInfoId"),
    @NamedQuery(name = "IpLogs.findByDate", query = "SELECT i FROM IpLogs i WHERE i.date = :date"),
    @NamedQuery(name = "IpLogs.findByTime", query = "SELECT i FROM IpLogs i WHERE i.time = :time"),
    @NamedQuery(name = "IpLogs.findByUserName", query = "SELECT i FROM IpLogs i WHERE i.userName = :userName"),
    @NamedQuery(name = "IpLogs.findByPort", query = "SELECT i FROM IpLogs i WHERE i.port = :port")})
public class IpLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ipLogsId")
    private Integer ipLogsId;
    @Column(name = "ip")
    private String ip;
    @Column(name = "serverInfoId")
    private Integer serverInfoId;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Column(name = "port")
    private Integer port;

    public IpLogs() {
    }

    public IpLogs(Integer ipLogsId) {
        this.ipLogsId = ipLogsId;
    }

    public IpLogs(Integer ipLogsId, String userName) {
        this.ipLogsId = ipLogsId;
        this.userName = userName;
    }

    public Integer getIpLogsId() {
        return ipLogsId;
    }

    public void setIpLogsId(Integer ipLogsId) {
        this.ipLogsId = ipLogsId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getServerInfoId() {
        return serverInfoId;
    }

    public void setServerInfoId(Integer serverInfoId) {
        this.serverInfoId = serverInfoId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ipLogsId != null ? ipLogsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpLogs)) {
            return false;
        }
        IpLogs other = (IpLogs) object;
        if ((this.ipLogsId == null && other.ipLogsId != null) || (this.ipLogsId != null && !this.ipLogsId.equals(other.ipLogsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.IpLogs[ ipLogsId=" + ipLogsId + " ]";
    }
    
}
