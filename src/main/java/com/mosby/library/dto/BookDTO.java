package com.mosby.library.dto;

import java.util.Objects;

public class BookDTO {
	private Integer id;
	private String title;
	private String description;
	private AuthorDTO authorDTO;
	
	public BookDTO() {
	}

	public BookDTO(Integer id, String title, String description, AuthorDTO authorDTO) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.authorDTO = authorDTO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorId(AuthorDTO authorDTO) {
		this.authorDTO = authorDTO;
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
		BookDTO other = (BookDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", description="
					+ description + ", authorDTO=" + authorDTO+ "]";
	}
}
