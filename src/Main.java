import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {
        try {
            RandomAccessFile ra = new RandomAccessFile(new File("personas.dat"), "rw");
            ra.seek(0);
            String id1 = ra.readLine();
            String name1 = ra.readLine();
            String lastName1 = ra.readLine();
            String job1 = ra.readLine();
            Persona p1 = new Persona(Integer.parseInt(id1), name1, lastName1, job1);

            System.out.println(p1.toString());

            String id2 = ra.readLine();
            String name2 = ra.readLine();
            String lastName2 = ra.readLine();
            String job2 = ra.readLine();
            Persona p2 = new Persona(Integer.parseInt(id2), name2, lastName2, job2);

            System.out.println(p2.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
