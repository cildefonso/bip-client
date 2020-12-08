package com.bip.api.dtos;

import org.bson.types.ObjectId;

public class ClientDto {

	
	private ObjectId _id;
	private String fullnameclient;
	private String cnpj;
	private String cpf;
	private String email;
	private String typeName;
	private String idaddress;
	private String idcompany;
	private String numberAddress;
	private String complementAddress;
	private String enterprise;
	private String userId;
	private PhonesDto phones;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getFullnameclient() {
		return fullnameclient;
	}
	public void setFullnameclient(String fullnameclient) {
		this.fullnameclient = fullnameclient;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getIdaddress() {
		return idaddress;
	}
	public void setIdaddress(String idaddress) {
		this.idaddress = idaddress;
	}
	public String getIdcompany() {
		return idcompany;
	}
	public void setIdcompany(String idcompany) {
		this.idcompany = idcompany;
	}
	public String getNumberAddress() {
		return numberAddress;
	}
	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}
	public String getComplementAddress() {
		return complementAddress;
	}
	public void setComplementAddress(String complementAddress) {
		this.complementAddress = complementAddress;
	}
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public PhonesDto getPhones() {
		return phones;
	}
	public void setPhones(PhonesDto phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "ClientDto [_id=" + _id + ", fullnameclient=" + fullnameclient + ", cnpj=" + cnpj + ", cpf=" + cpf
				+ ", email=" + email + ", typeName=" + typeName + ", idaddress=" + idaddress + ", idcompany="
				+ idcompany + ", numberAddress=" + numberAddress + ", complementAddress=" + complementAddress
				+ ", enterprise=" + enterprise + ", userId=" + userId + ", phones=" + phones + "]";
	}
	
	
	
	
}
