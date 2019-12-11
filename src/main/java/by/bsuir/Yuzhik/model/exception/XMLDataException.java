package by.bsuir.Yuzhik.model.exception;

/**
 * This class describes XmlDataException
 */
public class XMLDataException extends Exception{

    /**
     * XmlDataException handle
     * @param message exception description
     * @param e information about exception
     */
    public XMLDataException(String message, Exception e) {super(message, e);}
}
