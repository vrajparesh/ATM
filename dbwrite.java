import java.io.*;
import java.util.*;

public class dbwrite
{

    public static void fr(int bal) {

        System.out.println ("Storing Your Balance.");

        File file = new File("db.txt");
        // creates the file
        try {
            file.createNewFile();
        } catch (Exception c) {
            System.out.println (c);
        }
        // creates a FileWriter Object
        FileWriter writer = null;
        try {
            writer = new FileWriter(file); 
        } catch (Exception e) {
            System.out.println (e);
        }
        // Writes the content to the file
        try {
            writer.write("\n"+bal);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println (e);
        }

        /*//Creates a FileReader Object
        FileReader fr = new FileReader(file); 
        int [] a = new int[50];
        fr.read(a); // reads the content to the array
        for(int c : a)
        System.out.print(c); //prints the characters one by one
        fr.close();
         */
        Scanner sc = null;
        try {
            sc = new Scanner (file);
        } catch (Exception e) {
            System.out.println (e);
        }

        System.out.println (sc.nextInt() + "Stored");
    }
}