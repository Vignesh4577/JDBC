package com.testcases.demo;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectPackages({"com.testcases"})
@IncludeTags({"testGetGread","greet","Fail"})
class AllTagTests {

	
	
}
