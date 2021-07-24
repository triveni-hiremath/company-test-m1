package com.company.rest.controller;

import com.company.rest.model.Company;
import com.company.rest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;


    /* Api to Create new   company */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    /* Api to Get a list of all companies */
    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /* Api to Get details about a company */
    @GetMapping("/{id}")
    public Company getCompanyDetails(@PathVariable long id) {
        return companyService.getCompanyDetails(id);
    }

    /*  Api to Update a company  */
    @PutMapping("/{id}")
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompanyDetails(company);
    }
}
