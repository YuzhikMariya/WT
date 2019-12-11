package by.bsuir.Yuzhik.model.entity;

public class Order {

    private int tableNumber;

    private String title;

    private int time;

    private int price;

    public String getTitle() {
        return title;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ORDER  {table number: " + tableNumber + "  title: " + title + "  price: " + price + "  time: " + time + "}";
    }
}
