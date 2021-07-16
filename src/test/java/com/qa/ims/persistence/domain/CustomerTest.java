package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testConstructorOne() {
		Customer peter = new Customer(1L, "Peter", "Parker");
		assertTrue(peter instanceof Customer);
	}

	@Test
	public void testConstructorTwo() {
		Customer peter = new Customer("Peter", "Parker");
		assertTrue(peter instanceof Customer);
	}

	@Test
	public void testGetters() {
		Customer peter = new Customer(1L, "Peter", "Parker");
		Long expectedId = 1L;
		String expectedFirstname = "Peter";
		String expectedSurname = "Parker";

		assertEquals(expectedId, peter.getId());
		assertEquals(expectedFirstname, peter.getFirstName());
		assertEquals(expectedSurname, peter.getSurname());
	}

	@Test
	public void testSetters() {
		Customer harry = new Customer(1L, "Peter", "Parker");

		harry.setId(2L);
		Long expectedId = 2L;
		harry.setFirstName("Harry");
		String expectedFirstname = "Harry";
		harry.setSurname("Potter");
		String expectedSurname = "Potter";

		assertEquals(expectedId, harry.getId());
		assertEquals(expectedFirstname, harry.getFirstName());
		assertEquals(expectedSurname, harry.getSurname());
	}

	@Test
	public void testToString() {
		Customer peter = new Customer(1L, "Peter", "Parker");
		String expected = "id:" + peter.getId() + " first name:" + peter.getFirstName() + " surname:"
				+ peter.getSurname();
		assertEquals(expected, peter.toString());
	}

	@Test
	public void testEqualsAndHashCode() {
		Customer peter = new Customer(1L, "Peter", "Parker");
		Customer peter2 = new Customer(1L, "Peter", "Parker");
		assertTrue(peter.equals(peter2) && peter2.equals(peter));
		assertTrue(peter.hashCode() == peter2.hashCode());
	}

	@Test
	public void testNullHashCodeEquals() {
		Customer peter = new Customer(null, null, null);
		Customer peter2 = new Customer(1L, "Peter", "Parker");
		assertFalse(peter.equals(peter2) && peter2.equals(peter));
		assertFalse(peter.hashCode() == peter2.hashCode());

	}

}
