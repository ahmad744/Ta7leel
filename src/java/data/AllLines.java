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
@Table(name = "all_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AllLines.findAll", query = "SELECT a FROM AllLines a"),
    @NamedQuery(name = "AllLines.findByAllLinesId", query = "SELECT a FROM AllLines a WHERE a.allLinesId = :allLinesId"),
    @NamedQuery(name = "AllLines.findByIpLogsId", query = "SELECT a FROM AllLines a WHERE a.ipLogsId = :ipLogsId"),
    @NamedQuery(name = "AllLines.findByIp", query = "SELECT a FROM AllLines a WHERE a.ip = :ip"),
    @NamedQuery(name = "AllLines.findByServerInfoId", query = "SELECT a FROM AllLines a WHERE a.serverInfoId = :serverInfoId"),
    @NamedQuery(name = "AllLines.findByAllLine", query = "SELECT a FROM AllLines a WHERE a.allLine = :allLine")})
public class AllLines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "allLinesId")
    private Integer allLinesId;
    @Column(name = "ipLogsId")
    private Integer ipLogsId;
    @Column(name = "ip")
    private String ip;
    @Column(name = "serverInfoId")
    private Integer serverInfoId;
    @Column(name = "allLine")
    private String allLine;

    public AllLines() {
    }

    public AllLines(Integer allLinesId) {
        this.allLinesId = allLinesId;
    }

    public Integer getAllLinesId() {
        return allLinesId;
    }

    public void setAllLinesId(Integer allLinesId) {
        this.allLinesId = allLinesId;
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

    public String getAllLine() {
        return allLine;
    }

    public void setAllLine(String allLine) {
        this.allLine = allLine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (allLinesId != null ? allLinesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllLines)) {
            return false;
        }
        AllLines other = (AllLines) object;
        if ((this.allLinesId == null && other.allLinesId != null) || (this.allLinesId != null && !this.allLinesId.equals(other.allLinesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.AllLines[ allLinesId=" + allLinesId + " ]";
    }
    
}
