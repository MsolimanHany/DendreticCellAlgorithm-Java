/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dendreticcellalgorithm;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author MohamedDev
 */
public class AntigenGenerator {
    
    
   static int num_antigen=2000;
static int kinds_ofantigens = 4;
       
    
    
    
    
    public static void main(String Args[]) throws InterruptedException
    {
        
    ArrayList<String> antigen_kind = new ArrayList<>();
    // please add your antige names here
        antigen_kind.add("ag1");
        
        antigen_kind.add("ag2");
        antigen_kind.add("ag3");
        antigen_kind.add("ag4");
            antigen_kind.add("ag5");
        antigen_kind.add("ag6");

        
        for(int i=0 ; i<num_antigen;i++)
        {
            if(i%5 == 0)
            {
                System.out.println();
            } 
         int randomNum = ThreadLocalRandom.current().nextInt(0, (kinds_ofantigens-1) + 1);
            System.out.print(antigen_kind.get(randomNum));
            System.out.print(",");

        }
                System.out.println("   Copy your result");

        
    }
        
    
}
