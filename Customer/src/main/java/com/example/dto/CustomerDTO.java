package com.example.dto;

import java.util.Objects;

public class CustomerDTO {
	private Integer id;
	private String name;
	public CustomerDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + "]";
	}
	
}
