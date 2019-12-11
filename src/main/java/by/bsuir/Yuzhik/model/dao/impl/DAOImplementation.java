package by.bsuir.Yuzhik.model.dao.impl;

import by.bsuir.Yuzhik.model.RestaurantToXML.ToXMLWriter;
import by.bsuir.Yuzhik.model.XMLToRestaurant.FromXMLReader;
import by.bsuir.Yuzhik.model.dao.IEmployee;
import by.bsuir.Yuzhik.model.dao.IRestaurant;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;
import by.bsuir.Yuzhik.model.exception.XMLDataException;
import by.bsuir.Yuzhik.model.service.EmployeeService;

import java.io.*;
import java.util.ArrayList;

/**
 * Class that implements CRUD functions of employees
 */
public class DAOImplementation implements IEmployee, IRestaurant {

    @Override
    public void addEmployee(String path, EmployeeService employee) throws DAOException{
        ArrayList<EmployeeService> list = showEmployees(path);
        if (!list.contains(employee))
        {
            try{
                FileWriter writer = new FileWriter(path, true);
                writer.append(employee.getFirstName());
                writer.append("\r\n");
                writer.append(employee.getLastName());
                writer.append("\r\n");
                writer.append(String.valueOf(employee.getAge()));
                writer.append("\r\n");
                writer.append(employee.getCategory());
                writer.append("\r\n");
                writer.append(employee.getDoB());
                writer.append("\r\n");
                writer.flush();
            } catch (IOException ex) {
                throw new DAOException(ex);
            }
        }
    }

    @Override
    public ArrayList<EmployeeService> showEmployees(String path) throws DAOException {
        ArrayList<EmployeeService> list = new ArrayList<EmployeeService>();
        String firstName, lastName, category, DoB;
        int age;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            while ((firstName = reader.readLine()) != null) {
                lastName = reader.readLine();
                age = Integer.parseInt(reader.readLine());
                category = reader.readLine();
                DoB = reader.readLine();
                EmployeeService employee = new EmployeeService(firstName, lastName, age, category, DoB);
                list.add(employee);
            }
            reader.close();
        } catch (IOException ex) {
            throw new  DAOException(ex);
        }
        return list;
    }

    @Override
    public void deleteEmployee(String path, EmployeeService employee) throws DAOException{
        ArrayList<EmployeeService> list = showEmployees(path);
        for (EmployeeService e: list){
            if(e.equals(employee)){
                list.remove(e);
                break;
            }
        }
        UpdateEmployees(path, list);
    }

    @Override
    public void editEmployee(String path, EmployeeService sourceEmployee, EmployeeService destEmployee) throws DAOException{
        ArrayList<EmployeeService> list = showEmployees(path);
        for (EmployeeService e: list){
            if( e.equals(sourceEmployee) ){
                list.set(list.indexOf(e), destEmployee);
            }
        }
        UpdateEmployees(path, list);
    }

    /**
     * Update all list of employees
     * @param path Path to file
     * @param list List of employees
     * @throws DAOException If file not found
     */
    private void UpdateEmployees(String path, ArrayList<EmployeeService> list) throws DAOException{
        try{
            FileWriter writer = new FileWriter(path, false);
            for(EmployeeService e: list){
                writer.append(e.getFirstName());
                writer.append("\r\n");
                writer.append(e.getLastName());
                writer.append("\r\n");
                writer.append(String.valueOf(e.getAge()));
                writer.append("\r\n");
                writer.append(e.getCategory());
                writer.append("\r\n");
                writer.append(e.getDoB());
                writer.append("\r\n");
                writer.flush();

            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }

    @Override
    public void writeRestaurant(String path, RestaurantWrapper restaurantWrapper) throws DAOException{
        ToXMLWriter toXMLWriter = new ToXMLWriter();
        try{
            toXMLWriter.write(restaurantWrapper, path);
        }
        catch (XMLDataException e)
        {
            throw new DAOException(e);
        }
    }

    @Override
    public RestaurantWrapper readRestaurant(String path) throws DAOException{
        FromXMLReader fromXMLReader = new FromXMLReader();
        RestaurantWrapper restaurantWrapper;
        try{
            restaurantWrapper = (RestaurantWrapper)fromXMLReader.parse(path);
        }
        catch (XMLDataException e){
            throw new DAOException(e);
        }
        return restaurantWrapper;
    }
}
