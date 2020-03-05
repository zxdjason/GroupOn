package com.groupon.model;

public class Company implements Comparable<Company>{

    private Integer id;
    private String companyName;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Company() {
        super();
    }

    public Company(Integer id, String companyName) {
        super();
        this.id = id;
        this.companyName = companyName;
    }

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + "]";
	}

	@Override
	public int compareTo(Company o) {
		return this.getCompanyName().compareTo(o.getCompanyName());
	}
    

}