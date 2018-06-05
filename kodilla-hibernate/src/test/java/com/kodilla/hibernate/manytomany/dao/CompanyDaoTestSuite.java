package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
    }

    @Transactional
    @Test
    public void testGetEmployeesWithLastName() {
        //Given
        Employee employee1 = new Employee("Adam", "Adams");
        Employee employee2 = new Employee("Mike", "Adams");
        Employee employee3 = new Employee("Bob", "Terry");
        Employee employee4 = new Employee("John", "Andersen");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);
        List<Employee> adamsList = employeeDao.getEmployeesWithLastName("Adams");
        List<Employee> terryList = employeeDao.getEmployeesWithLastName("Terry");
        List<Employee> otherList = employeeDao.getEmployeesWithLastName("Other");

        //Then
        Assert.assertEquals(2,adamsList.size());
        Assert.assertEquals(1,terryList.size());
        Assert.assertEquals(0,otherList.size());
    }

    @Transactional
    @Test
    public void testGetCompaniesWithNameStartingWith() {
        //Given
        Company company1 = new Company("abcCompany");
        Company company2 = new Company("abcCorporation");
        Company company3 = new Company("cbaBusiness");
        Company company4 = new Company("zzzCompany");

        //When
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        List<Company> abcList = companyDao.getCompaniesWithNameStartingWith("abc");
        List<Company> cbaList = companyDao.getCompaniesWithNameStartingWith("cba");
        List<Company> otherList = companyDao.getCompaniesWithNameStartingWith("other");

        //Then
        Assert.assertEquals(2, abcList.size());
        Assert.assertEquals(1, cbaList.size());
        Assert.assertEquals(0, otherList.size());
    }

}
