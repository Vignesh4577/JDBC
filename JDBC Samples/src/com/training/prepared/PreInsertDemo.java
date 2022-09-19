package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreInsertDemo {

	public static void main(String[] args) {

		 String url ="jdbc:mysql://localhost:3306/trialdb";
		 String username="root";
		 String password ="root";
		 Connection connection = null;
		 Statement statement = null;
		 PreparedStatement preparedStatement=null;
         try {
			connection = DriverManager.getConnection(url,username,password);
			String sql ="insert into food values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			// set values for the placeholders
			preparedStatement.setString(1, "Benne Dosa");
			preparedStatement.setInt(2, 60);
			preparedStatement.setFloat(3, 120);
			preparedStatement.setString(4, "Veg");
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
