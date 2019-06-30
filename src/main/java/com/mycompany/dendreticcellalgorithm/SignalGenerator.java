/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dendreticcellalgorithm;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author MohamedDev
 */
public class SignalGenerator {
    /*
    
    pease change these values
    
    */
    
      static int num_of_values_persignal = 50;
       static int min = 10;
        static int max = 1000;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      public static void main(String Args[])
    {
        
     
          
        for(int i=0;i<num_of_values_persignal;i++)
        {
              int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            System.out.print(randomNum);
                        System.out.print(","); 
                        
        }
        System.out.println("Copy your result");
         
        
    }
    
}
