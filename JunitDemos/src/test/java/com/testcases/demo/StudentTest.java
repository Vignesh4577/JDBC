package com.testcases.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.exception.InvalidNumException;
import com.vfislk.exception.NegValueException;
import com.vfislk.training.Calculator;
import com.vfislk.training.Student;

class StudentTest {

	Student student;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}

	@Test
	@DisplayName("Testing calcTotal")
	void testCalcTotal()  {
		assertEquals(80, student.calcTotal(10, 50, 20));
	}

	@Test
	@DisplayName("Testing negative value")
	void testNegTotal() {

		assertThrows(NegValueException.class, () -> student.calcTotal(-90, 50, 80));
	}

	@Test
	@DisplayName("Testing marks greater than 100")
	void testGreaterTotal() {

		assertThrows(InvalidNumException.class, () -> student.calcTotal(200, 50, 80));

	}

	@Test
	@DisplayName("Testing gread - 'A' ")
	void testGetGreadA() throws InvalidNumException {

		int[] marks = { 90, 90, 99, 85, 90, 90 };
		String grade = student.getGrades(marks);
		assertEquals("A", grade, "Excepting grade A ");

	}

	@Test
	@DisplayName("Testing gread - 'B' ")
	@Tag("testGetGreadB")
	void testGetGreadB() throws InvalidNumException {

		int[] marks = { 80, 90, 80, 85, 99, 95 };
		String grade = student.getGrades(marks);
		assertEquals("B", grade, "Excepting grade B ");
	}

	@Test
	@DisplayName("Testing gread - 'C' ")
	void testGetGreadC() throws InvalidNumException {

		int[] marks = { 60, 50, 80, 60, 90, 90 };
		String grade = student.getGrades(marks);
		assertEquals("C", grade, "Excepting grade C ");
	}

	@Test
	@DisplayName("Testing gread - 'D' ")
	void testGetGreadD() throws InvalidNumException {

		int[] marks = { 50, 50, 60, 40, 95, 57 };
		String grade = student.getGrades(marks);
		assertEquals("D", grade, "Excepting grade D ");
	}

	@Test
	@DisplayName("Testing Fail ")
	@Tag("Fail")
	void testGetGreadFail() throws InvalidNumException {

		int[] marks = { 30, 40, 20, 40, 50, 20 };
		String grade = student.getGrades(marks);
		assertEquals("Fail", grade, "Excepting grade Fail ");
	}

	@Test
	@DisplayName("Testing negative value ")
	void testGetGradeNegative() {

		int[] marks = { -30, 40, 20, 40, 50, 20 };
		assertThrows(InvalidNumException.class, () -> student.getGrades(marks));
	}

	@Test  @DisplayName("Testing null value ")
	void testNullCheck() {
		 
		 int[] marks= null;
		 assertNull(student.getGrades(marks));
	}
	@Test  @DisplayName("Marks greater than 100")
	void testGreaterthan100() {
		int[] marks= {100,120,90,20,30,30};
		assertThrows(InvalidNumException.class,()->student.getGrades(marks));
	}
}
