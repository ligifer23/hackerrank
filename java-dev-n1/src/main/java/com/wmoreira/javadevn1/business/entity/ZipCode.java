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
    @Column
    private String id;
    @Column
    private String street;
    @Column
    private String district;
    @Column
    private String city;
    @Column
    private String state;

    public ZipCode() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ZipCode zipCode = (ZipCode)o;

        if (id != null ? !id.equals(zipCode.id) : zipCode.id != null)
            return false;
        if (street != null ? !street.equals(zipCode.street) : zipCode.street != null)
            return false;
        if (district != null ? !district.equals(zipCode.district) : zipCode.district != null)
            return false;
        if (city != null ? !city.equals(zipCode.city) : zipCode.city != null)
            return false;
        return !(state != null ? !state.equals(zipCode.state) : zipCode.state != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
