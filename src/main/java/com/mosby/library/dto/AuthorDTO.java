package com.mosby.library.dto;

import java.util.Objects;

public class AuthorDTO {
	
	private Integer id;
	private String name;
	private String city;
	private String country;
	
	public AuthorDTO() {
	}

	public AuthorDTO(Integer id, String name, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorDTO other = (AuthorDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AuthorDTO [id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + "]";
	}
}
