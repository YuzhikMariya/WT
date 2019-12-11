package by.bsuir.Yuzhik.model.service;

import by.bsuir.Yuzhik.model.bean.Table;

import java.util.Random;

/**
 * This class describes table
 */
public class TableService{

    /**
     * Field table
     */
    private Table table;

    /**
     * Constructor that sets table number
     * @param tblNumber Table number
     */
    public TableService(int tblNumber){
        this.table = new Table();
        table.setNumber(tblNumber);
    }

    /**
     * Get order from the table
     * @return New order
     */
    public OrderService getOrder(){
        Random r = new Random();
        int tempChoice = r.nextInt(4);
        String tempTitle = "Coffee";
        switch (tempChoice){
            case 0:
                tempTitle = "Spaghetti";
                break;
            case 1:
                tempTitle = "Soup";
                break;
            case 2:
                tempTitle = "Cake";
                break;
        }
        return new OrderService(table.getNumber(), tempTitle);
    }

}
