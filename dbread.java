import java.io.*;
import java.util.*;
public class dbread extends dbwrite
{
    Scanner sr= null;
    public void read(){

        try
        {
            sr= new Scanner("db.txt");
        }
        catch(Exception e)
        {
            System.out.print("reading");

        }

    }
}