package com.sai.bo;

/**
 * @author krish
 *
 */
public class StudentBO {
	private int id;
	private String name;
	private int age;
	private String city;
	private String course;
	private int fee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "StudentBO [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + ", course=" + course
				+ ", fee=" + fee + "]";
	}
	
}
