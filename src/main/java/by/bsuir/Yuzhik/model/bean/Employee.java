package by.bsuir.Yuzhik.model.bean;

import java.util.regex.Pattern;

/**
 * This class describes waiter
 * and his/her personal data
 */
public class Employee implements java.io.Serializable {
    /**
     * Employee's name
     */
    private String firstName;

    /**
     * Employee's surname
     */
    private String lastName;

    /**
     * Employee's age
     */
    private int age;

    /**
     * Employee's category
     */
    private String category;

    /**
     * Employee's date of birth
     */
    private String DoB;

    /**
     * Constructor that defines
     * employee's personal data
     */
    public Employee(){
        firstName = "Name";
        lastName = "Surname";
        age = 19;
        category = "Waiter";
        DoB = "01/01/2000";
    }

    /**
     * Get employee's name
     * @return Employee's name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set employee's name
     * @param firstName Employee's name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get employee's surname
     * @return Employee's surname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set employee's surname
     * @param lastName Employee's surname
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get employee's age
     * @return Employee's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set employee's age
     * @param age Employee's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get employee's category
     * @return Employee's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set employee's category
     * @param category Employee's category
     */
    public void setCategory(String category) {
        String tempCategory = category.toLowerCase();
        if((tempCategory.equals("waiter")) || (tempCategory.equals("cook")) )
            this.category = category;
    }

    /**
     * Get employee's date of birth
     * @return Employee's date of birth
     */
    public String getDoB() {
        return DoB;
    }

    /**
     * Set employee's date of birth
     * @param doB Employee's date of birth
     */
    public void setDoB(String doB) {
        if(Pattern.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d", doB))
            DoB = doB;
        else
            DoB = "01/01/2000";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if ((!firstName.equals(((Employee)o).firstName)) || (!lastName.equals(((Employee)o).lastName))
                || (age != ((Employee)o).age) || (!category.equals(((Employee)o).category))
                || (!DoB.equals(((Employee)o).DoB)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int res1 = firstName != null ? firstName.hashCode() : 0;
        int res2 = lastName != null ? lastName.hashCode() : 0;
        int res3 = category != null ? category.hashCode() : 0;
        int res4 = DoB != null ? DoB.hashCode() : 0;
        return 3 * res1 + 13*res2 + 7*age + res3 + 2*res4;
    }

    @Override
    public String toString() {
        return "Employee{ " + "first name = " + firstName + ", last name = " + lastName + ", age = " + age + ", category = " + category + ", date of birth = " + DoB + " }";
    }
}
