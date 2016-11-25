import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileGenerator {
    public static void xmlGenerator(ArrayList<Persona> alPer) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = (Document) implementation.createDocument(null, "personas", null);
            document.setXmlVersion("1.0");
            Element root = document.getDocumentElement();
            for (Persona p: alPer) {
                Element elemPersona = document.createElement("persona");

                Element elemName = document.createElement("nombre");
                Text textNode = document.createTextNode(p.getName());
                elemName.appendChild(textNode);

                Element elemLastNAme = document.createElement("apellido");
                Text textNode1 = document.createTextNode(p.getLastName());
                elemLastNAme.appendChild(textNode1);

                Element elemJob = document.createElement("profesion");
                Text textNode2 = document.createTextNode(p.getJob());
                elemJob.appendChild(textNode2);


                elemPersona.setAttribute("id", Integer.toString(p.getId()));
                elemPersona.appendChild(elemName);
                elemPersona.appendChild(elemLastNAme);
                elemPersona.appendChild(elemJob);

                root.appendChild(elemPersona);
            }


            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("fichPersona.xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
