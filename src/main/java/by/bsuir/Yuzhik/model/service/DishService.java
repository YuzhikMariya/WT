package by.bsuir.Yuzhik.model.service;

import by.bsuir.Yuzhik.model.bean.Dish;

/**
 * This class describes dish
 */
public class DishService{

    /**
     * Field dish
     */
    private Dish dish;

    /**
     * Constructor which sets number of table
     * that ordered the dish
     * @param number Number of table that ordered the dish
     */
    public DishService(int number, String title){
        this.dish = new Dish();
        dish.setTableNumber(number);
        dish.setTitle(title);
    }

    /**
     * Get number of table that ordered the dish
     * @return number of table that ordered the dish
     */
    public int getTableNumber(){
       return dish.getTableNumber();
    }

    /**
     * Get title of dishes
     * @return Title of dishes
     */
    public String getTitle(){
        return dish.getTitle();
    }

}
