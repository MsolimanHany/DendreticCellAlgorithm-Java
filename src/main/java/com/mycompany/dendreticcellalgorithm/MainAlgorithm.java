/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dendreticcellalgorithm;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author MohamedDev
 */
public class MainAlgorithm {
        private static final String FILE_NAME = "D:\\new.xlsx";
       static int num_of_DC = 0;
       static boolean flag = true;
              static boolean flag2 = true;
       static String signals_path="";

       static String antigen_path="";
       static int num_of_Antigen = 0;
       static ArrayList<String>antigen_vector;
              static ArrayList<Double>pamp1;
       static ArrayList<Double>pamp2;
       static ArrayList<Double>Danger1;
       static ArrayList<Double>Danger2;
       static ArrayList<Double>safe1;
       static ArrayList<Double>safe2;
       static ArrayList<Double>inflam;
       
       
       
       
              static ArrayList<String>pamp1_str;
       static ArrayList<String>pamp2_str;
       static ArrayList<String>Danger1_str;
       static ArrayList<String>Danger2_str;
       static ArrayList<String>safe1_str;
       static ArrayList<String>safe2_str;
       static ArrayList<String>inflam_str;
       
       
       static String signal1="";
  static      String signal2="";
 static      String signal3="";
   static    String signal4="";
   static    String signal5="";
   static    String signal6="";
   static    String signal7="";



