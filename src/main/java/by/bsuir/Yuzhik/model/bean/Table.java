package by.bsuir.Yuzhik.model.bean;

/**
 * This class describes table
 */
public class Table implements java.io.Serializable {

    /**
     * Table number
     */
    private int number;

    /**
     * Constructor that defines
     * table number as 0
     */
    public Table(){
        number = 0;
    }

    /**
     * Get table number
     * @return Table nmber
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set table number
     * @param number Table number
     */
    public void setNumber(int number) {
        if ((number >= 0) & (number < 15))
            this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (number != ((Table)o).number) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return  13*number;
    }

    @Override
    public String toString() {
        return "Table{ " + "number = " + number  + " }";
    }
}
