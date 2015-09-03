package com.wmoreira.javadevn1.business.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author wellington.362@gmail.com
 */

@Entity
@Table(name = "enderecos")
@SuppressWarnings("serial")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Size(max = 100, message = "O tamanho máximo do campo 'street' é de {max} caracteres")
    @NotNull(message = "O campo 'street' é obrigatório")
    private String street;

    @Column
    @NotNull(message = "O campo 'number' é obrigatório")
    private Integer number;

    @Column
    @Size(max = 20, message = "O tamanho máximo do campo 'complement' é de {max} caracteres")
    private String complement;

    @Column
    @Size(max = 50, message = "O tamanho máximo do campo 'district' é de {max} caracteres")
    private String district;

    @Column
    @Size(max = 50, message = "O tamanho máximo do campo 'city' é de {max} caracteres")
    @NotNull(message = "O campo 'city' é obrigatório")
    private String city;

    @Column
    @Size(max = 2, message = "O tamanho máximo do campo 'state' é de {max} caracteres")
    @NotNull(message = "O campo 'state' é obrigatório")
    private String state;

    @Column
    @Size(max = 8, message = "O tamanho máximo do campo 'zipCode' é de {max} caracteres")
    @NotNull(message = "O campo 'zipCode' é obrigatório")
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Address address = (Address)o;

        if (id != null ? !id.equals(address.id) : address.id != null)
            return false;
        if (street != null ? !street.equals(address.street) : address.street != null)
            return false;
        if (number != null ? !number.equals(address.number) : address.number != null)
            return false;
        if (complement != null ? !complement.equals(address.complement) : address.complement != null)
            return false;
        if (district != null ? !district.equals(address.district) : address.district != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null)
            return false;
        if (state != null ? !state.equals(address.state) : address.state != null)
            return false;
        return !(zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null);

    }

    @Override public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (complement != null ? complement.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}
