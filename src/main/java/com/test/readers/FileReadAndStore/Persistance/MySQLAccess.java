package com.test.readers.FileReadAndStore.Persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.readers.FileReadAndStore.Model.StoreOrder;


public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private static final Logger logger = LogManager.getLogger(MySQLAccess.class);
	
	public void writeToDatabase(List<StoreOrder> salesList ) throws Exception{
		try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB These parameters can be read from properties file or from java vm arguments.
            //For sake of simplicity i am mentioning here
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/sales?"
                            + "user=root&password=password123");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            preparedStatement = connect
                    .prepareStatement("insert into  STORE_ORDER (ORDER_ID, ORDER_DATE, SHIP_DATE, SHIP_MODE, CUSTOMER_ID, CUSTOMER_NAME, SEGMENT, COUNTRY, CITY, STATE, "
                    		+ "POSTAL_CODE, REGION, PRODUCT_ID, CATEGORY, SUB_CATEGORY, "
                    		+ "PRODUCT_NAME, SALES, QUANTITY, DISCOUNT, PROFIT) "
                    		+ "values ( ?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?)");
           
    	  if(salesList !=null && !salesList.isEmpty()){
    	    		salesList.forEach(st->{
	    	    		  try{
	    	    		   preparedStatement.setString(1, st.getOrderId());
	    	               preparedStatement.setDate(2, new java.sql.Date(st.getOrderDate().getTime()));
	    	               preparedStatement.setDate(3, new java.sql.Date(st.getShipDate().getTime()));
	    	               preparedStatement.setString(4, st.getShipMode());
	    	               preparedStatement.setString(5, st.getCustomerId());
	    	               preparedStatement.setString(6, st.getCustomerName());
	    	               preparedStatement.setString(7, st.getSegment());
	    	               preparedStatement.setString(8, st.getCountry());
	    	               preparedStatement.setString(9, st.getCity());
	    	               preparedStatement.setString(10, st.getState());
	    	               preparedStatement.setString(11, st.getPostalCode());
	    	               preparedStatement.setString(12, st.getRegion());
	    	               preparedStatement.setString(13, st.getProductId());
	    	               preparedStatement.setString(14, st.getCategory());
	    	               preparedStatement.setString(15, st.getSubCategory());
	    	               preparedStatement.setString(16, st.getProductName());
	    	               preparedStatement.setBigDecimal(17, st.getSales());
	    	               preparedStatement.setInt(18, st.getQuantity());
	    	               preparedStatement.setBigDecimal(19, st.getDiscount());
	    	               preparedStatement.setBigDecimal(20, st.getProfit());
	    	               preparedStatement.executeUpdate();
	    	               logger.info("Inserted Row succesfully in database :"+st.getId());
	    	    		  }catch (SQLException e) {
	    	  	            
	    	    			  logger.error("From Database Exception is : "+e.getMessage());
	    	  	        } 
    	    		});
    	    	}
         }catch (SQLException e) {
	           throw e;
	      } 
		  catch (Exception e) {
				e.printStackTrace();
		        throw e;
		  }finally {
	            close();
	        }
	}	

	    private void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {
	        	System.out.println("Error while closing DB connections");
	        }
	    }
	    
	    public MySQLAccess() {
			
		}

}
