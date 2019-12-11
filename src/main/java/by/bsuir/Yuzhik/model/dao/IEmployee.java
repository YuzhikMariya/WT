package by.bsuir.Yuzhik.model.dao;

import by.bsuir.Yuzhik.model.dao.impl.DAOException;
import by.bsuir.Yuzhik.model.service.EmployeeService;

import java.util.ArrayList;

/**
 * Interface that defines CRUD functions
 */
public interface IEmployee {

    /**
     * Add employee to file
     * @param path Path to file
     * @param employee Employee personal data
     * @throws DAOException If file not found
     */
    void addEmployee(String path, EmployeeService employee) throws DAOException;

    /**
     * Show information about all employees
     * @param path Path to file
     * @return List of employees personal data
     * @throws DAOException If file not found
     */
    ArrayList<EmployeeService> showEmployees(String path) throws DAOException;

    /**
     * Delete employee from file
     * @param path Path to file
     * @param employee Employee personal data
     * @throws DAOException If file not found
     */
    void deleteEmployee(String path, EmployeeService employee) throws DAOException;

    /**
     * Edit information about employee
     * @param path Path to file
     * @param sourceEmployee Replaceable employee
     * @param destEmployee Replacing employee
     * @throws DAOException If file not found
     */
    void editEmployee(String path, EmployeeService sourceEmployee, EmployeeService destEmployee) throws DAOException;
}
