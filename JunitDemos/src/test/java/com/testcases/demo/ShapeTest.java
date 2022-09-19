package com.testcases.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vfislk.training.Shape;

class ShapeTest {
    
	Shape shape;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		shape = new Shape();
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test @DisplayName("Testing area of rectangle")
	void test() {
		assertEquals(100.0,shape.calcArea(10, 10));
	}

}
