package com.saran;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {

		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
        
        SessionFactory sf=meta.getSessionFactoryBuilder().build();
        Session session=sf.openSession();
         Transaction t1=session.beginTransaction();
         
          Stock stock= new Stock();
          stock.setStockCode("12345");
          stock.setStockName("GOOGLE1");
         session.save(stock);
         
         StockDailyRecord stockDailyRecord= new StockDailyRecord();
         stockDailyRecord.setPriceOpen(new Float("1.2"));
         stockDailyRecord.setPriceClose(new Float("1.1"));
         stockDailyRecord.setPriceChange(new Float("10.2"));
         stockDailyRecord.setVolume(300000L);
         stockDailyRecord.setDate(new Date());
         
         stockDailyRecord.setStock(stock);
         stock.getStockDailyRecords().add(stockDailyRecord);
         session.save(stockDailyRecord);
         
         session.getTransaction().commit();
         System.out.println("Done");
         
         
	}

}
