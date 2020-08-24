package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
public class Computer  extends Item {
	
	@Id
	@GeneratedValue
	private int id;
	private int discSize;
	
	public Computer() {
		
	}
	public Computer(String name, Supplier supplier, int discSize) {
		super(name, supplier);
		this.discSize = discSize;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscSize() {
		return discSize;
	}
	public void setDiscSize(int discSize) {
		this.discSize = discSize;
	}
	
}

