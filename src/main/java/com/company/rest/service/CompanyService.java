package com.company.rest.service;

import com.company.rest.model.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyDetails(long id);

    Company updateCompanyDetails(Company company);
}
