package com.example.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
@Id
private Integer id;
private String name;

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;
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
	Customer other = (Customer) obj;
	return Objects.equals(id, other.id) && Objects.equals(name, other.name);
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + "]";
}

}
