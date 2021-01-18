package com.test.readers.FileReadAndStore.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.test.readers.FileReadAndStore.Model.StoreOrder;

public interface Reader {
	public List<StoreOrder> processInputAndReturnListRecordObj(String inputFilePath, char delimiter)
			throws FileNotFoundException, IOException ;

	
}
