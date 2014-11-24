
package iosampleproject;

/**
 *
 * @author emanion
 */
public class InvalidFileFormatException extends IllegalArgumentException {
    
    private static String msg = "Invalid Line Format found";

    public InvalidFileFormatException() {
        super(msg);
    }

    public InvalidFileFormatException(String message) {
        super(message);
    }

    public InvalidFileFormatException(String message, Throwable cause) {
        super(msg, cause);
    }

    public InvalidFileFormatException(Throwable cause) {
        super(cause);
    }
    
    
    
}
