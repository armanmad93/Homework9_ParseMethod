package com.company.parser;

import com.company.employee.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arman Karapetyan
 */

public class XmlParser {

    public List<Employee> XmlParseToClass(String url) {

        List<Employee> employees = new ArrayList<>();
        File file = new File(url);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList employeeList = document.getElementsByTagName("employee");

            for (int i = 0; i < employeeList.getLength(); i++) {

                Node node = employeeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    employees.add(new Employee(Long.parseLong(element.getAttribute("id")),
                            document.getElementsByTagName("firstname").item(i).getTextContent(),
                            document.getElementsByTagName("lastname").item(i).getTextContent(),
                            Float.parseFloat(document.getElementsByTagName("salary").item(i).getTextContent())));

                }

            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return employees;

    }

}
