package by.bsuir.Yuzhik.model.XMLToRestaurant;

import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {
    public RestaurantWrapper saxPars(String path) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        parser.parse(new File(path), handler);
        return handler.getRestaurantWrapper();
    }
}
