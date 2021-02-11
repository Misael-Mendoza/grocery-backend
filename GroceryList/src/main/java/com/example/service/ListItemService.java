package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryList;
import com.example.model.ListItem;
import com.example.repository.ListItemRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service 
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ListItemService {
	private ListItemRepository itemRepo;
	
	public List<ListItem> getAllItems(){
		return itemRepo.findAll();
	}
	
	public List<ListItem> getItemsByList(GroceryList list){
		return itemRepo.findByList(list);
	}
	
	public ListItem getItemByName(String name) {
		return itemRepo.findByItemName(name);
	}
	
	public ListItem getItemById(int id) {
		return itemRepo.getOne(id);
	}
	
	public void insertItem(ListItem item) {
		itemRepo.save(item);
	}
	
	public void deleteItem(ListItem item) {
		itemRepo.delete(item);
	}
}