    public static void main(String Args[]) throws FileNotFoundException, IOException, InterruptedException
    {
        String answer = "No";
        Integer T=0;
        Integer R=0;
                pamp1 = new ArrayList<>();
                pamp2 = new ArrayList<>();
                Danger1 = new ArrayList<>();
                Danger2 = new ArrayList<>();
                safe1 = new ArrayList<>();
                safe2 = new ArrayList<>();
                inflam = new ArrayList<>();
                
                 pamp1_str = new ArrayList<>();
                pamp2_str = new ArrayList<>();
                Danger1_str = new ArrayList<>();
                Danger2_str = new ArrayList<>();
                safe1_str = new ArrayList<>();
                safe2_str = new ArrayList<>();
                inflam_str = new ArrayList<>();

        antigen_vector = new ArrayList<>();
        Scanner in = new Scanner(System.in);
in.useDelimiter("\\n");
        System.out.println("     ***Dendretic Cell Machine***     ");
        
        /*
        Check for Dc Validation Number
        */
        do
        {
            flag=true;
      answer = "No";

        while (flag) {
              pamp1 = new ArrayList<>();
                pamp2 = new ArrayList<>();
                Danger1 = new ArrayList<>();
                Danger2 = new ArrayList<>();
                safe1 = new ArrayList<>();
                safe2 = new ArrayList<>();
                inflam = new ArrayList<>();
                
                 pamp1_str = new ArrayList<>();
                pamp2_str = new ArrayList<>();
                Danger1_str = new ArrayList<>();
                Danger2_str = new ArrayList<>();
                safe1_str = new ArrayList<>();
                safe2_str = new ArrayList<>();
                inflam_str = new ArrayList<>();
            flag2 = true;
      System.out.println("Step1 : Please Enter number of your DC's or cells");

            if(in.hasNextInt())
                    {
            
          num_of_DC = in.nextInt();

              if(num_of_DC>=1)
              {
                 
                   while(flag2)
        {
      System.out.println("Step2 : Please Enter path of your signals File.txt ");
  
if(in.hasNext())
{
        signals_path = in.next();
        File path = new File(signals_path);
        if(path.exists()&&signals_path.contains(".txt"))
        {
            System.out.println("Your Path Is Valid Ok");
            
              System.out.println("Wait ..... we are sacan your signals file");
        
      BufferedReader signals = new BufferedReader(new FileReader(signals_path));
      String line="";
      String All="";
while((line = signals.readLine()) != null)
{
    All = All + line;

}
All = All.replaceAll("\\s","");
All = All.toLowerCase();
signal1 = StringUtils.substringBetween(All,"pamp1{", "}");
signal2 = StringUtils.substringBetween(All,"pamp2{", "}");
signal3 = StringUtils.substringBetween(All,"danger1{", "}");
signal4 = StringUtils.substringBetween(All,"danger2{", "}");
signal5 = StringUtils.substringBetween(All,"safe1{", "}");
signal6 = StringUtils.substringBetween(All,"safe2{", "}");
signal7 = StringUtils.substringBetween(All,"inflam{", "}");
if(signal1 == null||signal2 == null||signal3 == null||signal4 == null||signal5 == null||signal6 == null||signal7 == null)
{
     System.out.println("Your signals file  contains invalid data please Enter your file again and also DC number ");
        flag2= false;
}
else
{
    
pamp1_str = new ArrayList (Arrays.asList(signal1.split(",")));

pamp2_str = new ArrayList (Arrays.asList(signal2.split(",")));
Danger1_str = new ArrayList (Arrays.asList(signal3.split(",")));
Danger2_str = new ArrayList (Arrays.asList(signal4.split(",")));
safe1_str = new ArrayList (Arrays.asList(signal5.split(",")));
safe2_str = new ArrayList (Arrays.asList(signal6.split(",")));
inflam_str = new ArrayList (Arrays.asList(signal7.split(",")));

if(pamp1_str.size()!=num_of_DC ||pamp2_str.size()!=num_of_DC||Danger1_str.size()!=num_of_DC||Danger2_str.size()!=num_of_DC||safe1_str.size()!=num_of_DC||safe2_str.size()!=num_of_DC||inflam_str.size()!=num_of_DC)
{
     System.out.println("Your signals file  contains invalid data please Enter your file again and also DC number ");
        flag2= false;
    
}
else
{
    boolean isTrue = true;
    for(int i=0;i<num_of_DC;i++)
    {
      Double number = 0.0;
      try
      {
    number = Double.parseDouble(pamp1_str.get(i));
    pamp1.add(number);
    
     number = Double.parseDouble(pamp2_str.get(i));
    pamp2.add(number);
    
     number = Double.parseDouble(Danger1_str.get(i));
    Danger1.add(number);
    
     number = Double.parseDouble(Danger2_str.get(i));
    Danger2.add(number);
    
     number = Double.parseDouble(safe1_str.get(i));
    safe1.add(number);
    
     number = Double.parseDouble(safe2_str.get(i));
    safe2.add(number);
    
     number = Double.parseDouble(inflam_str.get(i));
    inflam.add(number);
          
      }
      catch (NumberFormatException e)
      {
          isTrue = false;
 System.out.println("Your signals file  contains invalid data please Enter your file again and also DC number ");
        flag2= false;          
      }
        
        
        
        
    }
    if(isTrue)
    {
        flag = false;
        flag2 = false;
    }
    
}

        }
            
            
        }
        else
        {
                      System.out.println("Hint : Your path is wrong");
  
        }
}
        }
                 
                 
                 
              }
              else
              {
                  System.out.println("Hint :Your DC's must be bigger than zero");  


              }
            }
            else
            {
                System.out.println("Hint :Your DC's must be Integer Number");  
                        in.next();
                       
            }
            
            
        }
      
      
        
        /*
        Check valdity of antigen path
        */
        flag = true;

        while(flag)
        {
            flag2 = true;
      System.out.println("Step3 : Please Enter path of your Antigen File.txt ");
  
if(in.hasNext())
{
        antigen_path = in.next();
        File path = new File(antigen_path);
        if(path.exists()&&antigen_path.contains(".txt"))
        {
            System.out.println("Your Path Is Valid Ok");
              /*
        Check for Antigen Validation Number From Your File
        */    
        
  System.out.println("Step4 : Please Enter number of your Antigen");

        while (flag2) {

            if(in.hasNextInt())
                    {
            
          num_of_Antigen = in.nextInt();

              if(num_of_Antigen>=1)
              {
                  
                  /*
        Is Your file contains this number of antigen
        
        */ 
        System.out.println("Wait ..... we are sacan your antigen file");
        
      BufferedReader antigen = new BufferedReader(new FileReader(antigen_path));
      String line="";
      String All="";
while((line = antigen.readLine()) != null)
{
    All = All + line;

}
All = All.replaceAll("\\s","");

    antigen_vector = new ArrayList (Arrays.asList(All.split(",")));
    boolean isEMPTY = false;
    if(antigen_vector.size() == num_of_Antigen)
    {
       
     for(int i = 0 ; i< antigen_vector.size();i++)
     {
       if(antigen_vector.get(i).trim().isEmpty())
       {
           System.out.println("Your antigen file  contains invalid data please Enter your file again and also antigen number ");
        flag2= false;
                isEMPTY = true;

        break;
           
       }
       else
       {
         antigen_vector.set(i, antigen_vector.get(i));
       }
     }
        
        if(!isEMPTY)
        {
        flag= false;
        flag2 = false;
        }
    }
    else
    {
        System.out.println("Your antigen file  contains invalid data please Enter your file again and also antigen number ");
        flag2= false;
    }

  
                 
                 
                 
                 
              }
              else
              {
                  System.out.println("Hint :Your Antigen number must be bigger than zero");  
                        System.out.println("Step4 : Please Enter number of your Antigen number");


              }
            }
            else
            {
                System.out.println("Hint :Your Antigen number must be Integer Number");  
                        System.out.println("Step4 : Please Enter number of your Antigen number"); 
                        in.next();
                       
            }
            
            
        }
            
            
            
        }
        else
        {
            System.out.println("Hint : Your path is wrong");

            
        }    
        }
        
        }       
        
        
        
        
        /*
        step5 R value  Max Antigen
        */
        flag = true;
        flag2 = true;
        while(flag)
        {
                    flag2 = true;

           System.out.println("Step5 : Please Enter Max number of antigens per iteration");

            if(in.hasNextInt())
                    {
            
          R = in.nextInt();

              if(R>=1)
              {
               if((num_of_Antigen/num_of_DC)>=R)
               {
                   flag = false;
               }
               else
               {
                   while(flag2)
                   {
                System.out.println("please Enter (Y) if you need to repeat your inputs  or Enter (No) and Enter right value for R");

                   if(in.hasNext())
                   {
                     answer = in.next();
                     if(answer.equals("Y"))
                     {
                         flag2=false;
                         flag = false;
                         
                     }
                     else if(answer.equals("No"))
                     {
                         flag2=false;
                     }
                     else
                     {
                         
                     }
                       
                   }
                   }
               }
                  
                  
              }
              else
              {
                 System.out.println("Hint :Your R number must be Integer >0");  
  
              }
              
                    }
            
            
            else
            {
                 System.out.println("Hint :Your R number must be Integer Number");  
                        in.next(); 
            }
        }
        
        /*
        final step
        
        
        */
            if(!answer.equals("Y"))
        {
          flag = true;
        while(flag)
        {
           System.out.println("Step6 : Please Enter Threshold value");

            if(in.hasNextInt())
                    {
            
          T = in.nextInt();

              if(T>=1)
              {
              
                   flag = false;
               
            
                  
                  
              }
              else
              {
                 System.out.println("Hint :Your Threshold number must be Integer >0");  
  
              }
              
                    }
            
            
            else
            {
                 System.out.println("Hint :Your Threshold number must be Integer Number");  
                        in.next(); 
            }
        }
        
        
        /////////////////
        String excelPath="";
        ArrayList<String> antigen_name;
                ArrayList<Integer> antigen_repeat;
                ArrayList<Integer> antigen_Mature;
                boolean isanomaly = false;

    
           antigen_name = new ArrayList<>();
           antigen_repeat = new ArrayList<>();
           antigen_Mature = new ArrayList<>();

           flag = true;
              while(flag)
        {
            flag2 = true;
      System.out.println("Step6 : Please Enter path of your output file .xls  or  .xlsx ");
  
if(in.hasNext())
{
        excelPath = in.next();
        File path = new File(excelPath);
        if((path.exists())&&(excelPath.contains(".xlsx")||excelPath.contains(".xls")))
        {
            flag = false;
            
            
        }
        else
        {
                       System.out.println("Hint : Your path is wrong");
 
        }
        
}
        }
              
              /*
              Main Algorithm
              */
            System.out.println("**********************************************************");  
              System.out.println("Your inputs is");
              System.out.println("Your Number of DC's is " + num_of_DC);
              
                            System.out.println("Your Number of antigen is " + num_of_Antigen);
              System.out.println("Your Max Number of antigen per DC is " + R);
                            System.out.println("Your Threshold value is " + T);
                         

            System.out.println("**********************************************************");  
              


            for(int i=0 ; i< num_of_DC;i++)
            {
                System.out.println("Dc Number " + i );
            int sample_antigen_number = ThreadLocalRandom.current().nextInt(1, R + 1);    
            ArrayList<String> upatedAntigen = new ArrayList<>();
            for(int j=0;j<sample_antigen_number;j++)
            {
                int rand_index = ThreadLocalRandom.current().nextInt(0, num_of_Antigen-1 + 1);
                upatedAntigen.add(antigen_vector.get(rand_index));
                            num_of_Antigen-=1;
                   antigen_vector.remove(rand_index);

            }
                            System.out.println("-Your sample antigen  is  " + upatedAntigen );

            
               double O0 = ((( (4*(pamp1.get(i)+pamp2.get(i))) + (2*(Danger1.get(i)+Danger2.get(i)))  + (6*(safe1.get(i)+safe2.get(i))))/ 12.0)*(inflam.get(i) + 1));
                
                            double O1 = ((( (0*(pamp1.get(i)+pamp2.get(i))) + (0*(Danger1.get(i)+Danger2.get(i)))  + (1*(safe1.get(i)+safe2.get(i))))/ 1.0)*(inflam.get(i) + 1));
            
                            double O2 =  ((( (8*(pamp1.get(i)+pamp2.get(i))) + (4*(Danger1.get(i)+Danger2.get(i)))  + (12*(safe1.get(i)+safe2.get(i))))/ 24.0)*(inflam.get(i) + 1));

                        System.out.println("O0 result = " + Double.toString(O0));    
                                                System.out.println("O1 result = " + Double.toString(O1));    

                                                                        System.out.println("O2 result = " + Double.toString(O2));    

                            
                            if(O0>T)
{
    if(O2>O1)
    {
        isanomaly = true;
                        System.out.println("Final Conclusion that “DC assigned a cell context value of "+ 1+ " Its collected antigen may be anomalous" );

    }
    else if (O1>O2)
    {
        isanomaly =false;
                        System.out.println("Final Conclusion that “DC assigned a cell context value of "+ 0+ " Its collected antigen may be normal" );

    }
    else
    {
         isanomaly =false;

    System.out.println("This DC doesn't check the condition because  O1 == O2  ");
    }
    
        
}
else
{
            isanomaly =false;

    System.out.println("This DC doesn't check the condition because  Your threshold wasn't smaller than O0 ");
}
                
               for(int s=0;s<upatedAntigen.size();s++)
               {
                   
                   if(antigen_name.contains(upatedAntigen.get(s)))
                   {
                       int index = antigen_name.indexOf(upatedAntigen.get(s));
                       antigen_repeat.set(index,antigen_repeat.get(index)+1);
                       
                         if(isanomaly)
            {
                       antigen_Mature.set(index,antigen_Mature.get(index)+1);
            }
                          
                      
                   }
                   else
                   {
                       antigen_name.add(upatedAntigen.get(s));
                       antigen_repeat.add(1);
                      

                       
                          if(isanomaly)
            {
                          antigen_Mature.add(1);
            }
                          else
                          {
                            antigen_Mature.add(0);
  
                          }

                         
                   }
               }
          
             // csm   o1  o2  o3
            System.out.println("**********************************************************");  

         
                
            }
            
            
            
            System.out.println("Antigen output "+antigen_name);
            
                        System.out.println("Num of presentation "+antigen_repeat);
            System.out.println("MCAV values "+antigen_Mature);
            
            
XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object headers[];
                headers = new Object[]{"Antigen type",  "Num presentation","Num mature presentation","MCAV"};

         Object[][] datatypes = new Object[antigen_name.size()+1][4];
         int myindex=0;
         for(int i=0;i<datatypes.length;i++)
         {
             for(int k = 0 ; k<4;k++)
             {
                 if(i==0)
                 {
                   datatypes[i][k] = headers[k];  
                 }
                 else
                 {
                     double mcav = (double)  antigen_Mature.get(myindex)/antigen_repeat.get(myindex);
                     String result = String.format("%.2f", mcav);
                     if(k==0)
                     datatypes[i][k] = antigen_name.get(myindex);
                     
                      if(k==1)
                     datatypes[i][k] = antigen_repeat.get(myindex);
                      if(k==2)
                     datatypes[i][k] = antigen_Mature.get(myindex);
                       if(k==3)
                       {
                     datatypes[i][k] = result;
                       
                       myindex++;
                       }
                 }
                 
             }
         }
         
      
        int rowNum = 0;
      
            sheet.setColumnWidth(0, 10000);
                        sheet.setColumnWidth(1, 10000);
            sheet.setColumnWidth(2, 10000);
            sheet.setColumnWidth(3, 10000);


        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                

                
                if (field instanceof String) {
                     CellStyle style = workbook.createCellStyle(); //Create new style
                style.setAlignment(HorizontalAlignment.CENTER); //Set wordwrap
                cell.setCellStyle(style); //Apply style to cell
    
                    cell.setCellValue((String) field);
                    
                } else if (field instanceof Integer) {
                       CellStyle style = workbook.createCellStyle(); //Create new style
                style.setAlignment(HorizontalAlignment.CENTER); //Set wordwrap
                cell.setCellStyle(style); //Apply style to cell
                    cell.setCellValue((Integer) field);
                }
                else if (field instanceof Double) {
                       CellStyle style = workbook.createCellStyle(); //Create new style
                style.setAlignment(HorizontalAlignment.CENTER); //Set wordwrap
                cell.setCellStyle(style); //Apply style to cell
                    cell.setCellValue((Double) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(excelPath);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("please close your excel file and trace again");
        } catch (IOException e) {
                        System.out.println("please close your excel file and trace again");

        }

        
        
         try {
            Desktop.getDesktop().open(new File(excelPath));
        } catch (IOException ex) {
            Logger.getLogger(MainAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        }
        
        ////////////////
        flag = true;
        flag2=true;
        



        
        }while(answer.equals("Y"));

     



        
        
        
        
        
        
        
        
        
        
        
        
        
        /*  */


    }
    
}
