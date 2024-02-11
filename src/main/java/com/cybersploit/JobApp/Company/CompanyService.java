package com.cybersploit.JobApp.Company;

import org.springframework.stereotype.Service;

import java.util.List;
public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    Company createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
