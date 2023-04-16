
package com.pocan.portscanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pocan
 */
public class FileModule {
    
    public void createFolder() {
        String path = System.getProperty("user.dir") + File.separator + "Scans";
        File customDir = new File(path);
        if (customDir.exists()) {
            System.out.println(customDir + " already exists");
        } else if (customDir.mkdirs()) {
            System.out.println(customDir + " was created");
        } else {
            System.out.println(customDir + " was not created");
        }
    }
    public void createFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + File.separator + "Scans" + File.separator + fileName + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileModule.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    public void writeFile(String fileName, ArrayList<String> arr) {
        File file = new File(System.getProperty("user.dir") + File.separator + "Scans" + File.separator + fileName + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for(String str: arr) {
              fileWriter.write(str + System.lineSeparator());
            }
            fileWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FileModule.class.getName()).log(Level.SEVERE, null, ex);
        }

 
    }
    
    
    
}
