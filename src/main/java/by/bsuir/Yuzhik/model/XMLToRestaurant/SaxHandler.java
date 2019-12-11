package by.bsuir.Yuzhik.model.XMLToRestaurant;

import by.bsuir.Yuzhik.model.entity.Dish;
import by.bsuir.Yuzhik.model.entity.Employee;
import by.bsuir.Yuzhik.model.entity.Order;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxHandler extends DefaultHandler {
    private ArrayList<Order> orderList = new ArrayList<Order>();
    private ArrayList<Dish> dishList = new ArrayList<Dish>();
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();

    private RestaurantWrapper restaurantWrapper;
    private Order order;
    private Dish dish;
    private Employee employee;
    private StringBuilder text;

    public RestaurantWrapper getRestaurantWrapper() {
        return restaurantWrapper;
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        switch (qName){
            case "rest:restaurant":
                restaurantWrapper = new RestaurantWrapper();
                break;
            case "order":
                order = new Order();
                break;
            case "dish":
                dish = new Dish();
                break;
            case "employee":
                employee = new Employee();
                break;
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "name":
                employee.setName(text.toString());
                break;
            case "surname":
                employee.setSurname(text.toString());
                break;
            case "category":
                employee.setCategory(text.toString());
                break;
            case "dob":
                employee.setDob(text.toString());
                break;
            case "age":
                employee.setAge(Integer.parseInt(text.toString()));
                break;

            case "ordTitle":
                order.setTitle(text.toString());
                break;
            case "dishTitle":
                dish.setTitle(text.toString());
                break;
            case "price":
                order.setPrice(Integer.parseInt(text.toString()));
                break;
            case "ordTableNumber":
                order.setTableNumber(Integer.parseInt(text.toString()));
                break;
            case "dishTableNumber":
                dish.setTableNumber(Integer.parseInt(text.toString()));
                break;
            case "time":
                order.setTime(Integer.parseInt(text.toString()));
                break;
            case "order":
                orderList.add(order);
                order = null;
                break;
            case "dish":
                dishList.add(dish);
                dish = null;
                break;
            case "employee":
                employeeList.add(employee);
                employee = null;
                break;
            case "rest:restaurant":
                restaurantWrapper.setEmployees(employeeList);
                restaurantWrapper.setOrders(orderList);
                restaurantWrapper.setDishes(dishList);
                break;
        }
    }

    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw (exception);
    }
}