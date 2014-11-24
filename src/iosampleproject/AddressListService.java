
package iosampleproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author emanion
 */
public class AddressListService {
    
    private List<String> addressLines;
    
    AddressListService(){
        addressLines = new ArrayList<>();
        
    }
    
    public void produceAddressList(){
        readAddressLines();
        processAddressLines();
        
    }
    
    private void readAddressLines(){
        
  	File data = new File("src" + 
                File.separatorChar + "lab1.txt");
        int lineCount = 0;
        
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
           
	   String line = in.readLine();
	   while(line != null){
		  //System.out.println(line);
                  lineCount +=1;
                  addressLines.add(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Cant read file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
    }
    
    private void processAddressLines(){
        
        FormatOutputLine formatOutputLine = new FormatOutputLine();
        int lineCount = 0;
        
        for (String addressLine:addressLines){
            lineCount +=1;
            
            List<String> addressLines = 
                    formatOutputLine.getFormattedOutputLines
                            (lineCount, addressLine);
            
            for (String addressLineOutput:addressLines){
                System.out.println(addressLineOutput);
            }
            
            
        }
        
        
    }
    
    
}
