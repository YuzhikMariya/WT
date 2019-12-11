package by.bsuir.Yuzhik.model.entity;

import java.io.Serializable;

public class Dish implements Serializable {

    private int tableNumber;

    private String title;

    public String getTitle() {
        return title;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "DISH  {table number: " + tableNumber + "  title: " + title +"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        return true;
    }
    /**
     * Do hash code
     * @return hash code of onlineShop
     */
    @Override
    public int hashCode() {
        return 15;
    }
}
