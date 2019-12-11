package by.bsuir.Yuzhik.model.service;

import java.util.Random;
import by.bsuir.Yuzhik.model.bean.Order;

/**
 * This class describes order
 */
public class OrderService{

    /**
     * Field order
     */
    private Order order;

    /**
     * Constructor that sets table number and time to cook
     * @param number Table number
     */
    public OrderService(int number, String title){
        this.order = new Order();
        order.setTableNumber(number);
        order.setTitle(title);
        Random r = new Random();
        order.setTime(r.nextInt(100) + 15);
        order.setPrice(r.nextInt(50) + 15);
    }

    /**
     * Get time of cooking the dish
     * @return Time of cooking the dish
     */
    public int getTime(){
        return order.getTime();
    }

    /**
     * Get number of table
     * @return Number of table
     */
    public int getTableNumber(){
        return order.getTableNumber();
    }

    /**
     * Get title of dish
     * @return Title of dish
     */
    public String getTitle(){
        return order.getTitle();
    }

    /**
     * Get price of dish
     * @return Price of dish
     */
    public int getPrice(){
        return order.getPrice();
    }

}
