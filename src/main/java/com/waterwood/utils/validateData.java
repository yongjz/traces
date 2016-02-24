package com.waterwood.utils;


import java.io.Serializable;

public class validateData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4486603388497715290L;
	private Boolean isOpen;
	private String dateTime;
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
	
}
