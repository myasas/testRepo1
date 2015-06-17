
package fuzzyapp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Yasas
 */
public class PathFinder {

    private  String fCLFilePath;
    
   
    
    
  public boolean isFileExist(){
        boolean isFileExist=false;
        File emindTXT = new File(".\\path.txt");
        if(emindTXT.exists() && !emindTXT.isDirectory()) {
        /* do something */ 
            isFileExist=true;
        }
      return isFileExist;
  }
  
  public String getFilePath() throws IOException{
    String filePath;
    BufferedReader br = new BufferedReader(new FileReader(".\\path.txt"));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();            //Read the txt file

        while (line != null) {          //Read all line until it finds empty filds
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();            
        }
        String sbResult[] = sb.toString().split("\\r?\\n"); // Add results in to cookie result array
        filePath=sbResult[0];
    } finally {
        br.close();
    }
    return filePath;
}          

    /**
     * @return the fCLFilePath
     */
    public String getfCLFilePath() {
        return fCLFilePath;
    }

    /**
     * @param fCLFilePath the CookieLoginName to set
     */
    public void setfCLFilePath(String fCLFilePath) {
        this.fCLFilePath = fCLFilePath;
    }


}	
 

