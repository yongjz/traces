package com.waterwood.common;


import java.math.BigDecimal;

public class TemporaryMerchandisePatch {
	private String merchandiseName;
	private Integer merchandiseCounts;
	private String acceptanceAuthority;
	private String merchandisePatchCatalog;
	private BigDecimal merchandisePatchMinPrice;
	private BigDecimal merchandisePatchMaxPrice;
	private String merchandisePatchCode;
	private String merchandisePatchProductingDate;
	private String merchandiseShelflifeDate;
	public String getMerchandiseName() {
		return merchandiseName;
	}
	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}
	public Integer getMerchandiseCounts() {
		return merchandiseCounts;
	}
	public void setMerchandiseCounts(Integer merchandiseCounts) {
		this.merchandiseCounts = merchandiseCounts;
	}
	public String getAcceptanceAuthority() {
		return acceptanceAuthority;
	}
	public void setAcceptanceAuthority(String acceptanceAuthority) {
		this.acceptanceAuthority = acceptanceAuthority;
	}
	public String getMerchandisePatchCatalog() {
		return merchandisePatchCatalog;
	}
	public void setMerchandisePatchCatalog(String merchandisePatchCatalog) {
		this.merchandisePatchCatalog = merchandisePatchCatalog;
	}
	public BigDecimal getMerchandisePatchMinPrice() {
		return merchandisePatchMinPrice;
	}
	public void setMerchandisePatchMinPrice(BigDecimal merchandisePatchMinPrice) {
		this.merchandisePatchMinPrice = merchandisePatchMinPrice;
	}
	public BigDecimal getMerchandisePatchMaxPrice() {
		return merchandisePatchMaxPrice;
	}
	public void setMerchandisePatchMaxPrice(BigDecimal merchandisePatchMaxPrice) {
		this.merchandisePatchMaxPrice = merchandisePatchMaxPrice;
	}
	public String getMerchandisePatchCode() {
		return merchandisePatchCode;
	}
	public void setMerchandisePatchCode(String merchandisePatchCode) {
		this.merchandisePatchCode = merchandisePatchCode;
	}
	public String getMerchandisePatchProductingDate() {
		return merchandisePatchProductingDate;
	}
	public void setMerchandisePatchProductingDate(
			String merchandisePatchProductingDate) {
		this.merchandisePatchProductingDate = merchandisePatchProductingDate;
	}
	public String getMerchandiseShelflifeDate() {
		return merchandiseShelflifeDate;
	}
	public void setMerchandiseShelflifeDate(String merchandiseShelflifeDate) {
		this.merchandiseShelflifeDate = merchandiseShelflifeDate;
	}
}
