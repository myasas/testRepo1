/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyapp;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JCheckBox;
/**
 *
 * @author Turing
 */
public class FclFileGenerator {
    
  public boolean deleteIfFileExist(){
        boolean isFileExist=false;
        File file = new File("customDiagnoser.fcl");
        if(file.exists() && !file.isDirectory()) {
        /* do something */ 
            isFileExist=true;
            file.delete();
        }
      return isFileExist;
  }    
    void generateFCLFile(
            JCheckBox chkAge,
            JCheckBox chkSex,
            JCheckBox chkCP,
            JCheckBox chkBP,
            JCheckBox chkCL,
            JCheckBox chkFBS,
            JCheckBox chkECG,
            JCheckBox chkExercise,
            JCheckBox chkMHR,
            JCheckBox chkOP,
            JCheckBox chkTS) {
 
  try { 
//      delete the fcl file
      deleteIfFileExist();
//      Write a new file
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("customDiagnoser.fcl", true)));
//    Write Funtion Block
    out.println("FUNCTION_BLOCK customDiagnoser");
//    Write inputs
    out.println("VAR_INPUT");    
    if(chkAge.isSelected()){
    out.println("Age : REAL;");        
    }
    if(chkSex.isSelected()){
    out.println("Sex : REAL;");        
    }
    if(chkCP.isSelected()){
    out.println("ChestPainType : REAL;");        
    }
    if(chkBP.isSelected()){
    out.println("BloodPressure : REAL;");        
    }
    if(chkCL.isSelected()){
    out.println("Cholesterol : REAL;");        
    }
    if(chkFBS.isSelected()){
    out.println("RestingBloodSugar : REAL;");        
    }
    if(chkECG.isSelected()){
    out.println("ECG : REAL;");        
    }
    if(chkExercise.isSelected()){
    out.println("Exercise : REAL;");        
    }
    if(chkMHR.isSelected()){
    out.println("MaximumHeartRate : REAL;");        
    }
    if(chkOP.isSelected()){
    out.println("OldPeak  : REAL;");        
    }    
    if(chkTS.isSelected()){
    out.println("ThalliumScan : REAL;");        
    }
    out.println("END_VAR");
//    Write Output
    out.println("VAR_OUTPUT");
    out.println("Condition : REAL;");
    out.println("END_VAR");
    
//    Write Fuzzy Sets
    if(chkAge.isSelected()){
    out.println("FUZZIFY Age"); 
    out.println("TERM Young := (0, 1) (32, 1)(38, 0) ;");
    out.println("TERM Mild := (33, 0) (38,1) (45,0);");
    out.println("TERM  Old := (40, 0) (50, 1) (58, 0);");
    out.println("TERM  VeryOld := (52, 0) (58, 1) (120,1);");
    out.println("END_FUZZIFY");  
    }
    if(chkSex.isSelected()){
    out.println("FUZZIFY Sex");
    out.println("TERM Zero := (0, 1) (0.09, 1) (0.1,0) ;");
    out.println("TERM One := (0.89,0) (0.9,1) (1,1) (1.09,1) (1.1,0);");
    out.println("END_FUZZIFY");     
    }
    if(chkCP.isSelected()){  
    out.println("FUZZIFY ChestPainType");
    out.println("TERM One := (0, 0)(0.89,0) (0.9,1) (1, 1) (1.09,1) (1.1,0) ;");
    out.println("TERM Two := (1.89,0)(1.9,1) (2,1) (2.09,1) (2.1,0);");
    out.println("TERM Three := (2.89, 0) (2.9,1) (3, 1) (3.09,1) (3.1,0) ;");
    out.println("TERM Four := (3.89,0) (3.9,1) (4,1) (4.09,1) (4.1,0);");
    out.println("END_FUZZIFY");    
    }
    if(chkBP.isSelected()){
    out.println("FUZZIFY BloodPressure");
    out.println("TERM Low := (0, 1) (120, 1) (134,0) ;");
    out.println("TERM Medium := (127,0) (134,1) (153,0);");
    out.println("TERM High := (142,0) (153, 1) (172,0) ;");
    out.println("TERM VeryHigh  := (160,0) (172,1) (300,1);");
    out.println("END_FUZZIFY");     
    }
    if(chkCL.isSelected()){
    out.println("FUZZIFY Cholesterol");
    out.println("TERM Low := (0, 1) (197, 1) (200,0) ;");
    out.println("TERM Medium := (188,0) (217,1) (250,0);");
    out.println("TERM High := (217, 0) (281, 1) (307,0);");
    out.println("TERM VeryHigh  := (281,0) (350,1) (550,1);	");
    out.println("END_FUZZIFY");     
    }
    if(chkFBS.isSelected()){
    out.println("FUZZIFY RestingBloodSugar");
    out.println("TERM Zero := (0, 1) (0.09, 1) (0.1,0) ;");
    out.println("TERM One :=  (0.89,0) (0.9,1)(1,1) (1.09,1)(1.1,0) ;");
    out.println("END_FUZZIFY");    
    }
    if(chkECG.isSelected()){
    out.println("FUZZIFY ECG");
    out.println("TERM Zero := (-0.5, 1) (0, 1) (0.5,0) ;");
    out.println("TERM One := (0.45,0) (1,1) (1.8,0);");
    out.println("TERM Two := (1.4,0) (1.8,1) (2.5, 1);");
    out.println("END_FUZZIFY");       
    }
    if(chkExercise.isSelected()){
    out.println("FUZZIFY Exercise");
    out.println("TERM Zero := (0, 1) (0.09,1) (0.1,0) ;");
    out.println("TERM One := (0.89,0) (0.9,1) (1,1) (1.09, 1)(1.1,0);");
    out.println("END_FUZZIFY");     
    }
    if(chkMHR.isSelected()){
    out.println("FUZZIFY MaximumHeartRate");
    out.println("TERM Low := (0, 1) (100, 1) (141,0) ;");
    out.println("TERM Medium := (111,0) (141,1) (194,0);");
    out.println("TERM High := (152,0) (200,1) (500,1);");
    out.println("END_FUZZIFY");  
    }
    if(chkOP.isSelected()){
    out.println("FUZZIFY OldPeak");
    out.println("TERM Low := (0, 1) (1, 1) (2,0) ;");
    out.println("TERM Risk := (1.5,0) (2.8,1) (4.2,0);");
    out.println("TERM Terrible := (2.55,0) (4,1) (6,1);");
    out.println("END_FUZZIFY");      
    }      
    if(chkTS.isSelected()){
    out.println("FUZZIFY ThalliumScan");
    out.println("TERM Normal := (0, 1) (3, 1) (6,0) ;");
    out.println("TERM FixedDefect := (3,0) (6,1) (7,0);");
    out.println("TERM ReversibleDefect := (6,0) (7,1) (9,0);");
    out.println("END_FUZZIFY");       
    }    
//    Write Defuzzification Conditions
    out.println("DEFUZZIFY Condition");
    out.println("TERM Healthy := (0,1) (0.2, 1) (0.78,0) (4,0);");
    out.println("TERM S1 := (0,0) (1,1) (2,0);");
    out.println("TERM S2 := (1,0) (2,1) (3,0);");
    out.println("TERM S3 := (2,0) (3,1) (4,0);");
    out.println("TERM S4 := (3,0) (3.75,1) (4,1);");

