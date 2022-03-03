package com.rzb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metadata")
public class MetaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return description;
	}

	public void setAge(String age) {
		this.description = age;
	}

	public MetaData() {

	}

	@Override
	public String toString() {
		return "MetaData [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
