package com.company.parser;

import com.company.employee.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arman Karapetyan
 */

public class JsonParser {

    public Employee JsonParseToClass(String url) {

        long id = 0;
        String firstName = null;
        String lastName = null;
        float salary = 0;

        List<String> list = new ArrayList<>();
        String line;

        try {

            File file = new File(url);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

            list.remove(0);
            list.remove(list.size() - 1);

            for (int i = 0; i < list.size() - 1; i++) {

                String[] strings = list.get(i).split(":");

                switch (i) {
                    case 0 -> id = Long.parseLong(strings[1].replace(",", "").replace("\"", "").trim());
                    case 1 -> firstName = strings[1].replace(",", "").replace("\"", "").trim();
                    case 2 -> lastName = strings[1].replace(",", "").replace("\"", "").trim();
                    case 3 -> salary = Float.parseFloat(strings[1].replace(",", "").replace("\"", "").trim());
                }

            }

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Employee(id, firstName, lastName, salary);
    }

}
