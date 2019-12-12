package by.bsuir.Yuzhik.model.XMLToRestaurant;

import by.bsuir.Yuzhik.model.entity.Dish;
import by.bsuir.Yuzhik.model.entity.Employee;
import by.bsuir.Yuzhik.model.entity.Order;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;

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
                    switch (elementName) {
                        case "dish":
                            dish = new Dish();
                            break;
                        case "order":
                            order = new Order();
                            break;
                        case "employee":
                            employee = new Employee();
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case "dishTableNumber":
                            dish.setTableNumber(Integer.parseInt(text));
                            break;
                        case "dishTitle":
                            dish.setTitle(text);
                            break;
                        case "ordTableNumber":
                            order.setTableNumber(Integer.parseInt(text));
                            break;
                        case "ordTitle":
                            order.setTitle(text);
                            break;
                        case "time":
                            order.setTime(Integer.parseInt(text));
                            break;
                        case "price":
                            order.setPrice(Integer.parseInt(text));
                            break;
                        case "age":
                            employee.setAge(Integer.parseInt(text));
                            break;
                        case "name":
                            employee.setName(text);
                            break;
                        case "surname":
                            employee.setSurname(text);
                            break;
                        case "category":
                            employee.setCategory(text);
                            break;
                        case "dob":
                            employee.setDob(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    switch (elementName) {
                        case "dish":
                            dishList.add(dish);
                            break;
                        case "order":
                            ordList.add(order);
                            break;
                        case "employee":
                            emplList.add(employee);
                            break;
                    }
            }
        }
        restaurantWrapper.setDishes(dishList);
        restaurantWrapper.setOrders(ordList);
        restaurantWrapper.setEmployees(emplList);
        return restaurantWrapper;
    }
}


