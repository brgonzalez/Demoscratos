package com.itcr.demoscratos.services;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {


    public void createDirectory(String path){
        if(!exists(path)){
            (new File(path)).mkdir();
        }
    }

    public void createFile(String file){
        if(!exists(file)){
            try {
                (new File(file)).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean exists(String path){
        return (new File(path)).exists();
    }


    public void writeFile(String path, String content){
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<String> read(String path){
        List<String> file = new ArrayList<String>();
        BufferedReader br;
        String line;

        try {

            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                file.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }



    public String readFile(String path){
        String file = "";
        BufferedReader br;
        String line;

        try {

            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                file+=line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    
    public void delete(String path){
    	try{
            if((new File(path)).delete()){
    			System.out.println("File is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}

    	}catch(Exception e){

    		e.printStackTrace();

    	}

    }
    
    public static void main(String[] args){
    	FileService s = new FileService();
    	s.writeFile("test.tex", "Test");
    }
}