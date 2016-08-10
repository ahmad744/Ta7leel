/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myjeeva.digitalocean;

import com.myjeeva.digitalocean.exception.DigitalOceanException;
import com.myjeeva.digitalocean.exception.RequestUnsuccessfulException;
import com.myjeeva.digitalocean.impl.DigitalOceanClient;
import com.myjeeva.digitalocean.pojo.Droplet;
import com.myjeeva.digitalocean.pojo.Droplets;
import com.myjeeva.digitalocean.pojo.Image;
import com.myjeeva.digitalocean.pojo.Key;
import com.myjeeva.digitalocean.pojo.Keys;
import com.myjeeva.digitalocean.pojo.Region;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M3
 */
public class LogsAnalysis {

    public Droplet newDroplet(String Name, String Region,String UserData ) throws DigitalOceanException, RequestUnsuccessfulException {

        DigitalOcean apiClient = new DigitalOceanClient("API TOKEN HERE");

        Droplet newDroplet = new Droplet();
        newDroplet.setName(Name);
        newDroplet.setSize("512mb"); // setting size by slug value
        newDroplet.setRegion(new Region(Region)); // setting region by slug value; sgp1 => Singapore 1 Data center 
        //"nyc1","ams1","sfo1","nyc2","ams2","sgp1","lon1","nyc3","ams3","nyc3"
        newDroplet.setImage(new Image("centos-7-2-x64")); // setting by Image Id 1601 => centos-5-8-x64 also available in image slug value
        newDroplet.setEnableBackup(Boolean.FALSE);
        newDroplet.setEnableIpv6(Boolean.FALSE);
        newDroplet.setEnablePrivateNetworking(Boolean.FALSE);
        newDroplet.setUserData(UserData);
        Keys keys = apiClient.getAvailableKeys(1);
        List<Key> Keys = new ArrayList<Key>();
        Keys.add(new Key(keys.getKeys().get(0).getId()));
        newDroplet.setKeys(Keys);
        Droplet droplet = apiClient.createDroplet(newDroplet);
        

        return droplet;

    }


}
