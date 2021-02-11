package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Lists")
@ToString
public class GroceryList {
	
	@Id
	@Column(name="list_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int listId;
	
	@Column(name="list_name")
	private String listName;
	
	@OneToMany(mappedBy = "list")
	@JsonIgnore
	private List<ListItem> itemsList = new ArrayList<>();

	public GroceryList(int listId) {
		super();
		this.listId = listId;
	}

	public GroceryList(String listName) {
		super();
		this.listName = listName;
	}
	
	
}
