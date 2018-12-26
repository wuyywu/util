package com.hundsun.study;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.Iterator;

/**
 * Created by
 *
 * @author huanghang19190
 * @Description
 * @date 2018/6/14
 */
public class TextParseXml {
    public static void main(String[]args) throws Exception {
        File file = new File("F:\\22222.xml");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\wuyun11584\\Desktop\\CP42D45B7D705BDA.xml"),"GBK");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:\\22222.xml"));
        int n = 0;
        String text = null;
        while((text=bufferedReader.readLine()).trim().equals("")){
            System.out.println(text);
        }

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(bufferedReader);
        Element element = document.getRootElement();
        Element ss = element.element("ROWDATA");
        for (Iterator j = ss.elementIterator(); j.hasNext(); ) {
            Element node = (Element) j.next();
            Attribute attribute = node.attribute("CpTime");
            System.out.println(attribute.getName() + ":" + attribute.getValue());
        }
        bufferedReader.close();
    }
}
