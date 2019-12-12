package app.parsers;

import app.entity.Dish;
import app.entity.Employee;
import app.entity.Order;
import app.entity.RestaurantWrapper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DomHandler {

    private ArrayList<Order> orderList = new ArrayList<Order>();
    private ArrayList<Dish> dishList = new ArrayList<Dish>();
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();

    private RestaurantWrapper restaurantWrapper = new RestaurantWrapper();

    private static String getTextContent(Node parentNode,String childName)
    {
        NodeList nlist = parentNode.getChildNodes();
        for (int i = 0 ; i < nlist.getLength() ; i++) {
            Node n = nlist.item(i);
            String name = n.getNodeName();
            if ( name != null && name.equals(childName) )
                return n.getTextContent();
        }
        return "";
    }

    public RestaurantWrapper parse(String path) throws SAXException, IOException {
        Order order;
        Dish dish;
        Employee employee;

        try
        {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();


            NodeList nDishes = doc.getElementsByTagName("dish");
            for (int i = 0; i < nDishes.getLength(); i++) {
                Node node = nDishes.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    dish = new Dish();
                    dish.setTableNumber(Integer.parseInt(getTextContent(node, "dishTableNumber")));
                    dish.setTitle(getTextContent(node, "dishTitle"));
                    dishList.add(dish);
                    dish = null;
                }
            }

            NodeList nOrders = doc.getElementsByTagName("order");
            for (int i = 0; i < nOrders.getLength(); i++) {
                Node node = nOrders.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    order = new Order();
                    order.setTableNumber(Integer.parseInt(getTextContent(node, "ordTableNumber")));
                    order.setTitle(getTextContent(node, "ordTitle"));
                    order.setTime(Integer.parseInt(getTextContent(node, "time")));
                    order.setPrice(Integer.parseInt(getTextContent(node, "price")));
                    orderList.add(order);
                    order = null;
                }
            }

            NodeList nEmployees = doc.getElementsByTagName("employee");
            for (int i = 0; i < nEmployees.getLength(); i++) {
                Node node = nEmployees.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    employee = new Employee();
                    employee.setName(getTextContent(node, "name"));
                    employee.setSurname(getTextContent(node, "surname"));
                    employee.setAge(Integer.parseInt(getTextContent(node, "age")));
                    employee.setCategory(getTextContent(node, "category"));
                    employee.setDob(getTextContent(node, "dob"));
                    employeeList.add(employee);
                    employee = null;
                }
            }
            restaurantWrapper.setEmployees(employeeList);
            restaurantWrapper.setOrders(orderList);
            restaurantWrapper.setDishes(dishList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantWrapper;
    }
}
