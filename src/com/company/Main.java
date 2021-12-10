package com.company;

import com.company.employee.Employee;
import com.company.parser.JsonParser;
import com.company.parser.XmlParser;

import java.util.List;

/**
 * @author Arman Karapetyan
 */

public class Main {

    public static void main(String[] args) {

        XmlParser parse = new XmlParser();
        JsonParser jsonParser = new JsonParser();

        List<Employee> employees = parse.XmlParseToClass("file.xml");
        Employee employee = jsonParser.JsonParseToClass("file2.json");

        for (Employee employee1 : employees) {
            System.out.println("Id: " + employee1.getId());
            System.out.println("First name: " + employee1.getFirstName());
            System.out.println("Last name: " + employee1.getLastName());
            System.out.println("Salary: " + employee1.getSalary());
            System.out.println();
        }

        System.out.println("Id: " + employee.getId());
        System.out.println("First name: " + employee.getFirstName());
        System.out.println("Last name: " + employee.getLastName());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println();

    }
    
}
