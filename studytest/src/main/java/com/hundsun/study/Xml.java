package com.hundsun.study;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/6/1 14:31
 */
import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

//将XML中的节点以对象的方式进行封装
class XMLObject{
    private String name,grade,age;
    public XMLObject(String name,String grade,String age) {
        this.name=name;
        this.grade=grade;
        this.age=age;

    }
    //返回一个XML的节点类Element
    public Element getXMLObject(Document doc) throws ParserConfigurationException{

        //通过Document类的createElement创建一个节点
        Element Name = doc.createElement("name");
        Element Grade= doc.createElement("grade");
        Element Age =doc.createElement("age");
        Element Student=doc.createElement("student");
        //Element类的setTextContent(String textContent)方法设置节点值
        Name.setTextContent(name);
        Grade.setTextContent(grade);
        Age.setTextContent(age);
        Student.appendChild(Name);
        Student.appendChild(Grade);
        Student.appendChild(Age);
        return Student;
    }
}

public class Xml{


    public static void createXML(String XMLname)throws ParserConfigurationException, TransformerException, IOException{
        //创建一个Document类
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        //创建一个根节点，并且将根节点添加到Document对象中去
        Element root=doc.createElement("students");
        doc.appendChild(root);
        //使用ArryayList，便于添加自己所创建的对象
        ArrayList<XMLObject> stu=new ArrayList<XMLObject>();
        stu.add(new XMLObject("Jhon","B","12"));
        stu.add(new XMLObject("Mary","A","11"));
        stu.add(new XMLObject("Simon","A","18"));
        //将ArrayList里面的对象全部添加到根节点中去
        for(XMLObject t:stu){
            root.appendChild(t.getXMLObject(doc));
        }
        //开始把Document映射到文件
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transFormer = transFactory.newTransformer();
        //设置输出结果并且生成XML文件
        DOMSource domSource = new DOMSource(doc);
        File file = new File(XMLname);
        if (!file.exists())  file.createNewFile();
        //设置输入源并且输出XML文件
        FileOutputStream out = new FileOutputStream(file);
        StreamResult xmlResult = new StreamResult(out);//设置输入源
        transFormer.transform(domSource, xmlResult);//输出xml文件
        System.out.println(file.getAbsolutePath());//测试文件输出的路径
    }
    public static void parseXML(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileName);
            if (file.exists()) {
                Document doc = db.parse(file);
                Element docEle = doc.getDocumentElement();

                // Print root element of the document
                System.out.println("Root element of the document: "
                        + docEle.getNodeName());

                NodeList studentList = docEle.getElementsByTagName("student");

                // Print total student elements in document
                System.out.println("Total students: " + studentList.getLength());

                if (studentList != null && studentList.getLength() > 0) {
                    for (int i = 0; i < studentList.getLength(); i++) {

                        Node node = studentList.item(i);

                        if (node.getNodeType() == Node.ELEMENT_NODE) {

                            System.out.println("=====================");

                            Element e = (Element) node;
                            NodeList nodeList = e.getElementsByTagName("name");
                            System.out.println("Name: "
                                    + nodeList.item(0).getChildNodes().item(0)
                                    .getNodeValue());

                            nodeList = e.getElementsByTagName("grade");
                            System.out.println("Grade: "
                                    + nodeList.item(0).getChildNodes().item(0)
                                    .getNodeValue());

                            nodeList = e.getElementsByTagName("age");
                            System.out.println("Age: "
                                    + nodeList.item(0).getChildNodes().item(0)
                                    .getNodeValue());
                        }
                    }
                } else {
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //测试
    public static void main(String []args) throws ParserConfigurationException, TransformerException, IOException{
        Xml.createXML("C:\\Users\\wuyun11584\\Desktop\\对账文件\\Student.xml");
        Xml.parseXML("C:\\Users\\wuyun11584\\Desktop\\对账文件\\Student.xml");
    }
}