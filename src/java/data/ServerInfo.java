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
@Table(name = "server_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServerInfo.findAll", query = "SELECT s FROM ServerInfo s"),
    @NamedQuery(name = "ServerInfo.findByServerInfoId", query = "SELECT s FROM ServerInfo s WHERE s.serverInfoId = :serverInfoId"),
    @NamedQuery(name = "ServerInfo.findByDropLetId", query = "SELECT s FROM ServerInfo s WHERE s.dropLetId = :dropLetId"),
    @NamedQuery(name = "ServerInfo.findByIp", query = "SELECT s FROM ServerInfo s WHERE s.ip = :ip"),
    @NamedQuery(name = "ServerInfo.findByDataCenter", query = "SELECT s FROM ServerInfo s WHERE s.dataCenter = :dataCenter"),
    @NamedQuery(name = "ServerInfo.findByStatus", query = "SELECT s FROM ServerInfo s WHERE s.status = :status"),
    @NamedQuery(name = "ServerInfo.findByCreateDate", query = "SELECT s FROM ServerInfo s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "ServerInfo.findByDestroyDate", query = "SELECT s FROM ServerInfo s WHERE s.destroyDate = :destroyDate"),
    @NamedQuery(name = "ServerInfo.findByCountryName", query = "SELECT s FROM ServerInfo s WHERE s.countryName = :countryName"),
    @NamedQuery(name = "ServerInfo.findByRegionName", query = "SELECT s FROM ServerInfo s WHERE s.regionName = :regionName"),
    @NamedQuery(name = "ServerInfo.findByCityName", query = "SELECT s FROM ServerInfo s WHERE s.cityName = :cityName"),
    @NamedQuery(name = "ServerInfo.findByTimeZone", query = "SELECT s FROM ServerInfo s WHERE s.timeZone = :timeZone"),
    @NamedQuery(name = "ServerInfo.findByLatitude", query = "SELECT s FROM ServerInfo s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "ServerInfo.findByLongitude", query = "SELECT s FROM ServerInfo s WHERE s.longitude = :longitude")})
public class ServerInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serverInfoId")
    private Integer serverInfoId;
    @Column(name = "dropLetId")
    private Integer dropLetId;
    @Column(name = "ip")
    private String ip;
    @Column(name = "dataCenter")
    private String dataCenter;
    @Column(name = "status")
    private String status;
    @Column(name = "createDate")
    private String createDate;
    @Column(name = "destroyDate")
    private String destroyDate;
    @Column(name = "countryName")
    private String countryName;
    @Column(name = "regionName")
    private String regionName;
    @Column(name = "cityName")
    private String cityName;
    @Column(name = "timeZone")
    private String timeZone;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    public ServerInfo() {
    }

    public ServerInfo(Integer serverInfoId) {
        this.serverInfoId = serverInfoId;
    }

    public Integer getServerInfoId() {
        return serverInfoId;
    }

    public void setServerInfoId(Integer serverInfoId) {
        this.serverInfoId = serverInfoId;
    }

    public Integer getDropLetId() {
        return dropLetId;
    }

    public void setDropLetId(Integer dropLetId) {
        this.dropLetId = dropLetId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDestroyDate() {
        return destroyDate;
    }

    public void setDestroyDate(String destroyDate) {
        this.destroyDate = destroyDate;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serverInfoId != null ? serverInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerInfo)) {
            return false;
        }
        ServerInfo other = (ServerInfo) object;
        if ((this.serverInfoId == null && other.serverInfoId != null) || (this.serverInfoId != null && !this.serverInfoId.equals(other.serverInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.ServerInfo[ serverInfoId=" + serverInfoId + " ]";
    }
    
}
