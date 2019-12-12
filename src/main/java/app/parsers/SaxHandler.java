package app.parsers;

import app.entity.Dish;
import app.entity.Employee;
import app.entity.Order;
import app.entity.RestaurantWrapper;
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
        if ("rest:restaurant".equals(qName)) {
            restaurantWrapper = new RestaurantWrapper();
        } else if ("order".equals(qName)) {
            order = new Order();
        } else if ("dish".equals(qName)) {
            dish = new Dish();
        } else if ("employee".equals(qName)) {
            employee = new Employee();
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(qName)) {
            employee.setName(text.toString());
        } else if ("surname".equals(qName)) {
            employee.setSurname(text.toString());
        } else if ("category".equals(qName)) {
            employee.setCategory(text.toString());
        } else if ("dob".equals(qName)) {
            employee.setDob(text.toString());
        } else if ("age".equals(qName)) {
            employee.setAge(Integer.parseInt(text.toString()));
        } else if ("ordTitle".equals(qName)) {
            order.setTitle(text.toString());
        } else if ("dishTitle".equals(qName)) {
            dish.setTitle(text.toString());
        } else if ("price".equals(qName)) {
            order.setPrice(Integer.parseInt(text.toString()));
        } else if ("ordTableNumber".equals(qName)) {
            order.setTableNumber(Integer.parseInt(text.toString()));
        } else if ("dishTableNumber".equals(qName)) {
            dish.setTableNumber(Integer.parseInt(text.toString()));
        } else if ("time".equals(qName)) {
            order.setTime(Integer.parseInt(text.toString()));
        } else if ("order".equals(qName)) {
            orderList.add(order);
            order = null;
        } else if ("dish".equals(qName)) {
            dishList.add(dish);
            dish = null;
        } else if ("employee".equals(qName)) {
            employeeList.add(employee);
            employee = null;
        } else if ("rest:restaurant".equals(qName)) {
            restaurantWrapper.setEmployees(employeeList);
            restaurantWrapper.setOrders(orderList);
            restaurantWrapper.setDishes(dishList);
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
