package com.policy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.policy.exceptions.IdNotFoundException;
import com.policy.exceptions.PolicyNotFoundException;
import com.policy.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO {



	@Override
	public void addPolicy(Policy policy) {
		Connection connection =null;
		PreparedStatement statement=null;


		String sql= "insert into policy (policy_name,premium,type ,duration ,coverage ,brand ,category ,sum_assured ) values (?,?,?,?,?,?,?,?)";
		connection = DbConnection.openConnection();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1,policy.getPolicyName());
			statement.setDouble(2,policy.getPremium());
			statement.setString(3,policy.getType());
			statement.setInt(4,policy.getDuration());
			statement.setString(5,policy.getCoverage());
			statement.setString(6,policy.getBrand());
			statement.setString(7,policy.getCatagory());
			statement.setDouble(8,policy.getSumAssured());
			statement.execute();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void deletePolicy(int id) {
		String sql= "delete from policy where policy_id=?";
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;

		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1,id);
			boolean result=statement.execute();
			System.out.println("Deleted "+result);
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updatePolicy(int id, String Coverage) {
		String sql= "update policy set coverage=? where policy_id=?";
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;

		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1,Coverage);
			statement.setInt(2,id);
			boolean result=statement.execute();
			System.out.println("Updated "+result);
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}


	}
	@Override
	public List<Policy> findAll() {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy";
		List<Policy> policy = new ArrayList<Policy>();

		try {


			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				String type =resultSet.getString("type");
				String coverage =resultSet.getString("coverage");
				String category =resultSet.getString("brand");
				double premium =resultSet.getDouble("premium");
				double sumAssured =resultSet.getDouble("sum_assured");
				int duration =resultSet.getInt("duration");

				Policy npolicy = new Policy(name, number,premium, type, duration, coverage, coverage, category, sumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}


	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy where type=?";
		List<Policy> policy = new ArrayList<Policy>();

		try {

            statement.setString(1, type);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				double premium =resultSet.getDouble("premium");
				String ntype =resultSet.getString("type");
				int duration =resultSet.getInt("duration");
				String coverage =resultSet.getString("coverage");
				String brand =resultSet.getString("brand");
				String category =resultSet.getString("category");
				double sumAssured =resultSet.getDouble("sum_assured");
				

				Policy npolicy = new Policy(name, number,premium, ntype, duration, coverage, brand, category, sumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}

	@Override
	public List<Policy> findByCatagory(String catagory) throws PolicyNotFoundException {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy where catagory=?";
		List<Policy> policy = new ArrayList<Policy>();

		try {
            statement= connection.prepareStatement(sql);
			statement.setString(1, catagory);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				double premium =resultSet.getDouble("premium");
				String ntype =resultSet.getString("type");
				int duration =resultSet.getInt("duration");
				String coverages =resultSet.getString("coverage");
				String brand =resultSet.getString("brand");
				String category =resultSet.getString("category");
				double sumAssured =resultSet.getDouble("sum_assured");
				

				Policy npolicy = new Policy(name, number,premium, ntype, duration, coverages, brand, category, sumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy where sumAssured=?";
		List<Policy> policy = new ArrayList<Policy>();

		try {
            statement= connection.prepareStatement(sql);
			statement.setDouble(1, sumAssured);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				double premium =resultSet.getDouble("premium");
				String ntype =resultSet.getString("type");
				int duration =resultSet.getInt("duration");
				String coverages =resultSet.getString("coverage");
				String brand =resultSet.getString("brand");
				String category =resultSet.getString("category");
				double nsumAssured =resultSet.getDouble("sum_assured");
				

				Policy npolicy = new Policy(name, number,premium, ntype, duration, coverages, brand, category, nsumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}
	

	@Override
	public List<Policy> findByCoverageSumAssured(String coverage) throws PolicyNotFoundException {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy where coverage=?";
		List<Policy> policy = new ArrayList<Policy>();

		try {
            statement= connection.prepareStatement(sql);
			statement.setString(1, coverage);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				double premium =resultSet.getDouble("premium");
				String ntype =resultSet.getString("type");
				int duration =resultSet.getInt("duration");
				String coverages =resultSet.getString("coverage");
				String brand =resultSet.getString("brand");
				String category =resultSet.getString("category");
				double nsumAssured =resultSet.getDouble("sum_assured");
				

				Policy npolicy = new Policy(name, number,premium, ntype, duration, coverages, brand, category, nsumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy where premium=?";
		List<Policy> policy = new ArrayList<Policy>();

		try {
            statement= connection.prepareStatement(sql);
			statement.setDouble(1, premium);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				double npremium =resultSet.getDouble("premium");
				String ntype =resultSet.getString("type");
				int duration =resultSet.getInt("duration");
				String coverages =resultSet.getString("coverage");
				String brand =resultSet.getString("brand");
				String category =resultSet.getString("category");
				double nsumAssured =resultSet.getDouble("sum_assured");
				

				Policy npolicy = new Policy(name, number,npremium, ntype, duration, coverages, brand, category, nsumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}

//	@Override
//	public Policy findById(int policyId) throws IdNotFoundException {
//		Connection connection =null;
//		PreparedStatement statement=null;
//		ResultSet resultSet=null;
//		String sql = "select * from policy where policyId=?";
//		List<Policy> policy = new ArrayList<Policy>();
//
//		try {
//            statement= connection.prepareStatement(sql);
//			statement.setInt(1, policyId);
//			resultSet = statement.executeQuery();
//			while(resultSet.next())
//			{
//
//				String name =resultSet.getString("policy_name");
//				Integer number =resultSet.getInt("policy_id");
//				double npremium =resultSet.getDouble("premium");
//				String ntype =resultSet.getString("type");
//				int duration =resultSet.getInt("duration");
//				String coverages =resultSet.getString("coverage");
//				String brand =resultSet.getString("brand");
//				String category =resultSet.getString("category");
//				double nsumAssured =resultSet.getDouble("sum_assured");
//				
//
//				Policy npolicy = new Policy(name, number,npremium, ntype, duration, coverages, brand, category, nsumAssured);
//
//				policy.add(npolicy);
//			}
//
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DbConnection.closeConnection();
//			try {
//				if(statement==null)
//					connection.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				DbConnection.closeConnection();
//			}	
//		}
//		return policy;

//	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		Connection connection =null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql = "select * from policy where brand=?";
		List<Policy> policy = new ArrayList<Policy>();

		try {
            statement= connection.prepareStatement(sql);
			statement.setString(1, brand);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String name =resultSet.getString("policy_name");
				Integer number =resultSet.getInt("policy_id");
				double npremium =resultSet.getDouble("premium");
				String ntype =resultSet.getString("type");
				int duration =resultSet.getInt("duration");
				String coverages =resultSet.getString("coverage");
				String nbrand =resultSet.getString("brand");
				String category =resultSet.getString("category");
				double nsumAssured =resultSet.getDouble("sum_assured");
				

				Policy npolicy = new Policy(name, number,npremium, ntype, duration, coverages, nbrand, category, nsumAssured);

				policy.add(npolicy);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
			try {
				if(statement==null)
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DbConnection.closeConnection();
			}	
		}
		return policy;

	}
	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
