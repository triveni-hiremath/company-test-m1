package com.company.rest.service.impl;

import com.company.rest.model.Company;
import com.company.rest.repository.CompanyRepository;
import com.company.rest.repository.OwnerRepository;
import com.company.rest.service.CompanyService;
import com.company.rest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.company.rest.exception.CompanyNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

  @Autowired CompanyRepository companyRepository;
  @Autowired OwnerRepository ownerRepository;
  @Autowired OwnerService ownerService;

  @Override
  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }

  @Override
  public List<Company> getAllCompanies() {
    return this.companyRepository.findAll();
  }

  @Override
  public Company getCompanyDetails(long id) {
    Optional<Company> compDb = companyRepository.findById(id);
    if (compDb.isPresent()) {
      return compDb.get();
    } else {
      throw new CompanyNotFoundException();
    }
  }

  @Override
  public Company updateCompanyDetails(Company company) {
    Optional<Company> compDb = companyRepository.findById(company.getId());
    if (compDb.isPresent()) {
      return companyRepository.save(company);
    } else {
      throw new CompanyNotFoundException();
    }
  }
}
