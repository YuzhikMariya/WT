package by.bsuir.Yuzhik.model.bean;

/**
 * This class describes cook and
 * his/her personal data
 */
public class Cook implements java.io.Serializable {

    /**
     * Constructor of cook
     */
    public Cook(){
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
        return "Cook";
    }
}
