package solution;
import java.util.*;
import java.io.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        File r = new File("Directory");   //Get the directory
        for ( File file : r.listFiles())
        {
            printFilesRecursive(file);         //Get the sub directory recursively
        }
    }
    private static void printFilesRecursive(File file)
    {
        for(File files : file.listFiles())
        {
            if(files.isDirectory())
            {
                printFilesRecursive(files);  //if file is directory call recursive function again
            }
            else
            {   //prints the phone number from txt files
                try (BufferedReader br = new BufferedReader(new FileReader(files))) 
                {
                    String line;
                    while ((line = br.readLine()) != null) 
                    {
                        String[] numbers = line.split(" ");    //Split space
                        for(String number: numbers)
                        {
                            System.out.println(number);
                        }
                    }
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
