package com.groupon.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.groupon.business.impl.CompanyBusinessImpl;
import com.groupon.model.Company;


class CompanyControllerTest {

	@InjectMocks
    CompanyController companyController;
     
    @Mock
    CompanyBusinessImpl companyBusinessImpl;
     
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllCompaniesTest()
    {
        List<Company> list = new ArrayList<Company>();
        Company company1 = new Company(101,"Company_A");
        Company company2 = new Company(102,"Company_B");
        Company company3 = new Company(103,"Company_C");
        Company company4 = new Company(104,"Company_D");
        Company company5 = new Company(105,"Company_E");
         
        list.add(company1);
        list.add(company2);
        list.add(company3);
        list.add(company4);
        list.add(company5);
         
        when(companyBusinessImpl.getAllCompanies()).thenReturn(list);
         
        List<Company> companies = companyController.getAllCompanies();
         
        assertEquals(5, companies.size());
        verify(companyBusinessImpl, times(1)).getAllCompanies();
    }
     
    @Test
    public void getCompanyByCompanyNameTest()
    {
        when(companyBusinessImpl.getCompanyByName("Company_A")).thenReturn(new Company(101,"Company_A"));
         
        Company company = companyController.getCompanyByName("Company_A");
         
        assertEquals("Company_A", company.getCompanyName());
        assertEquals(101, company.getId());
    }
     
    @Test
    public void addCompanyTest()
    {
    	Company company = new Company(106,"Company_E");
    	
    	companyController.addCompany(company);
         
        verify(companyBusinessImpl, times(1)).saveCompany(company);
    }
    
    @Test
    public void deleteCompanyTest()
    {
    	Company company = new Company(102,"Company_B");
    	
    	companyController.deleteCompanyByName("Company_B");
         
        verify(companyBusinessImpl, times(1)).delete("Company_B");
    }
    
    @Test
    public void updateCompanyTest()
    {
    	Company newCompany = new Company(999,"Company_C");
    	
    	companyController.updateCompanyByName(newCompany);
         
        verify(companyBusinessImpl, times(1)).update(newCompany);
    }


}
