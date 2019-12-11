package by.bsuir.Yuzhik.model.service;

/**
 * Exception on service layer
 */
public class ServiceException extends Exception{

    /**
     * ServiceException handle
     * @param e Information about exception
     */
    public ServiceException(Exception e){
        super(e);
    }
}
