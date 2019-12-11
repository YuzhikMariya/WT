package by.bsuir.Yuzhik.model.XMLToRestaurant;

import by.bsuir.Yuzhik.model.exception.XMLDataException;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FromXMLReader {

     /**
     * Parse data from xml file
     * @param fileName Xml file name
     * @return Restaurant where all orders, dishes and employees are saved
     * @throws XMLDataException exception during parsing
     */
    public Object parse(String fileName) throws XMLDataException {
        try {
            XMLDecoder d = new XMLDecoder( new BufferedInputStream(new FileInputStream(fileName)));
            Object obj = d.readObject();
            d.close();
            return obj;
        } catch (IOException e) {
            throw new XMLDataException("can't write to file = [" + fileName + "]", e);
        }
    }
}
