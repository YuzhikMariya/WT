package by.bsuir.Yuzhik.model.service;

import by.bsuir.Yuzhik.model.bean.Employee;

/**
 * This class describes employee personal data
 */
public class EmployeeService implements Comparable<EmployeeService> {

    /**
     * Field employee
     */
    private Employee employee;

    /**
     * Constructor that sets employee personal data
     * @param firstName Employee name
     * @param lastName Employee surname
     * @param age Employee age
     */
    public EmployeeService(String firstName, String lastName, int age, String category, String DoB){
        employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setCategory(category);
        employee.setDoB(DoB);
    }

    /**
     * Get employee's name
     * @return Employee's name
     */
    public String getFirstName(){
        return employee.getFirstName();
    }

    /**
     * Get employee's surname
     * @return Employee's surname
     */
    public String getLastName(){
        return employee.getLastName();
    }

    /**
     * Get employee's age
     * @return Employee's age
     */
    public int getAge(){
        return employee.getAge();
    }

    /**
     * Get employee's category
     * @return Employee's category
     */
    public String getCategory(){
        return employee.getCategory();
    }

    /**
     * Get employee's date of birth
     * @return Employee's date of birth
     */
    public String getDoB(){
        return employee.getDoB();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        String objName = ((EmployeeService)o).getFirstName();
        String objSurname = ((EmployeeService)o).getLastName();
        int objAge = ((EmployeeService)o).getAge();
        if (getFirstName().equals(objName) && getLastName().equals(objSurname) && (getAge() == objAge))
            return true;
        return false;
    }

    /**
     * Compare one instance of employee to another
     * @param employee Another employee
     * @return The result is above zero if this instance is bigger.
    */
    public int compareTo(EmployeeService employee) {
        return getLastName().compareTo(employee.getLastName());
    }
}
