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

        XmlParser xmlParser = new XmlParser();
        JsonParser jsonParser = new JsonParser();

        List<Employee> employeesXml = xmlParser.ParseToListOfClass("file.xml");
        List<Employee> employeesJson = jsonParser.ParseToListOfClass("file2.json");

        System.out.println("XML file:" + "\n");
        for (Employee employee : employeesXml) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getSalary());
        }

        System.out.println();

        System.out.println("JSON file:" + "\n");
        for (Employee employee : employeesJson) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getSalary());
        }

    }

}
