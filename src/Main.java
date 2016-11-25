import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<Persona> alp1 = new ArrayList<>();
            RandomAccessFile ra = new RandomAccessFile(new File("personas.dat"), "rw");
            ra.seek(0);
            String id1 = ra.readLine();
            String name1 = ra.readLine();
            String lastName1 = ra.readLine();
            String job1 = ra.readLine();
            Persona p1 = new Persona(Integer.parseInt(id1), name1, lastName1, job1);

            alp1.add(p1);


            String id2 = ra.readLine();
            String name2 = ra.readLine();
            String lastName2 = ra.readLine();
            String job2 = ra.readLine();
            Persona p2 = new Persona(Integer.parseInt(id2), name2, lastName2, job2);

            alp1.add(p2);
            FileGenerator.xmlGenerator(alp1);
            FileReader.readFile();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
