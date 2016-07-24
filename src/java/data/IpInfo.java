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
@Table(name = "ip_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IpInfo.findAll", query = "SELECT i FROM IpInfo i"),
    @NamedQuery(name = "IpInfo.findByIpInfoId", query = "SELECT i FROM IpInfo i WHERE i.ipInfoId = :ipInfoId"),
    @NamedQuery(name = "IpInfo.findByIp", query = "SELECT i FROM IpInfo i WHERE i.ip = :ip"),
    @NamedQuery(name = "IpInfo.findByCountryName", query = "SELECT i FROM IpInfo i WHERE i.countryName = :countryName"),
    @NamedQuery(name = "IpInfo.findByRegionName", query = "SELECT i FROM IpInfo i WHERE i.regionName = :regionName"),
    @NamedQuery(name = "IpInfo.findByCityName", query = "SELECT i FROM IpInfo i WHERE i.cityName = :cityName"),
    @NamedQuery(name = "IpInfo.findByTimeZone", query = "SELECT i FROM IpInfo i WHERE i.timeZone = :timeZone"),
    @NamedQuery(name = "IpInfo.findByLatitude", query = "SELECT i FROM IpInfo i WHERE i.latitude = :latitude"),
    @NamedQuery(name = "IpInfo.findByLongitude", query = "SELECT i FROM IpInfo i WHERE i.longitude = :longitude")})
public class IpInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ipInfoId")
    private Integer ipInfoId;
    @Column(name = "ip")
    private String ip;
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

    public IpInfo() {
    }

    public IpInfo(Integer ipInfoId) {
        this.ipInfoId = ipInfoId;
    }

    public Integer getIpInfoId() {
        return ipInfoId;
    }

    public void setIpInfoId(Integer ipInfoId) {
        this.ipInfoId = ipInfoId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
        hash += (ipInfoId != null ? ipInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IpInfo)) {
            return false;
        }
        IpInfo other = (IpInfo) object;
        if ((this.ipInfoId == null && other.ipInfoId != null) || (this.ipInfoId != null && !this.ipInfoId.equals(other.ipInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.IpInfo[ ipInfoId=" + ipInfoId + " ]";
    }
    
}
