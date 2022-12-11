package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        ObjectMapper om = new ObjectMapper();
        Lab lab = new Lab();
        //check that filename was provided
        if(args.length != 2){
            System.out.println("Not enough arguments provided");
            return;
        }

        String name = "";
        int testCounter=0;
        int failureCounter=0;
        try{  
            File file = new File(args[0]);    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            
            while((line=br.readLine())!=null)  {  
                //if line is short, go to next line
                if(line.length() < 11) continue;

                //store testsuite name
                if(line.substring(0,10).equals("<testsuite")){
                    String[] vals = line.split("\"");
                    lab.setLabName(vals[5]);
                }

                //find number of tests
                if(line.substring(0,11).equals("  <testcase")){
                    lab.setNumOfTests(lab.getNumOfTests() + 1);
                } 

                if(line.substring(0,11).equals("    <failur")){
                    lab.setNumOfTestsFailed(lab.getNumOfTestsFailed() + 1);
                }
                
            }  

            fr.close();
        
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        }  

        lab.setNumOfTestsPassed(lab.getNumOfTests() - lab.getNumOfTestsFailed());
        lab.setPercentCompleted(((double) lab.getNumOfTestsPassed() / lab.getNumOfTests()) * 100);



        ///append to file
        FileWriter fw;
        BufferedWriter bw; 
        try {
            fw = new FileWriter(args[1], true);
            bw = new BufferedWriter(fw);

            if(Util.isFileNew(args[1])){
                bw.write("Lab Name,Amount of Tests,Amount Passed,Amount Failed,Percent Complete");
                bw.newLine();
            }

            bw.write(lab.getLabName() + "," +
                    lab.getNumOfTests() + "," +
                    lab.getNumOfTestsPassed() + "," +
                    lab.getNumOfTestsFailed() + "," +
                    lab.getPercentCompleted()
            );

            bw.newLine();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
