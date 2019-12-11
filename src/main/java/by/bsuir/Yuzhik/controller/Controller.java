package by.bsuir.Yuzhik.controller;

import by.bsuir.Yuzhik.model.service.*;
import by.bsuir.Yuzhik.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class that defines controller in MVC-architecture
 */
public class Controller {

    /**
     * View field
     */
    private View view = new View();

    /**
     * Manager field
     */
    private ManagerService manager = ManagerService.getManager();

    /**
     * Reaction to user actions
     */
    public void choiceController(){
        view.showChoice();
        Scanner userKey = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(userKey.next()) ;
        }catch (NumberFormatException e) {
            choice = 0;
        }
        String path, name, surname, category, DoB;
        int age;
        EmployeeService employee;
        while (choice != 8){
            switch (choice){
            case 1:
                view.showPathInfo();
                userKey.nextLine();
                path = userKey.nextLine();
                try {
                    ArrayList<EmployeeService> list = manager.showEmployees(path);
                    if (list.size() > 0)
                        view.showEmployeesList(list);
                    else
                        view.showNullList();
                }
                catch (ServiceException e)
                {
                    view.showExceptionInfo();
                }
                break;
            case 2:
                view.showPathInfo();
                userKey.nextLine();
                    path = userKey.nextLine();
                    try {
                        ArrayList<EmployeeService> list = manager.showEmployees(path);
                        Collections.sort(list);
//                        list.sort(EmployeeService::compareTo);
                        view.showEmployeesList(list);
                    }
                    catch (ServiceException e)
                    {
                        view.showExceptionInfo();
                    }
                break;
            case 3:
                view.showPathInfo();
                    userKey.nextLine();
                    path = userKey.nextLine();
                    view.showName();
                    name = userKey.nextLine();
                    view.showSurname();
                    surname = userKey.nextLine();
                    view.showCategory();
                    category = userKey.nextLine();
                    view.showDoB();
                    DoB = userKey.nextLine();
                    view.showAge();
                    try {
                        age = userKey.nextInt();
                    }
                    catch (Exception e)
                    {
                        age = 18;
                    }
                    employee = new EmployeeService(name, surname, age, category, DoB);
                    try {
                        manager.addEmployee(path, employee);
                    }
                    catch (ServiceException e)
                    {
                        view.showExceptionInfo();
                    }
                break;
            case 4:
                view.showPathInfo();
                userKey.nextLine();
                    path = userKey.nextLine();
                    view.showName();
                    name = userKey.nextLine();
                    view.showSurname();
                    surname = userKey.nextLine();
                    view.showCategory();
                    category = userKey.nextLine();
                    view.showDoB();
                    DoB = userKey.nextLine();
                    view.showAge();
                    try{
                        age = userKey.nextInt();
                    }
                    catch (Exception e){
                        age = 18;
                    }
                    employee = new EmployeeService(name, surname, age, category, DoB);
                    try {
                        manager.deleteEmployee(path, employee);
                    }
                    catch (ServiceException e)
                    {
                        view.showExceptionInfo();
                    }
                break;
            case 5:
                view.showPathInfo();
                userKey.nextLine();
                    path = userKey.nextLine();
                    view.showSourceInfo();
                    view.showName();
                    String sourceName = userKey.nextLine();
                    view.showSurname();
                    String sourceSurname = userKey.nextLine();
                    view.showCategory();
                    String sourceCategory = userKey.nextLine();
                    view.showDoB();
                    String sourceDoB = userKey.nextLine();
                    view.showAge();
                    int sourceAge;
                    try {
                        sourceAge = userKey.nextInt();
                    }
                    catch (Exception e){
                        sourceAge = 18;
                    }
                    view.showDestInfo();
                    view.showName();
                    userKey.nextLine();
                    String destName = userKey.nextLine();
                    view.showSurname();
                    String destSurname = userKey.nextLine();
                    view.showCategory();
                    String destCategory = userKey.nextLine();
                    view.showDoB();
                    String destDoB = userKey.nextLine();
                    view.showAge();
                    int destAge;
                    try {
                        destAge = userKey.nextInt();
                    }
                    catch (Exception e){
                        destAge = 18;
                    }
                    EmployeeService sourceEmployee = new EmployeeService(sourceName, sourceSurname, sourceAge, sourceCategory, sourceDoB);
                    EmployeeService destEmployee = new EmployeeService(destName, destSurname, destAge, destCategory, destDoB);
                    try {
                        manager.editEmployee(path, sourceEmployee, destEmployee);
                    }
                    catch (ServiceException e)
                    {
                        view.showExceptionInfo();
                    }
                break;
            case 6:
                WaiterService waiter = new WaiterService();
                waiter.serveTable();
                break;
            case 7:
                CookService cook = new CookService();
                cook.cookOrder();
                break;
        }
            view.showChoice();
            try {
                choice = Integer.parseInt(userKey.next()) ;
            }catch (NumberFormatException e) {
                choice = 0;
            }
        }
    }
}

