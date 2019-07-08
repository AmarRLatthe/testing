package com.xworkz.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "voter")
public class VoterDTO implements Serializable {

	@Id	
	@GenericGenerator(name = "sys_uuid", strategy = "guid")
	@GeneratedValue(generator = "sys_uuid")
	@Column(name="voter_id", length = 20, nullable = true)
	private String voterId;
	@Column(name="voter_name")
	private String voterName;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	
	public VoterDTO() {
		
	}
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddr(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "VoterDTO [voterId=" + voterId + ", voterName=" + voterName + ", age=" + age + ", gender=" + gender
				+ ", addr=" + address + "]";
	}
	
	
}
