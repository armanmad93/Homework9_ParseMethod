package com.company.parser;

import com.company.employee.Employee;

import java.util.List;

/**
 * @author Arman Karapetyan
 */

public interface Parseable {

    List<Employee> ParseToListOfClass(String url);

}
