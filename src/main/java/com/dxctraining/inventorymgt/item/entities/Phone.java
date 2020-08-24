package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
@Entity
public class Phone extends Item {
	
	@Id
	@GeneratedValue
	private int id;
	private int storageSize;
	
	public Phone() {
		
	}
	
	public Phone(String name, Supplier supplier, int storageSize) {
		super(name, supplier);
		this.storageSize = storageSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}
	
	

}
