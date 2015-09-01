package com.wmoreira.javadevn1.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wellington.362@gmail.com
 */
@Entity
@Table(name = "vw_zipcode")
@SuppressWarnings("serial")
public class ZipCode {
    private static final long serialVersionUID = 8199967229715812072L;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "street")
    private String street;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    public ZipCode() {

    }

    public ZipCode(String street, String district, String city, String state) {
        this.setStreet(street);
        this.setDistrict(district);
        this.setCity(city);
        this.setState(state);
    }

    public ZipCode(String id, String street, String district, String city, String state) {
        this.setId(id);
        this.setStreet(street);
        this.setDistrict(district);
        this.setCity(city);
        this.setState(state);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
