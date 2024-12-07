package edu.neu.csye7374.FileUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GeneralFileUtil {
    /** 
     * @param filename name of file
     * @param data to write to file
     * @param isCleanWrite is false for appending to file
     */
    
    private static String baseDirectory = "src/main/java/edu/neu/csye7374/datastore/";
    public static void writeFile(String filename, String data, boolean isCleanWrite) {
        writeFile(filename, data, isCleanWrite, baseDirectory);
    }
    
    public static void writeFile(String filename, String data, boolean isCleanWrite, String basePath) {
        String filePath = basePath + filename;
        try (FileWriter fileWriter = new FileWriter(filePath, !isCleanWrite)) {
            fileWriter.append(data + "\n");
            fileWriter.close();
        } catch(Exception e) {
            System.err.println("Error writing to file: " + filePath + " data: " + data + " isCleanWrite: " + isCleanWrite);
        }
    }
    
    public static List<String> readFile(String filename) {        
        return readFile(filename, baseDirectory);
    }
    
    public static List<String> readFile(String filename, String basePath) {
        String filePath = basePath + filename;
        List<String> data = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new FileReader(filePath));) {
            while(scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
        } catch(Exception e) {
            System.err.println("Error reading from file: " + filename + " basepath: " + basePath);
        }
        
        return data;
    }
}
