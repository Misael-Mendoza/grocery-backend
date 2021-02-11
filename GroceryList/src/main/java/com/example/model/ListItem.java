package com.example.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity	
@Table(name = "Items")
@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class ListItem {

	@Id 
	@Column(name="item_id") 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	
	@Column(name= "item_name")
	private String itemName;
	
	@Column(name="item_type")
	private String Type;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="list_id")
	private GroceryList list;

	public ListItem(String itemName, String type, GroceryList list) {
		super();
		itemName = itemName;
		Type = type;
		this.list = list;
	}
	
}
