
package iosampleproject;

import java.util.*;

/**
 *
 * @author emanion
 */
public class FormatOutputLine {
    
    private List<String> outputLines;
    
    public FormatOutputLine(){
        outputLines = new ArrayList<>();
        
    }

    public List<String> getOutputLines() {
        return outputLines;
    }

    public void setOutputLines(List<String> outputLines)
                throws IllegalArgumentException {
        if (outputLines == null)
            throw new IllegalArgumentException();
        this.outputLines = outputLines;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.outputLines);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormatOutputLine other = (FormatOutputLine) obj;
        if (!Objects.equals(this.outputLines, other.outputLines)) {
            return false;
        }
        return true;
    }
    
    
    
    public List getFormattedOutputLines(int lineCount, String line)
            throws InvalidFileFormatException {
        
        //null out previous line List
        boolean removeOutputLines = outputLines.removeAll(outputLines);
                
        if (lineCount == 1 ||
            lineCount == 4 ||
            lineCount == 7)
        {
            String[] parts = line.split(" ");
            if (parts.length == 2){
                outputLines.add("First Name = " + parts[0].toString());
                outputLines.add("Last Name = " + parts[1]);
            }
            else {
                 throw new InvalidFileFormatException("Bad First Line Format");
            }
        } else { if (lineCount == 2 || lineCount == 5|| lineCount == 8){
            outputLines.add("Street Address = " + line);
            
        } else {
            
            String[] parts = line.split(",");
            
            if (parts.length == 2){
                outputLines.add("City = " + parts[0]);
                String[] partsCityZip = parts[1].split(" ");
                
                if (partsCityZip.length == 3){
                    //first part will be leading space, immediately after comma
                    outputLines.add("State = " + partsCityZip[1]);
                    outputLines.add("Zip = " + partsCityZip[2]);
                }else{
                    throw new InvalidFileFormatException
                            ("More than 2 parts to State Zip");
                }
                
            }
            else {
                 throw new InvalidFileFormatException
                            ("More than 2 parts to City + State/ZIP");
            }    
        }   
                
                
        }
        
        
        return outputLines;
    }

    @Override
    public String toString() {
        
        return "FormatOutputLine{" + "outputLines=" + outputLines + '}';
    }
    
    
    
    
    
}
