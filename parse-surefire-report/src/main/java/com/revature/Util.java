package com.revature;

import java.io.File;

public class Util {
    public static boolean isFileNew(String fileName){
        File file = new File(fileName);

        return file.length() == 0;
    }
}
