package org.example;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("students.xml"));
        List<Student> stuList = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Student stu = new Student();
                stu.id = node.getAttributes().getNamedItem("id").getNodeValue();
                NodeList childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().getTextContent().trim();

                        switch (cNode.getNodeName()) {
                            case "firstName":
                                stu.firstName = content;
                                break;
                            case "lastName":
                                stu.lastName = content;
                                break;
                            case "location":
                                stu.location = content;
                                break;
                        }
                    }
                }
                stuList.add(stu);
            }
        }

        for (Student s : stuList) {
            System.out.println(s);
        }
    }
}