package com.test.readers.FileReadAndStore.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.test.readers.FileReadAndStore.Model.Reader;
import com.test.readers.FileReadAndStore.Model.StoreOrder;

public class CSVRead implements Reader {

	private static final Logger logger = LogManager.getLogger(CSVRead.class);
	
	final char DELIMITER = ',';
	
	@Override
	public List<StoreOrder> processInputAndReturnListRecordObj(String inputFilePath, char delimiter)
			throws FileNotFoundException, IOException {
		List<StoreOrder> listOfStoreOrders  =  new ArrayList<StoreOrder>();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));)
		{
			 CsvToBean<StoreOrder> csvToStoreObjectList = new CsvToBeanBuilder<StoreOrder>(reader)
	                    .withType(StoreOrder.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .withSeparator(delimiter)
	                    .withThrowExceptions(false)
	                    .build();
	         Iterator<StoreOrder> csvUserIterator = csvToStoreObjectList.iterator();
			 logger.info("Reading the File !!");
			 while (csvUserIterator.hasNext()) {
	            	StoreOrder storeOrderRecord = csvUserIterator.next();
	                listOfStoreOrders.add(storeOrderRecord);
	                logger.info("Records Rows Ready To be Processed RowID: "+storeOrderRecord.getId()+", OrderID: "+storeOrderRecord.getOrderId());
	           }
			 List<CsvException>  listOFExceptions = csvToStoreObjectList.getCapturedExceptions();
			 if(!listOFExceptions.isEmpty()){
				 logger.error("Exceptions in File (Please read lineNumber -1 as header line is included");
				 listOFExceptions.stream().forEach(e -> {logger.error("Exception on line "+ e.getLineNumber() +" is:"+e.getMessage()); });
			 }
		}
		catch(NoSuchFileException e){
			throw new FileNotFoundException("File Not Found : "+ inputFilePath); //i.e if file cannot be read etc
		}
        catch(IOException e)
		{
			throw e;
		}
        catch (Exception e) {
        	 logger.error("Reading CSV Error! - "+ e.getMessage() + e.getCause()); 
        	 e.printStackTrace();
        } 
		return listOfStoreOrders;
	}
	
	public CSVRead() {
		
	}
}
