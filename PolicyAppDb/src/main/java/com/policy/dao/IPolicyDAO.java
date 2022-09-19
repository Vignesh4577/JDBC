package com.policy.dao;

import java.util.List;

import com.policy.exceptions.IdNotFoundException;
import com.policy.exceptions.PolicyNotFoundException;
import com.policy.model.Policy;

public interface IPolicyDAO {

	void addPolicy(Policy policy);
	void deletePolicy(int id);
	void updatePolicy(int id,String Coverage);
	

	List<Policy> findAll();
	List<Policy> findByType(String type) throws PolicyNotFoundException;
	List<Policy> findByCatagory(String catagory) throws PolicyNotFoundException;
	List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException;
	List<Policy> findByCoverageSumAssured(String coverage) throws PolicyNotFoundException;
	List<Policy> getByBrand(String brand) throws PolicyNotFoundException;
	List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException;
	
	Policy findById(int policyId) throws IdNotFoundException;
	
	
}
