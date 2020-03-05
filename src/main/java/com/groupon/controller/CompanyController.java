package com.groupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.groupon.business.impl.CompanyBusinessImpl;
import com.groupon.model.Company;


@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyBusinessImpl companyBusinessImpl;
    @Autowired
    private Company company;

//    get all companies which include company name
    @GetMapping(path="/get-all-companies")
	public List <Company> getAllCompanies(){
		return companyBusinessImpl.getAllCompanies();
	}
    
//    save company which includes company name
    @PostMapping(path="/add-company")
	public void addCompany(@RequestBody Company newCompany){
    	companyBusinessImpl.saveCompany(newCompany);
	}
    
//    get company by passing company name as parameter
    @GetMapping(path="/get-company-name/{companyName}")
	public Company getCompanyByName(@PathVariable String companyName){
		return companyBusinessImpl.getCompanyByName(companyName);
	}
    
//    update company which includes company name
    @PostMapping(path="/update-company")
	public void updateCompanyByName(@RequestBody Company updatedCompany){
    	companyBusinessImpl.update(updatedCompany);
	}
    
//    delete company by passing company name as parameter
    @DeleteMapping(path="/delete-company/{compayName}")
	public void deleteCompanyByName(@PathVariable String companyName){
		companyBusinessImpl.delete(companyName);
	}

   
}
