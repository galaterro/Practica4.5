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


public class FileReader {

    public static void readFile(){
        try{
            File file = new File("fichPersona.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);


            NodeList nl = doc.getElementsByTagName("personas");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                Element elem = (Element) n;

                for (int j = 0; j < ((Element) n).getElementsByTagName("persona").getLength(); j++) {
                    System.out.println(((Element) n).getElementsByTagName("persona").item(j).getAttributes().getNamedItem("id") +"\t\t" + elem.getElementsByTagName("nombre").item(j).getTextContent() + "\t\t" +
                            elem.getElementsByTagName("apellido").item(j).getTextContent() + "\t\t" +
                            elem.getElementsByTagName("profesion").item(j).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
