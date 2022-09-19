package com.policy.service;

import java.util.List;

import com.policy.exceptions.IdNotFoundException;
import com.policy.exceptions.PolicyNotFoundException;
import com.policy.model.Policy;

public interface IPolicyService {

	void addPolicy(Policy policy);
	void deletePolicy(int id);
	void updatePolicy(int id,String Coverage);
	
	
	List<Policy> getAll();
	List<Policy> getByType(String type) throws PolicyNotFoundException;
	List<Policy> getByCatagory(String catagory) throws PolicyNotFoundException;
	List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException;
	List<Policy> getByCoverageSumAssured(String coverage) throws PolicyNotFoundException;
	List<Policy> getByBrand(String brand) throws PolicyNotFoundException;
	List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException;
	
	Policy getById(int policyId) throws IdNotFoundException;
	
}
