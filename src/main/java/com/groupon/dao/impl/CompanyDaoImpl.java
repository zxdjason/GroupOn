package com.groupon.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupon.dao.CompanyDao;
import com.groupon.model.*;

@Repository
public class CompanyDaoImpl implements CompanyDao{

    private static Map<String,Company> companies = null;
   
    @Autowired
    private CompanyDaoImpl companyDaoImpl;
    
    static{
    	companies = new HashMap<String,Company>();

    	companies.put("Company_A", new Company(101,"Company_A"));
    	companies.put("Company_B", new Company(102,"Company_B"));
    	companies.put("Company_C", new Company(103,"Company_C"));
    	companies.put("Company_D", new Company(104,"Company_D"));
    	companies.put("Company_E", new Company(105,"Company_E"));
    }

    public Collection<Company> getCompanies(){
        return companies.values();
    }
    
    private static Integer inintid = 1000;
    
    public void saveCompany(Company company){
        if(company.getId()==null){
            company.setId(inintid++);
        }
        companies.put(company.getCompanyName(), company);
    }

    public Collection<Company> getAllCompanies(){
        return companies.values();
    }

    public Company getCompanyByName(String companyName){
        return companies.get(companyName);
    }
    
    public void update(Company company){
    	companies.replace(company.getCompanyName(), company);
    }

    public void delete(String companyName){
    	companies.remove(companyName);
    }

}
