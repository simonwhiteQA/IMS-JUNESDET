package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testConstructorOne() {
		Item club = new Item("i20", 200, 1, "Driver", "Callaway", "Stiff" );
		assertTrue(club instanceof Item);
	}

	@Test
	public void testConstructorTwo() {
		Item club = new Item(1L, "i20", 200, 1, "Driver", "Callaway", "Stiff" );
		assertTrue(club instanceof Item);
	}

	@Test
	public void testGetters() {
		Item club = new Item(1L, "i20", 200.00, 1, "Driver", "Callaway", "Stiff");
		Long expectedId = 1L;
		String expectedName = "i20";
		String expectedType = "Driver";
		String expectedBrand = "Callaway";
		String expectedShaft = "Stiff";
		double expectedValue = 200.00;
		int expectedQuantity = 1;

		assertEquals(expectedId, club.getId());
		assertEquals(expectedName, club.getName());
		assertEquals(expectedValue, club.getValue(), 0);
		assertEquals(expectedQuantity, club.getQuantity());
		assertEquals(expectedType, club.getType());
		assertEquals(expectedBrand, club.getBrand());
		assertEquals(expectedShaft, club.getShaft());
	}

	@Test
	public void testSetters() {
		Item club = new Item(1L, "i20", 200, 1, "Driver", "Callaway", "Stiff");

		Long expectedId = 1L;
		club.setId(1L);
		String expectedName = "i20";
		club.setName("i20");
		String expectedType = "Driver";
		club.setType("Driver");
		String expectedBrand = "Callaway";
		club.setBrand("Callaway");
		String expectedShaft = "Stiff";
		club.setShaft("Stiff");
		double expectedValue = 200;
		club.setValue(200);
		int expectedQuantity = 1;
		club.setQuantity(1);

		assertEquals(expectedId, club.getId());
		assertEquals(expectedId, club.getId());
		assertEquals(expectedName, club.getName());
		assertEquals(expectedValue, club.getValue(), 0);
		assertEquals(expectedQuantity, club.getQuantity());
		assertEquals(expectedType, club.getType());
		assertEquals(expectedBrand, club.getBrand());
		assertEquals(expectedShaft, club.getShaft());
	}

	@Test
	public void testToString() {
		Item club = new Item(1L, "i20", 200, 1, "Driver", "Callaway", "Stiff");
		String expected = "Item [id=" + club.getId() + ", name=" + club.getName() + ", value=" + club.getValue() + ", quantity=" + club.getQuantity() + ", type=" + club.getType()
				+ ", brand=" + club.getBrand() + ", shaft=" + club.getShaft() + "]";
		assertEquals(expected, club.toString());
	}

	@Test
	public void testEqualsAndHashCode() {
		Item club = new Item(1L, "i20", 200, 1, "Driver", "Callaway", "Stiff");
		Item club2 = new Item(1L, "i20", 200, 1, "Driver", "Callaway", "Stiff");
		assertTrue(club.equals(club2) && club2.equals(club));
		assertTrue(club.hashCode() == club2.hashCode());
	}


}