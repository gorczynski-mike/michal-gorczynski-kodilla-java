package com.kodilla.hibernate.manytomany.facade;

public class InformationServiceException extends Exception {

    public static final String ERR_COMPANY_NOT_FOUND_ERROR = "Company not found in database.";
    public static final String ERR_EMPLOYEE_NOT_FOUND_ERROR = "Employee not found in database";

    public InformationServiceException(String message) {
        super(message);
    }
}
