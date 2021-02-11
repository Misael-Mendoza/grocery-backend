package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryList;
import com.example.repository.ListRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class GroceryListService {
	private ListRepository listRepo;
	
	public List<GroceryList> getAllLists(){
		return listRepo.findAll();
	}
	
	public GroceryList getListById(int id) {
		return listRepo.getOne(id);
	}
	
	public GroceryList getListByName(String name) {
		return listRepo.findByListName(name);
	}
	
	public void insertList(GroceryList list) {
		listRepo.save(list);
	}
	
	public void deleteList(GroceryList list) {
		listRepo.delete(list);
	}
}
