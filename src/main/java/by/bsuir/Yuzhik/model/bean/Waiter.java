package by.bsuir.Yuzhik.model.bean;

/**
 * This class describes waiter
 * and his/her personal data
 */
public class Waiter implements java.io.Serializable {

    /**
     * Constructor that defines
     * waiter's personal data
     */
    public Waiter(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public String toString() {
        return "Waiter";
    }
}
