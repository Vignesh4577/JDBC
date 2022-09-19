package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ResultDemo {

	public static void main(String[] args) {
		

		 String url ="jdbc:mysql://localhost:3306/trialdb";
		 String username="root";
		 String password ="root";
		 Connection connection = null;
		 Statement statement = null;
		 ResultSet resultSet =null;
        try {
			connection = DriverManager.getConnection(url,username,password);
		    statement = connection.createStatement();
		    
			String sql = "select * from policy";
		    resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				
				String name = resultSet.getString("name");
				int policyId = resultSet.getInt("policy_id");
				String type = resultSet.getString(3);
				float premium = resultSet.getFloat("premium");
				System.out.println(name+"\t"+policyId+"\t"+type+"\t"+premium);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				
				if(connection!=null)
					connection.close();
				if(statement!=null)
					statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	}

