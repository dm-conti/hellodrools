package com.sample.domain;

public class Applicant {

	
	public Applicant(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;

    private int age;

    private boolean valid;
    
	public Applicant() {
		// TODO Auto-generated constructor stub
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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
