package by.bsuir.Yuzhik.model.bean;

import by.bsuir.Yuzhik.Main;

/**
 * This class describes order
 */
public class Order implements java.io.Serializable {

    /**
     * Table number that made the order
     */
    private int tableNumber;

    /**
     * Time of cooking the order
     */
    private int time;

    /**
     * Name of the dishes
     */
    private String title;

    /**
     * Price of the dishes
     */
    private int price;

    /**
     * Constructor that defines all fields
     * of the class in the default values.
     */
    public Order(){
        tableNumber = 0;
        time = 60;
        title = "Coffee";
        price = 5;
    }

    /**
     * Get time of cooking the order
     * @return Time of cooking the order
     */
    public int getTime(){
        return time;
    }

    /**
     * Set time of cooking the order
     * @param time Time of cooking the order
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Get table number that made the order
     * @return Table number that made the order
     */
    public int getTableNumber(){
        return tableNumber;
    }

    /**
     * Set table number that made the order
     * @param tableNumber Table number that made the order
     */
    public void setTableNumber(int tableNumber) {
        if ((tableNumber >= 0) & (tableNumber < 15))
            this.tableNumber = tableNumber;
    }

    /**
     * Get title of dishes
     * @return Title of dishes
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title of dishes
     * @param title Title of dishes
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get price of dishes
     * @return Price of dishes
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set price of dishes
     * @param price Price of dishes
     */
    public void setPrice(int price) {
        if(price > 0)
            this.price = price;
        else
            this.price = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if ((tableNumber != ((Order)o).tableNumber) || (time != ((Order)o).time) || (price != ((Order)o).price) || (!title.equals(((Order) o).title))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 27*tableNumber + 13*time + 5*price;
    }

    @Override
    public String toString() {
        return "Order{ " + "table number = " + tableNumber + ", time = " + time + ", title = " + title + ", price = " + price + " }";
    }
}
