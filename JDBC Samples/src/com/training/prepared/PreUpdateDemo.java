package com.training.prepared;


import java.sql.*;

public class PreUpdateDemo {

	public static void main(String[] args) {
		 String url ="jdbc:mysql://localhost:3306/trialdb";
		 String username="root";
		 String password ="root";
		 Connection connection = null;
		 //Statement statement = null;
		 PreparedStatement preparedStatement=null;
        try {
			connection = DriverManager.getConnection(url,username,password);
			String sql = "update food set type=? where food_id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "nonveg");
			preparedStatement.setString(2,"60");
		    
			int res =  preparedStatement.executeUpdate();
			System.out.println("Quaery Updated "+res);
			
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
