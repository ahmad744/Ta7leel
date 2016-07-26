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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author slom
 */
@Entity
@Table(name = "ip2_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ip2Db.findAll", query = "SELECT i FROM Ip2Db i"),
    @NamedQuery(name = "Ip2Db.findByIp2Id", query = "SELECT i FROM Ip2Db i WHERE i.ip2Id = :ip2Id"),
    @NamedQuery(name = "Ip2Db.findByIpFrom", query = "SELECT i FROM Ip2Db i WHERE i.ipFrom = :ipFrom"),
    @NamedQuery(name = "Ip2Db.findByIpTo", query = "SELECT i FROM Ip2Db i WHERE i.ipTo = :ipTo"),
    @NamedQuery(name = "Ip2Db.findByCountryCode", query = "SELECT i FROM Ip2Db i WHERE i.countryCode = :countryCode"),
    @NamedQuery(name = "Ip2Db.findByCountryName", query = "SELECT i FROM Ip2Db i WHERE i.countryName = :countryName"),
    @NamedQuery(name = "Ip2Db.findByRegionName", query = "SELECT i FROM Ip2Db i WHERE i.regionName = :regionName"),
    @NamedQuery(name = "Ip2Db.findByCityName", query = "SELECT i FROM Ip2Db i WHERE i.cityName = :cityName"),
    @NamedQuery(name = "Ip2Db.findByLatitude", query = "SELECT i FROM Ip2Db i WHERE i.latitude = :latitude"),
    @NamedQuery(name = "Ip2Db.findByLongitude", query = "SELECT i FROM Ip2Db i WHERE i.longitude = :longitude"),
    @NamedQuery(name = "Ip2Db.findByZipCode", query = "SELECT i FROM Ip2Db i WHERE i.zipCode = :zipCode"),
    @NamedQuery(name = "Ip2Db.findByTimeZone", query = "SELECT i FROM Ip2Db i WHERE i.timeZone = :timeZone")})
public class Ip2Db implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ip2Id")
    private Integer ip2Id;
    @Column(name = "ip_from")
    private Integer ipFrom;
    @Column(name = "ip_to")
    private Integer ipTo;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "region_name")
    private String regionName;
    @Column(name = "city_name")
    private String cityName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "time_zone")
    private String timeZone;

    public Ip2Db() {
    }

    public Ip2Db(Integer ip2Id) {
        this.ip2Id = ip2Id;
    }

    public Integer getIp2Id() {
        return ip2Id;
    }

    public void setIp2Id(Integer ip2Id) {
        this.ip2Id = ip2Id;
    }

    public Integer getIpFrom() {
        return ipFrom;
    }

    public void setIpFrom(Integer ipFrom) {
        this.ipFrom = ipFrom;
    }

    public Integer getIpTo() {
        return ipTo;
    }

    public void setIpTo(Integer ipTo) {
        this.ipTo = ipTo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ip2Id != null ? ip2Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ip2Db)) {
            return false;
        }
        Ip2Db other = (Ip2Db) object;
        if ((this.ip2Id == null && other.ip2Id != null) || (this.ip2Id != null && !this.ip2Id.equals(other.ip2Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Ip2Db[ ip2Id=" + ip2Id + " ]";
    }
    
}
