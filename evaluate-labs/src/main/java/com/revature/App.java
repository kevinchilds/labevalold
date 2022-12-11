package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectMapper om = new ObjectMapper();
        List<Lab> labs = new ArrayList<>();
        //check that filename was provided
        if(args.length != 2){
            System.out.println("Not enough arguments provided");
            return;
        }
        
        try{  
            File file = new File(args[0]);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
            String line; 
            Boolean firstLine = true; 
            
            while((line=br.readLine())!=null)  {  
                if(firstLine == true){
                    firstLine = false;
                    continue;
                }

                Lab lab = Util.getDataFromLine(line);
                labs.add(lab);
            }  

            fr.close();
        
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        } 


        //calculate percentage complete

        double sum = 0.0;
        for(Lab lab : labs){
            if(lab.getPercentCompleted() == 100.0) sum += lab.getPercentCompleted();
        }

        Report report = new Report();

        report.setLabs(labs);
        report.setProgressPercentage(sum / labs.size());


        ///append to file
        FileWriter fw;
        BufferedWriter bw; 
        try {
            fw = new FileWriter(args[1], true);
            bw = new BufferedWriter(fw);
            bw.write(om.writeValueAsString(report));

            bw.newLine();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
