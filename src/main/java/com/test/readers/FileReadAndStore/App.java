package com.test.readers.FileReadAndStore;

import com.test.readers.FileReadAndStore.ReadAndStore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
       // Read file from resource folder 
        String fileName = "src/test/resources/testFiles/sales.csv";
        ReadAndStore read = new ReadAndStore();
        try {
        	read.processInputAndStoreInDB(fileName, ',');
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
