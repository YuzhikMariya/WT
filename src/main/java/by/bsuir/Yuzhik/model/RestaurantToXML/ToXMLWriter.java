package by.bsuir.Yuzhik.model.RestaurantToXML;

import by.bsuir.Yuzhik.model.entity.Dish;
import by.bsuir.Yuzhik.model.entity.Employee;
import by.bsuir.Yuzhik.model.entity.Order;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;
import by.bsuir.Yuzhik.model.exception.XMLDataException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ToXMLWriter {

    public void write(RestaurantWrapper restaurantWrapper, String fileName) throws XMLDataException{
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), restaurantWrapper);
        } catch (IOException e) {
            throw new XMLDataException("can't open file Xml name = [" + fileName + "]", e);
        }
    }


    public void writeDish(Dish dish, String fileName) throws XMLDataException {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName));
            xmlEncoder.writeObject(dish);
            xmlEncoder.close();
        } catch (IOException e) {
            throw new XMLDataException("can't write to file = [" + fileName + "]", e);
        }
    }

    public void writeOrder(Order order, String fileName) throws XMLDataException {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName));
            xmlEncoder.writeObject(order);
            xmlEncoder.close();
        } catch (IOException e) {
            throw new XMLDataException("can't write to file = [" + fileName + "]", e);
        }
    }

    public void writeEmployee(Employee employee, String fileName) throws XMLDataException {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName));
            xmlEncoder.writeObject(employee);
            xmlEncoder.close();
        } catch (IOException e) {
            throw new XMLDataException("can't write to file = [" + fileName + "]", e);
        }
    }

    public void writeRestaurant(RestaurantWrapper restaurantWrapper, String fileName) throws XMLDataException {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName));
            xmlEncoder.writeObject(restaurantWrapper);
            xmlEncoder.close();
        } catch (IOException e) {
            throw new XMLDataException("can't write to file = [" + fileName + "]", e);
        }
    }
}
