package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InformationServiceFacadeTest {

    @Autowired
    private InformationServiceFacade informationServiceFacade;

    @Autowired
    private CompanyDao companyDao;

    @Before
    public void setUpDatabase() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee johnatanSmitty = new Employee("Johnatan", "Smitty");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Matters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(johnatanSmitty);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        johnatanSmitty.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }

    @Transactional
    @Test
    public void shouldFindEmployeesByFirstNameFragment() throws InformationServiceException {
            List<Employee> ohResultList = informationServiceFacade.getEmployeesWithNameLike("oh");
            List<Employee> ohnaResultList = informationServiceFacade.getEmployeesWithNameLike("ohna");

            assertEquals(2, ohResultList.size());
            assertEquals(1, ohnaResultList.size());
    }

    @Transactional
    @Test
    public void shouldFindEmployeesByLastNameFragment() throws InformationServiceException {
            List<Employee> sResultList = informationServiceFacade.getEmployeesWithNameLike("s");
            List<Employee> smitResultList = informationServiceFacade.getEmployeesWithNameLike("smit");
            List<Employee> ittyResultList = informationServiceFacade.getEmployeesWithNameLike("itty");

            assertEquals(3, sResultList.size());
            assertEquals(2, smitResultList.size());
            assertEquals(1, ittyResultList.size());
    }

    @Transactional
    @Test
    public void shouldFindEmployeesByFirstNameOrLastNameFragment() throws InformationServiceException {
            List<Employee> oResultList = informationServiceFacade.getEmployeesWithNameLike("o");

            assertEquals(3, oResultList.size());
    }

    @Transactional
    @Test
    public void testCompanySearchFunction() throws InformationServiceException {
            List<Company> softResultList = informationServiceFacade.getCompaniesWithNameLike("soft");
            List<Company> attResultList = informationServiceFacade.getCompaniesWithNameLike("att");
            List<Company> mResultList = informationServiceFacade.getCompaniesWithNameLike("m");

            assertEquals(1, softResultList.size());
            assertEquals(2, attResultList.size());
            assertEquals(3, mResultList.size());
    }
}