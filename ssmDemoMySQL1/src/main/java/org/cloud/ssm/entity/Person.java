package org.cloud.ssm.entity;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String image;
	private String thumbImage;
	private Boolean lucky;
	private Integer level;

	public Person() {
		this.lucky = false;
	}

	public Person(Long id, String name, String image, String thumbImage) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.thumbImage = thumbImage;
		this.lucky = false;
	}

	public Boolean getLucky() {
		return lucky;
	}

	public void setLucky(Boolean lucky) {
		this.lucky = lucky;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getThumbImage() {
		return thumbImage;
	}

	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", image=" + image + "]";
	}

}
