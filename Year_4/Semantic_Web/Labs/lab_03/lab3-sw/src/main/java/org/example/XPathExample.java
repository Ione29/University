package org.example;

import java.io.IOException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XPathExample {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {        

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);

        DocumentBuilder builder = domFactory.newDocumentBuilder();

        // Ex 1)
        Document doc = builder.parse(ClassLoader.getSystemResourceAsStream("link.xml"));
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile("/document/reference/@href");
        String hrefValue = (String) expr.evaluate(doc, XPathConstants.STRING);
        System.out.println("Task 1: href value = " + hrefValue);

        // Ex 2)
        Document jobsDoc = builder.parse(ClassLoader.getSystemResourceAsStream("jobs.xml"));
        expr = xpath.compile("count(/jobs/job[@priority='low'])");
        Double lowPriorityCount = (Double) expr.evaluate(jobsDoc, XPathConstants.NUMBER);
        System.out.println("Task 2: Number of jobs with priority 'low': " + lowPriorityCount);

        // Ex 3)
        Document personsDoc = builder.parse(ClassLoader.getSystemResourceAsStream("germans.xml"));
        expr = xpath.compile("/persons/person[@age > 35]");
        NodeList olderPersons = (NodeList) expr.evaluate(personsDoc, XPathConstants.NODESET);
        System.out.println("Task 3: Persons older than 35:");
        for (int i = 0; i < olderPersons.getLength(); i++) {
            Element person = (Element) olderPersons.item(i);
            System.out.println(" - " + person.getAttribute("firstName") + " " + person.getAttribute("lastName"));
        }

        //Ex 4)
        expr = xpath.compile("/persons/person[starts-with(@lastName, 'H')]");
        NodeList lastNameH = (NodeList) expr.evaluate(personsDoc, XPathConstants.NODESET);
        System.out.println("Task 4: Persons with last name starting with 'H':");
        for (int i = 0; i < lastNameH.getLength(); i++) {
            Element person = (Element) lastNameH.item(i);
            System.out.println(" - " + person.getAttribute("firstName") + " " + person.getAttribute("lastName"));
        }

        // Ex 5)
        expr = xpath.compile("/persons/person[string-length(@firstName) < 5]");
        NodeList shortFirstNames = (NodeList) expr.evaluate(personsDoc, XPathConstants.NODESET);
        System.out.println("Task 5: Persons with first name smaller than 5 letters:");
        for (int i = 0; i < shortFirstNames.getLength(); i++) {
            Element person = (Element) shortFirstNames.item(i);
            System.out.println(" - " + person.getAttribute("firstName") + " " + person.getAttribute("lastName"));
        }
    }
}