    out.println("METHOD : COG;");
    out.println("DEFAULT := 0;");      
    out.println("END_DEFUZZIFY");
    
//    Write Fuzzy Rules
    out.println("RULEBLOCK No1");
    out.println("AND : MIN;");
    out.println("ACT : MIN;");
    out.println("ACCU : MAX;");
    
    
    if(chkCP.isSelected()){
    out.println("RULE 1  : IF ChestPainType IS One THEN Condition IS Healthy;");
    out.println("RULE 2  : IF ChestPainType IS Two THEN Condition IS S1; ");
    out.println("RULE 3  : IF ChestPainType IS Three THEN Condition IS S2;"); 
    out.println("RULE 4  : IF ChestPainType IS Four THEN Condition IS S3;");
    out.println("RULE 5  : IF ChestPainType IS Four THEN Condition IS S4;");          
    }        
    if(chkSex.isSelected()){
    out.println("RULE 6  : IF Sex IS Zero THEN Condition IS S1;");        
    out.println("RULE 7  : IF Sex IS One THEN Condition IS S2;");        
    }    
    if(chkBP.isSelected()){
    out.println("RULE 8  : IF BloodPressure IS Low THEN Condition IS Healthy; ");
    out.println("RULE 9  : IF BloodPressure IS Medium THEN Condition IS S1;");
    out.println("RULE 10 : IF BloodPressure IS High THEN Condition IS S2;"); 
    out.println("RULE 11 : IF BloodPressure IS High THEN Condition IS S3;");
    out.println("RULE 12 : IF BloodPressure IS VeryHigh THEN Condition IS S4;");   
    }    
    if(chkCL.isSelected()){
    out.println("RULE 13 : IF Cholesterol IS Low THEN Condition IS Healthy;");
    out.println("RULE 14 : IF Cholesterol IS Medium THEN Condition IS S1;");
    out.println("RULE 15 : IF Cholesterol IS High THEN Condition IS S2; "); 
    out.println("RULE 16 : IF Cholesterol IS High THEN Condition IS S3;");
    out.println("RULE 17 : IF Cholesterol IS VeryHigh THEN Condition IS S4;"); 
    }       
    if(chkFBS.isSelected()){
    out.println("RULE 18 : IF RestingBloodSugar IS One THEN Condition IS S2; ");        
    }    
    if(chkECG.isSelected()){
    out.println("RULE 19 : IF ECG IS Zero THEN Condition IS Healthy;");
    out.println("RULE 20 : IF ECG IS Zero THEN Condition IS S1;");
    out.println("RULE 21 : IF ECG IS One THEN Condition IS S2;"); 
    out.println("RULE 22 : IF ECG IS Two THEN Condition IS S3;");
    out.println("RULE 23 : IF ECG IS Two THEN Condition IS S4;");          
    }
    if(chkMHR.isSelected()){
    out.println("RULE 24 : IF MaximumHeartRate IS Low THEN Condition IS Healthy;");
    out.println("RULE 25 : IF MaximumHeartRate IS Medium THEN Condition IS S1;");
    out.println("RULE 26 : IF MaximumHeartRate IS Medium THEN Condition IS S2;"); 
    out.println("RULE 27 : IF MaximumHeartRate IS High THEN Condition IS S3;");
    out.println("RULE 28 : IF MaximumHeartRate IS High THEN Condition IS S4;");       
    }    
    if(chkExercise.isSelected()){
    out.println("RULE 29 : IF Exercise IS One THEN Condition IS S2;");        
    }    
    if(chkOP.isSelected()){
    out.println("RULE 30 : IF OldPeak IS Low THEN Condition IS Healthy;");
    out.println("RULE 31 : IF OldPeak IS Low THEN Condition IS S1;");
    out.println("RULE 32 : IF OldPeak IS Risk THEN Condition IS S2; "); 
    out.println("RULE 33 : IF OldPeak IS Risk THEN Condition IS S3;");
    out.println("RULE 34 : IF OldPeak IS Terrible THEN Condition IS S4;");        
    }         
    if(chkTS.isSelected()){
    out.println("RULE 35 : IF ThalliumScan IS Normal THEN Condition IS Healthy;");
    out.println("RULE 36 : IF ThalliumScan IS Normal THEN Condition IS S1;");
    out.println("RULE 37 : IF ThalliumScan IS FixedDefect THEN Condition IS S2;"); 
    out.println("RULE 38 : IF ThalliumScan IS ReversibleDefect THEN Condition IS S3; ");
    out.println("RULE 39 : IF ThalliumScan IS ReversibleDefect THEN Condition IS S4;");     
    }    
    if(chkAge.isSelected()){
    out.println("RULE 40 : IF Age IS Young THEN Condition IS Healthy;");
    out.println("RULE 41 : IF Age IS Mild THEN Condition IS S1;");
    out.println("RULE 42 : IF Age IS Old THEN Condition IS S2;"); 
    out.println("RULE 43 : IF Age IS Old THEN Condition IS S3;");
    out.println("RULE 44 : IF Age IS VeryOld THEN Condition IS S4;");      
    }
    
    out.println("END_RULEBLOCK");
    out.println("END_FUNCTION_BLOCK"); 
    
    
//    Flush and Close
    out.flush();
    out.close();
  }
  catch (IOException e) {  
//    println(e);
  }
 
}    

    private void println(IOException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
