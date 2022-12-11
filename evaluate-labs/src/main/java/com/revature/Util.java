package com.revature;

public class Util {
    public static Lab getDataFromLine(String line){
        String[] vals = line.split(",");

        Lab lab = new Lab();
        lab.setLabName(vals[0]);
        lab.setNumOfTests(Integer.parseInt(vals[1]));
        lab.setNumOfTestsPassed(Integer.parseInt(vals[2]));
        lab.setNumOfTestsFailed(Integer.parseInt(vals[3]));
        lab.percentCompleted(Double.parseDouble(vals[4]));

        return lab;
    }

}
