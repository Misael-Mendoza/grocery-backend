package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.GroceryList;
import com.example.model.ListItem;

public interface ListItemRepository extends JpaRepository<ListItem, Integer>{
	
	public List<ListItem> findAll();
	public List<ListItem> findByList(GroceryList list);
	public ListItem findByItemName(String name);
}
