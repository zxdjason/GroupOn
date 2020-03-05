package com.groupon.business.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupon.business.CompanyBusiness;
import com.groupon.dao.CompanyDao;
import com.groupon.model.Company;

@Service
public class CompanyBusinessImpl implements CompanyBusiness{
	
	@Autowired
	CompanyDao companyDao;
	
    public List <Company> getAllCompanies(){
    	Collection<Company> companies = new ArrayList<>();
    	companies = companyDao.getAllCompanies();	
    	   	
    	// sort company by company name
		List<Company> sortedCompanies = companies
				.stream()
				.sorted((companyName1, companyName2)->companyName1.compareTo(companyName2))
				.collect(Collectors.toList());
		
		return sortedCompanies;
    }
    
    public void saveCompany(Company Company){
		companyDao.saveCompany(Company);
    }


    public Company getCompanyByName(String companyName){
        return companyDao.getCompanyByName(companyName);
    }
    
    public void update(Company company){
    	companyDao.update(company);;
    }

    public void delete(String companyName){
    	companyDao.delete(companyName);
    }
    
}
