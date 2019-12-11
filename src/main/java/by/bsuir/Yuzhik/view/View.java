package by.bsuir.Yuzhik.view;

import by.bsuir.Yuzhik.model.service.EmployeeService;

import java.util.ArrayList;

/**
 * Class that defines view in MVC-architecture
 */
public class View {

    /**
     * Main circle that describes user choices
     */
    public void showChoice(){
        System.out.println("Нажмите 1, чтобы просмотреть список работников");
        System.out.println("Нажмите 2, чтобы отсортировать работников");
        System.out.println("Нажмите 3, чтобы добавить работника");
        System.out.println("Нажмите 4, чтобы удалить работника");
        System.out.println("Нажмите 5, чтобы редактировать работника");
        System.out.println("Нажмите 6, чтобы официант обслужил заказ");
        System.out.println("Нажмите 7, чтобы повар приготовил заказ");
        System.out.println("Нажмите 8, чтобы выйти");
    }

    /**
     * Show information about file path
     */
    public void showPathInfo(){
        System.out.println("Введите путь к файлу с информацией о работниках");
    }

    /**
     * Show warning
     */
    public void showExceptionInfo(){
        System.out.println("Введите корректные данные");
    }

    /**
     * Show information about each employee
     * @param list List of all employees
     */
    public void showEmployeesList(ArrayList<EmployeeService> list){
        for (EmployeeService e: list){
            System.out.println("Surname: " + e.getLastName() + "  Name: " + e.getFirstName() + "  Age: " + e.getAge() + "  Category: " + e.getCategory() + "  Date of birth: " + e.getDoB());
        }
    }

    /**
     * Show name entry information
     */
    public void showName(){
        System.out.println("Введите имя");
    }

    /**
     * Show surname entry information
     */
    public void showSurname(){
        System.out.println("Введите фамилию");
    }

    /**
     * Show age entry information
     */
    public void showAge(){
        System.out.println("Введите возраст");
    }

    /**
     * Show category entry information
     */
    public void showCategory(){
        System.out.println("Введите категорию (Waiter or Cook)");
    }

    /**
     * Show date of birth entry information
     */
    public void showDoB(){
        System.out.println("Введите дату рождения в формате дд/мм/гггг");
    }

    /**
     * Show replaceable employee entry information
     */
    public void showSourceInfo(){
        System.out.println("Введите информацию о заменяемом работнике");
    }

    /**
     * Show replacing employee entry information
     */
    public void showDestInfo(){
        System.out.println("Введите информацию о заменяющем работнике");
    }

    /**
     * Show information of empty list
     */
    public void showNullList(){
        System.out.println("Список пуст");
    }
}
