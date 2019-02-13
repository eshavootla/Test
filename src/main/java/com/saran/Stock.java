package com.saran;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock", uniqueConstraints = { @UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })

public class Stock implements java.io.Serializable {
	private Integer stockId;
	private String stockCode;
	private String stockName;

	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>();

	public Stock(String stockCode, String stockName) {
		super();
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(String stockCode, String stockName, Set<StockDailyRecord> stockDailyRecords) {
		super();
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}

	public Stock() {
		super();
	}

	@Id
	
@GeneratedValue(strategy= GenerationType.IDENTITY)	

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 20)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	 @OneToMany(fetch=FetchType.LAZY,mappedBy="stock")
	   public Set<StockDailyRecord> getStockDailyRecords() {
	       return stockDailyRecords;
	   }
	   public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
	       this.stockDailyRecords = stockDailyRecords;
	   }

}
