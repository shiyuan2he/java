package com.java;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.java.bean.TheaterSolrBean;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

public class SolrTest {
	SolrClient client=null;
    
    @Before
    public void init() throws Exception{
    	//1.创建链接
		client = new HttpSolrClient("http://localhost:8080/solr/poly");
    }
	@Test
	public void testAdd() {
		for(int i=0;i<100;i++){
			//2.创建一文档对象
			SolrInputDocument document = new SolrInputDocument();
			//3.向文档对象中添加域 （先定义后使用）
			document.addField("id", 10000+i); // 话剧ID
			document.addField("name", "中国戏剧黄金一代剧场典范 话剧《冬之旅》第"+i+"场");
			document.addField("img", "images/theatre-place.jpg");
			document.addField("performance_type_id", 20000+i);
			document.addField("show_time", "2017-03-23");
			document.addField("show_over_time", "2017-07-26");
			document.addField("project_desp", "在线选座/打折");
			document.addField("ticket_price", "¥100-880");
			document.addField("catalogName", "话剧/歌剧");
			try {
				client.add(document);
				client.optimize(); //对索引进行优化
				client.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//5.提交

		}
		//4.提交文档到索引库
	}
	@Test
	public void testAddBean() {
		for(int i=1;i<=100;i++){
			//2.创建一文档对象
			TheaterSolrBean theaterSolrBean = new TheaterSolrBean();
			//3.向文档对象中添加域 （先定义后使用）
			theaterSolrBean.setId((long)10000+i);
			theaterSolrBean.setTheaterId((20000+i)+"");
			theaterSolrBean.setTheaterName("中国戏剧黄金一代剧场典范 话剧《冬之旅》第"+i+"场");
			theaterSolrBean.setTheaterImg("images/theatre-place"+i+".jpg");
			theaterSolrBean.setTheaterDescription("在线选座/打折");
			Calendar calendar = Calendar.getInstance() ;
			calendar.add(Calendar.DAY_OF_MONTH,1); //加一天
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			Date startTime = null,endTime=null ;
			try {
				startTime = sdf.parse(sdf.format(calendar.getTime()));
				Calendar calendar2 = Calendar.getInstance() ;
                calendar2.add(Calendar.DAY_OF_MONTH,1); //加一天
           	 	calendar2.add(Calendar.HOUR_OF_DAY,3); //加三小时
				endTime = startTime = sdf.parse(sdf.format(calendar2.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			theaterSolrBean.setTheaterStartTime(startTime);
			theaterSolrBean.setTheaterEndTime(endTime);
			theaterSolrBean.setTheaterTicketPrice(500+Math.ceil(Math.random()*500)); // 500~1000
			theaterSolrBean.setTheaterType("话剧/歌剧");
			theaterSolrBean.setTheaterTypeId((long)9999999);
			try {
				client.addBean(theaterSolrBean);//4.提交文档到索引库
				client.optimize(); //对索引进行优化
				client.commit();//5.提交
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testSelect() {
		 //定义查询内容 * 代表查询所有    这个是基于结果集
        SolrQuery query = new SolrQuery();
        query.setQuery("name:~国戏剧黄~");
        query.setStart(0);//起始页
        query.setRows(10);//每页显示数量
        QueryResponse rsp = null;
		try {
			rsp = client.query( query );
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SolrDocumentList results = rsp.getResults();
        System.out.println(results.getNumFound());//查询总条数
        for(SolrDocument doc:results){
            System.out.println(doc);
        }
	}
	@Test
	public void testDelete() {
		try {
			client.deleteByQuery("*:*");
			client.commit();//先删除 基于query的删除 会删除所有建立的索引文件
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
