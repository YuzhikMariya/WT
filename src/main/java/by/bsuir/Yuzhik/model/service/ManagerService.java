package by.bsuir.Yuzhik.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import by.bsuir.Yuzhik.model.bean.Manager;
import by.bsuir.Yuzhik.model.dao.impl.DAOException;
import by.bsuir.Yuzhik.model.dao.impl.DAOImplementation;

/**
 * This class describes manager behavior
 */
public class ManagerService{

    /**
     * Singleton manager
     */
    private static ManagerService mngr = new ManagerService();

    /**
     * Field manager
     */
    private Manager manager;

    /**
     * Constructor that creates
     * 15 tables in restaurant
     */
    private ManagerService(){
        this.manager = new Manager();
        List<TableService> tbls = manager.getTables();
        for (int i = 0; i < 15; i++)
        {
               tbls.add(new TableService(i));
        }
        manager.setTables(tbls);
    }

    /**
     * Get queue of orders
     * @return Queue of orders
     */
    public Queue<OrderService> getOrders(){
        return manager.getOrders();
    }

    /**
     * Get queue of dishes
     * @return Queue of dishes
     */
    public Queue<DishService> getDishes(){
        return manager.getDishes();
    }

    /**
     * Get next ordered table
     * @return Next ordered table
     */
    public TableService getNextTable(){
        int currTbl = manager.getCurrentTable();
        currTbl = (currTbl + 1)% 15;
        manager.setCurrentTable(currTbl);
        List<TableService> tables = manager.getTables();
        return tables.get(currTbl);
    }

    /**
     * Get instance of manager
     * @return Instance of manager
     */
    public static ManagerService getManager(){
        return mngr;
    }

    /**
     * Add employee to database
     * @param path Path to database
     * @param employee Employee personal data
     * @throws ServiceException if file not found
     */
    public void addEmployee(String path, EmployeeService employee) throws ServiceException{
        DAOImplementation emplDAO = new DAOImplementation();
        try {
            emplDAO.addEmployee(path, employee);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Show employee database
     * @param path Path to database
     * @return List of employees
     * @throws ServiceException if file not found
     */
    public ArrayList<EmployeeService> showEmployees(String path) throws ServiceException{
        DAOImplementation emplDAO = new DAOImplementation();
        ArrayList<EmployeeService> list;
        try {
            list = emplDAO.showEmployees(path);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
        return list;
    }

    /**
     * Delete employee from database
     * @param path Path to database
     * @param employee Employee personal data
     * @throws ServiceException if file not found
     */
    public void deleteEmployee(String path, EmployeeService employee) throws ServiceException{
        DAOImplementation emplDAO = new DAOImplementation();
        try {
            emplDAO.deleteEmployee(path, employee);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Edit information about sourceEmployee
     * @param path Path to database
     * @param sourceEmployee Replaceable employee
     * @param destEmployee Replacing employee
     * @throws ServiceException if file not found
     */
    public void editEmployee(String path, EmployeeService sourceEmployee, EmployeeService destEmployee) throws ServiceException{
        DAOImplementation emplDAO = new DAOImplementation();
        try {
            emplDAO.editEmployee(path, sourceEmployee, destEmployee);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

}
