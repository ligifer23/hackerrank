package com.wmoreira.javadevn1.business.entity;

/**
 * Created by welingtonmoreira on 31/08/15.
 */
public class Cep {
    private int    id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Cep(String rua, String bairro, String cidade, String estado) {
	this.setRua(rua);
	this.setBairro(bairro);
	this.setCidade(cidade);
	this.setEstado(estado);
    }

    public Cep(int id, String rua, String bairro, String cidade, String estado) {
        this.setId(id);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getRua() {
	return rua;
    }

    public void setRua(String rua) {
	this.rua = rua;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }
}
