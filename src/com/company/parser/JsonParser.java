package com.company.parser;

import com.company.employee.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arman Karapetyan
 */

public class JsonParser implements Parseable {

    public List<Employee> ParseToListOfClass(String url) {

        long id = 0;
        String firstName = null;
        String lastName = null;
        float salary = 0;

        List<Employee> employees = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> developedList = new ArrayList<>();

        try {

            File file = new File("file2.json");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

            list.replaceAll(String::trim);

            for (String s : list) {
                if (s.equals("{") ||
                        s.equals("\"Employees\": [") ||
                        s.equals("}") ||
                        s.equals("},") ||
                        s.equals("]") ||
                        s.equals("")) {

                    continue;

                }

                developedList.add(s);

            }

            for (int i = 1; i <= developedList.size(); i++) {

                String[] strings = developedList.get(i - 1).split(": ");

                switch ((i - 1) % 4) {
                    case 0 -> id = Long.parseLong(strings[1].replace(",", "").replace("\"", "").trim());
                    case 1 -> firstName = strings[1].replace(",", "").replace("\"", "").trim();
                    case 2 -> lastName = strings[1].replace(",", "").replace("\"", "").trim();
                    case 3 -> salary = Float.parseFloat(strings[1].replace(",", "").replace("\"", "").trim());
                }

                if (i % 4 == 0) {
                    employees.add(new Employee(id, firstName, lastName, salary));
                }

            }

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;

    }

}
