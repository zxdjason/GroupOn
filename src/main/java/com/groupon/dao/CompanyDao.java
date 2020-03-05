package com.groupon.dao;

import java.util.Collection;

import com.groupon.model.Company;

public interface CompanyDao {
    
    public void saveCompany(Company company);

    public Collection<Company> getAllCompanies();

    public Company getCompanyByName(String companyName);
    
    public void update(Company company);

    public void delete(String companyName);
   
	   
}
