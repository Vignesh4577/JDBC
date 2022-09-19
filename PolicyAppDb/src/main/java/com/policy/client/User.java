package com.policy.client;

import com.policy.model.Policy;
import com.policy.service.IPolicyService;
import com.policy.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {

		IPolicyService iPolicyService = new PolicyServiceImpl();
		
		try {
		iPolicyService.getAll().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}

		//Policy policy = new Policy("jevan anadh", 20, 500, "term", 20, "sikness", "health", "LIC", 200000);
		//iPolicyService.addPolicy(policy);
		// System.out.println("Added");
		//Policy apolicy = new Policy("jevan raksha", 10, 200, "single", 50, "sikness", "wealth", "LIC", 500000);
		//iPolicyService.addPolicy(apolicy);
		//System.out.println("Added");
		// iPolicyService.deletePolicy(2);
		// System.out.println("Deleted");
		//iPolicyService.updatePolicy(1, "illness");
		//System.out.println("updated");
		

	}

}
