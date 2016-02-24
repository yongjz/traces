package com.waterwood.entity;

import java.io.Serializable;

public class validateMerchandiseData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4486603388497715290L;
	private Boolean isOpen;
	private String dateTime;
	private MerchandisePatch merchandisePatch;
	public Boolean getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public MerchandisePatch getMerchandisePatch() {
		return merchandisePatch;
	}
	public void setMerchandisePatch(MerchandisePatch merchandisePatch) {
		this.merchandisePatch = merchandisePatch;
	}
	
}
