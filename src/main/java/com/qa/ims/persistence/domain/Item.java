package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	
	private Long id;
	private String name;
	private double value;
	private int quantity;
	private String type;
	private String brand;
	private String shaft;
	
	public Item(String name, double value, int quantity, String type, String brand, String shaft) {
		this.setName(name);
		this.setValue(value);
		this.setQuantity(quantity);
		this.setType(type);
		this.setBrand(brand);
		this.setShaft(shaft);
	}
	
	public Item(Long id, String name, double value, int quantity, String type, String brand, String shaft) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.quantity = quantity;
		this.type = type;
		this.brand = brand;
		this.shaft = shaft;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getShaft() {
		return shaft;
	}

	public void setShaft(String shaft) {
		this.shaft = shaft;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", value=" + value + ", quantity=" + quantity + ", type=" + type
				+ ", brand=" + brand + ", shaft=" + shaft + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, id, name, quantity, shaft, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& quantity == other.quantity && Objects.equals(shaft, other.shaft) && Objects.equals(type, other.type)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}


}
