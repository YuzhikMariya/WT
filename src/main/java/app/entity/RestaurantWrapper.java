package app.entity;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;


//@JacksonXmlRootElement(localName = "restaurant")
public class RestaurantWrapper {

    /**
     * List of orders
     */
   // @JacksonXmlElementWrapper(localName = "orders")
    private List<Order> orders;

    /**
     * List of dishes
     */
    //@JacksonXmlElementWrapper(localName = "dishes")
    private List<Dish> dishes;

    /**
     * List of employees
     */
    //@JacksonXmlElementWrapper(localName = "employees")
    private List<Employee> employees;

    /**
     * Constructor that initialize list of orders, dishes and employees
     */
    public RestaurantWrapper() {
        orders = new ArrayList<Order>();
        dishes = new ArrayList<Dish>();
        employees = new ArrayList<Employee>();
    }

    /**
     * Getter fot orders
     * @return List of orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Setter for orders
     * @param orders List of orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Getter fot dishes
     * @return List of dishes
     */
    public List<Dish> getDishes() {
        return dishes;
    }

    /**
     * Setter for dishes
     * @param dishes List of dishes
     */
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    /**
     * Getter for employees
     * @return list or employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Setter for employees
     * @param employees List of employees
     */
     public void setEmployees(List<Employee> employees) {
         this.employees = employees;
     }

    @Override
    public String toString() {
         String temp = "RESTAURANT  {" + "\n";
        for (Order order: orders ) {
            temp += "     " + order.toString() +"\n";
        }
        for (Dish dish: dishes ) {
            temp += "     " + dish.toString() + "\n";
        }
        for (Employee employee: employees ) {
            temp += "     " + employee.toString() + "\n";
        }
        return temp + "}";
    }
}