package com.test.readers.FileReadAndStore;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.test.readers.FileReadAndStore.CSVReader.CSVRead;
import com.test.readers.FileReadAndStore.Model.StoreOrder;


/**
 * Unit test for simple App.
 */
public class CSVReadTest 
{
    
	private CSVRead readCSV = new CSVRead();
	private final String fileLocations = "src/test/resources/testFiles/";

	@Test(expected = FileNotFoundException.class) 
    public void testNotExistentFile() throws IOException,FileNotFoundException{
    	readCSV.processInputAndReturnListRecordObj("/Usr/test", ',');
   }

	//we can test the below using junit 5 
//	@Test
//    public void testHeaderMismatch() throws IOException,FileNotFoundException{
//		Exception exception = assertThrows(RuntimeException.class, () -> {
//			processInputAndReturnListRecordObj(fileLocations+"mismatchHeader.csv", ',');
//	    });
//	 
//	    String expectedMessage = "Error capturing CSV header!";
//	    String actualMessage = exception.getMessage();
//	 
//	    assertTrue(actualMessage.contains(expectedMessage));
//		
//   }
	
	@Test
    public void testRequiredFieldMissingValue() throws IOException,FileNotFoundException{
    	List<StoreOrder> st = readCSV.processInputAndReturnListRecordObj(fileLocations+"requiredFieldEmpty.csv", ',');
    	assertNotNull(st);
    	assertEquals(st.size(), 1);
    }
	
	@Test
    public void testFieldWithQuotesAndDelimiterInFieldValue() throws IOException,FileNotFoundException{
    	List<StoreOrder> stList = readCSV.processInputAndReturnListRecordObj(fileLocations+"quotesSpecialCharacters.csv", ',');
    	String toExpect = "#10-4 1/8\" x, 9 1/2\" Premium Diagonal Seam Envelopes";
    	assertNotNull(stList);
    	assertEquals(stList.get(0).getCity(), "Los, Angeles");
    	assertEquals(stList.get(1).getProductName(), toExpect);
    }
	
	@Test
    public void testFieldWithNegativeProfit() throws IOException,FileNotFoundException{
    	List<StoreOrder> stList = readCSV.processInputAndReturnListRecordObj(fileLocations+"quotesSpecialCharacters.csv", ',');
    	BigDecimal toExpect =  new BigDecimal("-14.1694");
    	assertNotNull(stList);
    	assertEquals(stList.get(0).getProfit(), toExpect);
    	
    }
	
	@Test
    public void testFieldWithEmptyQuotes() throws IOException,FileNotFoundException{
    	List<StoreOrder> stList = readCSV.processInputAndReturnListRecordObj(fileLocations+"emptyQuotes.csv", ',');
    	String expected = new String("");
    	assertNotNull(stList);
    	assertEquals(stList.get(0).getShipMode(), expected);
   }
}
