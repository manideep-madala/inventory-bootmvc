package com.dxctraining.inventorymgt.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidSupplierArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNullException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class InventoryUi {

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IItemService itemService;

	@PostConstruct
	public void runUi() {
		try {
			List<Item> list = new ArrayList<>();
			Supplier supplier1 = new Supplier("mani");
			Supplier supplier2 = new Supplier("vamsi");
			Supplier supplier3 = new Supplier("teja");

			supplierService.addSupplier(supplier1);
			supplierService.addSupplier(supplier2);
			supplierService.addSupplier(supplier3);

			Item item1 = new Item("headphones", supplier1);
			Item item2 = new Item("speakers", supplier2);
			Item item3 = new Item("earpods", supplier3);

			list.add(item1);
			itemService.addItem(item1);
			list.add(item2);
			itemService.addItem(item2);
			list.add(item3);
			itemService.addItem(item3);

			Computer item4 = new Computer("hp", supplier1, 3000);
			Computer item5 = new Computer("acer", supplier2, 2000);

			list.add(item4);
			itemService.addItem(item4);
			list.add(item5);
			itemService.addItem(item5);
            
			Phone item6 = new Phone("motorola", supplier1, 32);
			list.add(item6);
			itemService.addItem(item6);
			Phone item7 = new Phone("apple", supplier2, 64);
			list.add(item7);
			itemService.addItem(item7);
			
			System.out.println("supplier details");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findById(id1);
			System.out.println("fetched id is " + fetched.getId() + " fetched supplier = " + fetched.getName());

			System.out.println("deleting item");
			int itemid3 = item3.getId();
			itemService.removeItem(itemid3);
			System.out.println("removed item id is " + itemid3);
			
			System.out.println("fetching computer item");
			int itemid1 = item4.getId();
			Computer computer=(Computer)item4;
			Item itemfetched = itemService.findById(itemid1);
			System.out.println("fetched item id is "+itemfetched.getId()+" fetched item name is "+itemfetched.getName());
			System.out.println("computer disk size is "+computer.getDiscSize());
            
			System.out.println("fetching phone item");
			int itemid2 = item6.getId();
			Phone phone=(Phone)item6;
			Item itemfetched1 = itemService.findById(itemid2);
			System.out.println("fetched item id is "+itemfetched1.getId()+" fetched item name is "+itemfetched1.getName());
			System.out.println("storage size size is "+phone.getStorageSize());

		} catch (InvalidSupplierArgumentException e) {
			e.printStackTrace();
		} catch (SupplierNullException e) {
			e.printStackTrace();
		}

	}


}
