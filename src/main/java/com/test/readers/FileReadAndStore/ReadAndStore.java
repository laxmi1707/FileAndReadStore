package com.test.readers.FileReadAndStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.readers.FileReadAndStore.CSVReader.CSVRead;
import com.test.readers.FileReadAndStore.Model.Reader;
import com.test.readers.FileReadAndStore.Model.StoreOrder;
import com.test.readers.FileReadAndStore.Persistance.MySQLAccess;
import com.test.readers.FileReadAndStore.XMLReader.XMLRead;



public class ReadAndStore {

	private static final Logger logger = LogManager.getLogger(ReadAndStore.class);
	
	MySQLAccess dbAccess = new MySQLAccess();
	
	public void processInputAndStoreInDB(String inputFilePath, char delimiter)
			throws IOException, FileNotFoundException, SQLException {
		File f = new File(inputFilePath);
		List<StoreOrder> storeOrderList  = new ArrayList<StoreOrder>();
		try{
			if(f.exists()){
				Reader readCSV ;
				if(inputFilePath.contains(".csv") || inputFilePath.contains(".txt") ){
					readCSV = new CSVRead();
				}else{
					readCSV = new XMLRead();
				}
				storeOrderList = readCSV.processInputAndReturnListRecordObj(inputFilePath, delimiter);
				// call MysqlAccess to store this arraylist only if its not empty 
				logger.info("Passing objects to Database !! ");
				if(!storeOrderList.isEmpty())
				{
					dbAccess.writeToDatabase(storeOrderList);
				}
			}else{
				throw new FileNotFoundException("File Not Found : "+inputFilePath);
			}
		}
		
		catch(IOException e){
			throw e; //i.e if file cannot be read etc
		}
		catch(SQLException e){
			logger.error("Some Error Occured while Storing to DB :"+e.getMessage());
			throw e; //i.e if file cannot be read etc
		}
		catch(Exception e){
			logger.error("Exception during read and store of file : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ReadAndStore() {
		// TODO Auto-generated constructor stub
	}
}
