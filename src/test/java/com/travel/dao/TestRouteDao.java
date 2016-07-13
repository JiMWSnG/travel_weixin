package com.travel.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.travel.bean.Product;
import com.travel.bean.Route;
import com.travel.dao.ProductDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:conf/applicationContext-travel-bean-dao.xml","classpath*:conf/applicationContext-travel-db-dbcp.xml",
})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
public class TestRouteDao extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource(name="RouteDao")
	private ProductDao routeDao;
	
	private int id;
	private int  routeItem_id;
	@Before
	public void setUp() throws Exception {
//		super.setUp();
		/*Route newRoute = new Route();
		newRoute.setName("test route 1");
		newRoute.setCategory("1");
		newRoute.setDay(1);
		newRoute.setDescription("beautiful route 1");
		newRoute.setStatus(1);
		newRoute.setHoliday(true);
		newRoute.setThemeId(1);
		routeDao.add(newRoute);
		id = newRoute.getId();
		RouteItem newRouteItem = new RouteItem();
		newRouteItem.setRouteId(newRoute.getId());
		routeDao.addRouteItem(newRouteItem);
		routeItem_id = newRouteItem.getId();
		*/
	}

	@After
	public void tearDown() throws Exception {
//		super.tearDown();
	}
	@Test
	public void testAdd(){
		Route newRoute = new Route();
		//newRoute.setId(11);
		newRoute.setName("nan'ji");
		newRoute.setType("2");
		////newRoute.setCreateTime(123456789);
		//newRoute.setUpdateTime(123456789);
		newRoute.setPrice(151.00);
		newRoute.setLocation("nanji");
		newRoute.setStatus("3");
		newRoute.setIndexs("nan ji");
		newRoute.setPicturePath("asdad");
		//newRoute.setThemeId(null);
		
		try{
			//assertNotNull("id:"+newRoute.getId(), newRoute.getId());
			int result = routeDao.add(newRoute);
			//assertNull("id:"+newRoute.getId(), newRoute.getId());
			System.out.println(result);
		}
		catch(Exception e ){
			e.printStackTrace();
			fail("测试失败 ");
		}
		
	}
	/*@Test
	public void testAddRouteItem(){
		RouteItem newRouteItem = new RouteItem();
		newRouteItem.setRouteId(12);
		try{
			int result = routeDao.addRouteItem(newRouteItem);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("测试失败 ");
		}
		
	}*/
	@Test
	public void testQueryById() {
		try{
			 Product route = routeDao.queryById(10);
			 System.out.println("testQueryById~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 if(route==null){
				 System.out.print(123123121);
			 }
			 System.out.println(route.toString());
		}
		catch(Exception e){
			fail("测试失败");
		}
		
	}
	

	/*@Test
	public void testGetRoutesByCategory() {
		try{
			 List<Route> routes = routeDao.getRoutesByCategory("1");
			 System.out.println("testGetRoutesByCategory~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 for (Route route : routes){
				 System.out.println(route.toString());
				 System.out.println(route.getRouteItem().toString());
			 }
		}
		catch(Exception e){
			fail("测试失败");
		}	
	}*/

/*	@Test
	public void testGetRoutesByStatus() {
		try{
			Date d = new Date();
			System.out.println(d);
			System.out.println(d.toString());
			System.out.println(d.getTime());
			System.out.println(System.currentTimeMillis());
			
			 List<Route> routes = routeDao.getRoutesByStatus(1);
			 System.out.println("testGetRoutesByStatus~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 for (Route route : routes){
				 System.out.println(route.toString());
				 System.out.println(route.getRouteItem().toString());
			 }
		}
		catch(Exception e){
			fail("测试失败");
		}
	}*/
	
	/*@Test
	public void testGetRouteByName(){
		try{
			Route route = routeDao.getRouteByName("test route 1");
			System.out.println("testGetRouteByName~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if(route!=null){
				System.out.println(route.toString());
				System.out.println(route.getRouteItem().toString());
			}
			else{
				System.out.println("get nothing");

			}
			
		}
		catch(Exception e){
			fail("测试失败");
		}
	
	}*/
	
	@Test
	public void testquery(){
		try{
			 List<Product> routes = new ArrayList<Product>();
			 String type ="1";
			 String location = "beiji";
			 String indexs = "beijidsa";
//			 routes = routeDao.getRoutes( "new", null, null, null, null, null,null,null,null);
			 routes = routeDao.query("1", "beiji", null);
			 System.out.println("testGetRoutes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~测试用例1");
			 for (Product route : routes){
				 System.out.println(route.toString());
//				 System.out.println(route.getRouteItem().toString());
			 }
		}
		catch(Exception e){
			e.printStackTrace();
			fail("测试失败");
		}
	}

}
