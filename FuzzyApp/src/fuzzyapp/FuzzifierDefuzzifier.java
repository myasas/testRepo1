//package net.sourceforge.jFuzzyLogic.demo.diagnoser;
//      Debugging (if required)
    //	Gpr.debug("Young[Age]: " + functionBlock.getVariable("Age").getMembership("Young"));  // This line was taken from FuzzifierDefuzzifier General class
package fuzzyapp;

import java.io.IOException;
import javax.swing.JOptionPane;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * This class the handling of Fuzzification and Defuzzification with the aid of the 
 * Java Library "jFuzzyLojic.jar"
 */
public class FuzzifierDefuzzifier {

    /**
     *This method loads the FCL instruction file into the system and returns a Function block
     * @param functionBlockName
     * @return 
     */
    public FunctionBlock getFunctionBlock(String functionBlockName){  
       String fileName= loadFilePath();
        FIS fis = FIS.load(fileName, true);
        
        if(fis == null){ // Error while loading?
            System.err.println("Can't load file: '" + fileName + "'");
        //return;
        } 
        
        // Get ruleset from 'FCL' file
	FunctionBlock functionBlock = fis.getFunctionBlock(functionBlockName);        
      
        return functionBlock;
    }
    
    public String loadFilePath(){
        PathFinder pathFinderObj = new PathFinder();
        String filePath = "C:\\diagnoser.fcl";
        try {        
        if(pathFinderObj.isFileExist()){
             filePath = pathFinderObj.getFilePath();
        }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null, "Please copy the diagnoser.fcl file to C: Drive");                       
        }
        return filePath;
    }
    
    public void drawInputGraphs(FunctionBlock functionBlock){
    // Show input variable's chart
	JFuzzyChart.get().chart(functionBlock);             
    }
    
    public void drawOutputGraphs(FunctionBlock functionBlock){
    // Show output variable's chart
	Variable Condition = functionBlock.getVariable("Condition");
	JFuzzyChart.get().chart(Condition, Condition.getDefuzzifier(), true);        
    }        
    
//    Delete
//    public FunctionBlock runAlgorithmForAll(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
//    // Set inputs
//        functionBlock.setVariable("Age", parientDetails.getAge());
//        functionBlock.setVariable("Sex", parientDetails.getSex());
//        functionBlock.setVariable("ChestPainType", parientDetails.getChestPainType());
//        functionBlock.setVariable("BloodPressure", parientDetails.getBloodPressure());		
//        functionBlock.setVariable("Cholesterol", parientDetails.getCholesterol());
//        functionBlock.setVariable("RestingBloodSugar", parientDetails.getRestingBloodSugar());
//        functionBlock.setVariable("ECG", parientDetails.getECG());
//        functionBlock.setVariable("Exercise", parientDetails.getExercise());
//        functionBlock.setVariable("MaximumHeartRate", parientDetails.getMaximumHeartRate());
//        functionBlock.setVariable("OldPeak", parientDetails.getOldPeak());
//        functionBlock.setVariable("ThalliumScan", parientDetails.getThalliumScan());
//    // Evaluate / Inference
//        functionBlock.evaluate();
//        return functionBlock;  
//    }

    public FunctionBlock runAlgorithmForAge(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("Age", parientDetails.getAge());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    

    public FunctionBlock runAlgorithmForSex(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("Sex", parientDetails.getSex());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }
    
    public FunctionBlock runAlgorithmForCPType(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("ChestPainType", parientDetails.getChestPainType());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForBP(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("BloodPressure", parientDetails.getBloodPressure());		
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForCL(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs	
        functionBlock.setVariable("Cholesterol", parientDetails.getCholesterol());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForRBS(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs

        functionBlock.setVariable("RestingBloodSugar", parientDetails.getRestingBloodSugar());

    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForECG(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("ECG", parientDetails.getECG());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForExercise(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("Exercise", parientDetails.getExercise());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForMHR(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("MaximumHeartRate", parientDetails.getMaximumHeartRate());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForOP(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("OldPeak", parientDetails.getOldPeak());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
    
    public FunctionBlock runAlgorithmForTS(FunctionBlock functionBlock, PatientDetails parientDetails) throws Exception{
    // Set inputs
        functionBlock.setVariable("ThalliumScan", parientDetails.getThalliumScan());
    // Evaluate / Inference
        functionBlock.evaluate();
        return functionBlock;  
    }    
}

