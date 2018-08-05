package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(InformationServiceFacade.class);

    List<Employee> getEmployeesWithNameLike(String nameFragment) throws InformationServiceException {
        LOGGER.info("Trying to find employees with name containing: " + nameFragment);
        List<Employee> results = employeeDao.findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(nameFragment, nameFragment);
        if(results.size() == 0) {
            LOGGER.error(InformationServiceException.ERR_EMPLOYEE_NOT_FOUND_ERROR);
            throw new InformationServiceException(InformationServiceException.ERR_EMPLOYEE_NOT_FOUND_ERROR);
        }
        LOGGER.info(results.size() + " employees were successfully found.");
        return results;
    }

    List<Company> getCompaniesWithNameLike(String nameFragment) throws InformationServiceException {
        LOGGER.info("Trying to find companies with name containing: " + nameFragment);
        List<Company> results = companyDao.findByNameContainingIgnoreCase(nameFragment);
        if(results.size() == 0) {
            LOGGER.error(InformationServiceException.ERR_COMPANY_NOT_FOUND_ERROR);
            throw new InformationServiceException(InformationServiceException.ERR_COMPANY_NOT_FOUND_ERROR);
        }
        LOGGER.info(results.size() + " companies were successfully found.");
        return results;
    }

}
