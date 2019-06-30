package com.jsware.fizz.model.idea;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.jsware.fizz.model.member.Member;
import com.jsware.fizz.model.retort.Retort;

@Entity
@SequenceGenerator(name="idea_seq", initialValue=1)
public class Idea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idea_seq")
	private long id;
	
	@ManyToOne()
	@JoinColumn(name="creator")
	private Member creator;
	
	private Date timestamp = new Date();
	
	@OneToMany(mappedBy="idea")
	private List<Focus> focus = new ArrayList<Focus>();
	
	private String title, description;
	
	@OneToMany(mappedBy="idea")
	private List<Retort> resorts =  new ArrayList<Retort>();
	
	@OneToOne(mappedBy="idea")
	private Rating rating;
	
	public Idea() {}
	
	public Idea(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Idea other = (Idea) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

	public List<Focus> getFocus() {
		return focus;
	}

	public void setFocus(List<Focus> focus) {
		this.focus = focus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Member getCreator() {
		return creator;
	}

	public void setCreator(Member creator) {
		this.creator = creator;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Retort> getResorts() {
		return resorts;
	}

	public void setResorts(List<Retort> resorts) {
		this.resorts = resorts;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}


	
	
}