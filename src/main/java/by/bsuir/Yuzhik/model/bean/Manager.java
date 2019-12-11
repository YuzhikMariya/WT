package by.bsuir.Yuzhik.model.bean;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import by.bsuir.Yuzhik.model.service.TableService;
import by.bsuir.Yuzhik.model.service.OrderService;
import by.bsuir.Yuzhik.model.service.DishService;

/**
 * This class describes manager and
 * his features and personal data
 */
public class Manager implements java.io.Serializable {

    /**
     * List of all tables in
     * the restaurant hall
     */
    private List<TableService> tables = new ArrayList<TableService>(15);

    /**
     * Queue of all orders
     */
    private Queue<OrderService> orders = new ArrayDeque<OrderService>();

    /**
     * Queue of all cooked dishes
     */
    private Queue<DishService> dishes = new ArrayDeque<DishService>();

    /**
     * Number of table that
     * can be ordered
     */
    private int currentTable = -1;

    /**
     * Manager constructor
     */
    public Manager(){
    }

    /**
     * Get queue of orders
     * @return Queue of orders
     */
    public Queue<OrderService> getOrders(){
        return orders;
    }

    /**
     * Set queue of orders
     * @param orders Queue of orders
     */
    public void setOrders(Queue<OrderService> orders) {
        this.orders = orders;
    }

    /**
     * Get queue of dishes
     * @return Queue of dishes
     */
    public Queue<DishService> getDishes(){
        return dishes;
    }

    /**
     * Set queue of dishes
     * @param dishes Queue of dishes
     */
    public void setDishes(Queue<DishService> dishes) {
        this.dishes = dishes;
    }

    /**
     * Get number of current ordered table
     * @return Number of current ordered table
     */
    public int getCurrentTable() {
        return currentTable;
    }

    /**
     * Set number of current ordered table
     * @param currentTable Number of current ordered table
     */
    public void setCurrentTable(int currentTable) {
        this.currentTable = currentTable;
    }

    /**
     * Get list of all tables
     * @return List of all tables
     */
    public List<TableService> getTables() {
        return tables;
    }

    /**
     * Set list of all tables
     * @param tables List of all tables
     */
    public void setTables(List<TableService> tables) {
        this.tables = tables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Manager man = (Manager)o;
        if ((currentTable != man.currentTable) || (tables != man.tables)
                || (dishes != man.dishes) || (orders != man.orders))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int res = (tables != null ? tables.hashCode() : 0) + (orders != null ? orders.hashCode() : 0)
                    + (dishes != null ? dishes.hashCode() : 0);
        return 13*res + 5*currentTable;
    }

    @Override
    public String toString() {
        return "Manager ";
    }
}
