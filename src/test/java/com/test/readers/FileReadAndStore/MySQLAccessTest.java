package com.test.readers.FileReadAndStore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.test.readers.FileReadAndStore.Model.StoreOrder;
import com.test.readers.FileReadAndStore.Model.StoreOrderBuilder;
import com.test.readers.FileReadAndStore.Persistance.MySQLAccess;

public class MySQLAccessTest {

	MySQLAccess access = new MySQLAccess();
	static StoreOrder st = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StoreOrderBuilder stBuilder = new StoreOrderBuilder();
		st = stBuilder.withId(1).withOrderId("11").withOrderDate(new Date()).withShipDate(new Date()).
		withCustomerId("123").withCustomerName("testname").withProductId("id123")
		.withCountry("Singqpore").withCategory("test Cat").withQuantity(12).build();
	}
	
	@Test
	public void testWithObjectsToBeStoredInDB() throws Exception{
		List<StoreOrder> stList = new ArrayList<StoreOrder>();
		stList.add(st);
		access.writeToDatabase(stList);
	}//The data inserted can be tested with database read methods in the MySQLAccess file.

	public MySQLAccessTest() {
		
	}

}
