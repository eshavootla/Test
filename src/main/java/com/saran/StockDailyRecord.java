package com.saran;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name ="stock_daily_record", uniqueConstraints=
@UniqueConstraint(columnNames= "DATE"))
public class StockDailyRecord implements java.io.Serializable {
	private Integer recordId;
	private Stock stock;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	private Date date;
	
	

	public StockDailyRecord() {
		super();
	}


	public StockDailyRecord(Stock stock, Date date) {
		super();
		this.stock = stock;
		this.date = date;
	}


	public StockDailyRecord(Stock stock, Float priceOpen, Float priceClose, Float priceChange, Long volume, Date date) {
		super();
		this.stock = stock;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.volume = volume;
		this.date = date;
	}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name= "RECORD", unique= true, nullable= false )
	public Integer getRecordId() {
		return recordId;
	}


	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

@ManyToOne(fetch= FetchType.LAZY)
@JoinColumn(name="STOCK_ID", nullable= false)
	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}

@Column(name= "PRICE_OPEN",precision=6)
	public Float getPriceOpen() {
		return priceOpen;
	}


	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

@Column(name= "PRICE_CLOSE",precision=6)
	public Float getPriceClose() {
		return priceClose;
	}


	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

@Column(name= "PRICE_CHANGE",precision=6)
	public Float getPriceChange() {
		return priceChange;
	}


	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}

@Column(name="VOLUME")
	public Long getVolume() {
		return volume;
	}


	public void setVolume(Long volume) {
		this.volume = volume;
	}

@Temporal(TemporalType.DATE)
@Column(name= "DATE",unique= true,nullable=false,length=10)
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
