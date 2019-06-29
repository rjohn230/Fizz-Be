package com.jsware.fizz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.jsware.fizz.constants.FizzConstants.Category;

@Entity
@SequenceGenerator(name="foc_seq", initialValue=1)
public class Focus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="foc_seq")
	private long id;
	
	@OneToOne(mappedBy="focus")
	private Idea idea;
	
	private Category category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
