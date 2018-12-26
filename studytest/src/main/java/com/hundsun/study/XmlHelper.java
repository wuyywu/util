package com.hundsun.study;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/6/1 10:16
 */
public class XmlHelper {
    private static final Log log = LogFactory.getLog(XmlHelper.class);

    private DocumentBuilderFactory documentBuildFactory = DocumentBuilderFactory.newInstance();
    //
    private DocumentLoader         documentLoader       = new DefaultDocumentLoader();

    private ErrorHandler errorHandler = new SimpleSaxErrorHandler(log);

    private XmlValidationModeDetector validationModeDetector = new XmlValidationModeDetector();

    private EntityResolver entityResolver;

    public XmlHelper() {
        this(ClassUtils.getDefaultClassLoader());
    }

    public XmlHelper(ClassLoader classLoader) {
        this.entityResolver = new PluggableSchemaResolver(classLoader);
    }

    public Document parse(Resource resource) throws Exception {
        return documentBuildFactory.newDocumentBuilder().parse(resource.getInputStream());
    }

    public static void main(String[] args) throws Exception {
        XmlHelper xmlHelper = new XmlHelper();
        File file = new File("C:\\Users\\wuyun11584\\Desktop\\银联对账文件\\D585CF344EE0A431.xml");
        if (file.isFile() && file.exists()){
            System.out.println(file);
        }
        Resource resource = new FileSystemResource(file);
        InputStream is = resource.getInputStream();
        InputStreamReader read = new InputStreamReader(is, "GBK");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt;
        while ((lineTxt = bufferedReader.readLine()) != null){
            System.out.println(lineTxt);
        }

        Document document = xmlHelper.parse(resource);
        NodeList nodeList = document.getElementsByTagName("ROW");
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NamedNodeMap map = node.getAttributes();
                System.out.println(map.getNamedItem("CpTime").getNodeValue());

            }
        }


//        File f = new File("C:\\Users\\wuyun11584\\Desktop\\对账文件\\银联\\CP2999ECCA294004.xml");
////        SAXReader reader = new SAXReader();
////        Document doc = reader.read(f);
//        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = factory.newDocumentBuilder();
//        Document doc = db.parse(f);
//         NodeList nl = doc.getElementsByTagName("bean");
//        Element root = doc.getDocumentElement();
//        NodeList list = root.getElementsByTagName("ROW");



    }
}
