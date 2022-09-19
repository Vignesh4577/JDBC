package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreInsertScanDemo {

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
			 Scanner scanner = new Scanner(System.in);
			 for(int i=-0;i<4;i++) {
				 System.out.println("Enter food name");
				 String name = scanner.next();
				 System.out.println("Enter food Id");
				 int foodId = scanner.nextInt();
				 System.out.println("Enter food type");
				 String type = scanner.next();
				 System.out.println("Enter Cost");
				 float cost = scanner.nextFloat();
				 
			 }
			// set values for the placeholders
			preparedStatement.setString(1, "Benne Dosa");
			preparedStatement.setInt(2, 60);
			preparedStatement.setFloat(4, 120);
			preparedStatement.setString(3, "Veg");
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
