package app.parsers;

import app.entity.Dish;
import app.entity.Employee;
import app.entity.Order;
import app.entity.RestaurantWrapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class StaxHandler {

    public RestaurantWrapper parse(String path) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        RestaurantWrapper restaurantWrapper = new RestaurantWrapper();
        try {
            InputStream input = new FileInputStream(path);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            restaurantWrapper = process(reader);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return restaurantWrapper;
    }

    private static RestaurantWrapper process(XMLStreamReader reader) throws XMLStreamException {
        ArrayList<Dish> dishList = new ArrayList<Dish>();
        ArrayList<Order> ordList = new ArrayList<Order>();
        ArrayList<Employee> emplList = new ArrayList<Employee>();
        Employee employee = null;
        Order order = null;
        Dish dish = null;

        RestaurantWrapper restaurantWrapper = new RestaurantWrapper();

        String elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    if ("dish".equals(elementName)) {
                        dish = new Dish();
                    } else if ("order".equals(elementName)) {
                        order = new Order();
                    } else if ("employee".equals(elementName)) {
                        employee = new Employee();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    if ("dishTableNumber".equals(elementName)) {
                        dish.setTableNumber(Integer.parseInt(text));
                    } else if ("dishTitle".equals(elementName)) {
                        dish.setTitle(text);
                    } else if ("ordTableNumber".equals(elementName)) {
                        order.setTableNumber(Integer.parseInt(text));
                    } else if ("ordTitle".equals(elementName)) {
                        order.setTitle(text);
                    } else if ("time".equals(elementName)) {
                        order.setTime(Integer.parseInt(text));
                    } else if ("price".equals(elementName)) {
                        order.setPrice(Integer.parseInt(text));
                    } else if ("age".equals(elementName)) {
                        employee.setAge(Integer.parseInt(text));
                    } else if ("name".equals(elementName)) {
                        employee.setName(text);
                    } else if ("surname".equals(elementName)) {
                        employee.setSurname(text);
                    } else if ("category".equals(elementName)) {
                        employee.setCategory(text);
                    } else if ("dob".equals(elementName)) {
                        employee.setDob(text);
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    if ("dish".equals(elementName)) {
                        dishList.add(dish);
                    } else if ("order".equals(elementName)) {
                        ordList.add(order);
                    } else if ("employee".equals(elementName)) {
                        emplList.add(employee);
                    }
            }
        }
        restaurantWrapper.setDishes(dishList);
        restaurantWrapper.setOrders(ordList);
        restaurantWrapper.setEmployees(emplList);
        return restaurantWrapper;
    }
}


