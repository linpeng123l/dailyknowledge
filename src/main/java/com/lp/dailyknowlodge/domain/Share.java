package com.lp.dailyknowlodge.domain;

import java.io.Serializable;
public class Share implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long referrerId;
	private String name;
	private long isAdopt;//1：采用     2：不采用
	private String contact;
	private String email;
	private String subject;
	private long referTime;
	private long award;

	public long getReferrerId() {
		return referrerId;
	}
	public void setReferrerId(long referrerId) {
		this.referrerId = referrerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getIsAdopt() {
		return isAdopt;
	}
	public void setIsAdopt(long isAdopt) {
		this.isAdopt = isAdopt;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public long getReferTime() {
		return referTime;
	}
	public void setReferTime(long referTime) {
		this.referTime = referTime;
	}

	public void setAward(long award) {
		this.award = award;
	}

	public long getAward() {
		return award;
	}
}
