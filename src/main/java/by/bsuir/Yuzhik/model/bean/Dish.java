package by.bsuir.Yuzhik.model.bean;

/**
 * This class describes dish
 */
public class Dish implements java.io.Serializable {

    /**
     * Table number, that ordered the dish
     */
    private int tableNumber;

    /**
     * Name of the dishes
     */
    private String title;

    /**
     * Constructor that defines dish's table number
     */
    public Dish(){
        tableNumber = 0;
        title = "Coffee";
    }

    /**
     * Get the number of table
     * that ordered the dish
     * @return Number of table that ordered the dish
     */
    public int getTableNumber(){
        return tableNumber;
    }

    /**
     * Set the number of table
     * that ordered the dish
     * @param tableNumber Number of table that ordered the dish
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if ((tableNumber != ((Dish)o).tableNumber) || (!title.equals(((Dish) o).title))) {
            return false;
        }
        else
            return true;
    }

    @Override
    public int hashCode() {
        return 13*tableNumber;
    }

    @Override
    public String toString() {
        return "Dish{ " + "table number = " + tableNumber  + "title = " + title + " }";
    }
}
