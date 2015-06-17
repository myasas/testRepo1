package fuzzyapp;


import javax.swing.JOptionPane;
import javax.swing.JTextField;


public  class Validator {
    
    public Boolean validateAge(JTextField jTextField){
        Boolean test=Integer.parseInt(jTextField.getText())>120;
        if(test){
            JOptionPane.showMessageDialog(null, "Age can not be over 120 Years","Input Validation", 2);
            jTextField.grabFocus();
        }
    return test;
    }
    
    public Boolean validateBloodPreassure(JTextField jTextField){
        Boolean test=Integer.parseInt(jTextField.getText())>300;       
        if(test){
            JOptionPane.showMessageDialog(null, "Blood preassure can not be over 300 mm Hg","Input Validation", 2);
            jTextField.grabFocus();
        }
        return test;
    }   
    
    public Boolean validateCholesterolLevel(JTextField jTextField){
        Boolean test=Integer.parseInt(jTextField.getText())>550;         
        if(test){
            JOptionPane.showMessageDialog(null, "Cholesterol Level can not be over 550 mm Hg","Input Validation", 2);
            jTextField.grabFocus();
        }
        return test;
    }
        
    public Boolean validateHeartRate(JTextField jTextField){
        Boolean test=Integer.parseInt(jTextField.getText())>210;         
        if(test){
            JOptionPane.showMessageDialog(null, "Maximum Heart Rate can not be over 210 beats/min","Input Validation", 2);
            jTextField.grabFocus();            
        }
        return test;
    }        
    

}

