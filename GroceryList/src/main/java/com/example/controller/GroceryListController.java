package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GroceryList;
import com.example.service.GroceryListService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value = "/Lists" )
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class GroceryListController {
	private GroceryListService lServ;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public ResponseEntity<List<GroceryList>> getAllLists(){
		List<GroceryList> lists = lServ.getAllLists();
		return lists.isEmpty() ? new ResponseEntity<>(null,HttpStatus.NOT_FOUND) : new ResponseEntity<>(lists,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/new")
	public ResponseEntity<String> createList(@RequestBody LinkedHashMap lMap){
		GroceryList list  = new GroceryList((String)lMap.get("name"));
		lServ.insertList(list);
		return new ResponseEntity<>("List Succesfully Created!",HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/list/items")
	public ResponseEntity<String> addItemToList(@RequestBody LinkedHashMap lMap){
		return new ResponseEntity<>("Item Successfully Added!", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/lists/items/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id") int id){
		return new ResponseEntity<>("Item Successfully Deleted!",HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/lists/All/{id}")
	public ResponseEntity<String> deleteLists(@PathVariable("id") int id ){
		return new ResponseEntity<>("List Deleted Successfully", HttpStatus.OK);
	}
}

