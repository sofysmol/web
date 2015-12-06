package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SofySmo
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dao.products.*;

public  class Utils {
    public static Products getArt(String idPicture) throws FileNotFoundException
    {
    /*Scanner in = new Scanner(new File("C:\\Users\\SofySmo\\Documents\\NetBeansProjects\\Febos2\\src\\java\\filename.txt"));
           String filename="";
                
            for(int i=0;i<indexFile+1&&in.hasNextLine(); i++)
                    {
                       filename=in.nextLine();
                     
                    }            
           return SerializeArt.deserializeArt("C:\\Users\\SofySmo\\Documents\\NetBeansProjects\\Febos2\\src\\java\\"+filename)[indexPicture];*/
        Products pr=null;
        try{
            
            ProductService ser=new ProductService();
            int id=Integer.parseInt(idPicture);
            pr=ser.findById(id);
        }
        catch(Exception e)
        {
            
        }
        
        return pr;
    }
    public static String tttt(int i)
    {
        return "gfff";
    }
    public static String[] getArtAsArray(Products art)
    {
        String[] property=new String[7];
        if(art!=null)
        {
            property[0]=art.getAuthor();
            property[1]=art.getName();
            property[2]=art.getDirection();
            property[3]=art.getGenre();
            property[4]=art.getSize();
            property[5]=art.getTechnique();
            property[6]=art.getCountry();
        }else {
            property[0]="no";
            property[1]="no";
            property[2]="no";
            property[3]="no";
            property[4]="no";
            property[5]="no";
            property[6]="no";
        }
        
            return property;
            
    }
}
