package by.bsuir.Yuzhik.model.service;

import by.bsuir.Yuzhik.model.bean.Cook;

/**
 * This class describes cook behavior
 */
public class CookService{

    /**
     * Field cook
     */
    private Cook cook;

    /**
     * Constructor that defines cook service
     */
    public CookService(){
        this.cook = new Cook();
    }

    /**
     * Prepare an order if the order list is not empty
     */
    public void cookOrder(){
        ManagerService manager = ManagerService.getManager();
        if(!manager.getOrders().isEmpty()){
            OrderService order = manager.getOrders().poll();
            System.out.println(String.format("Заказ будет готовиться %d минут для стола №%d", order.getTime(), order.getTableNumber()));
            DishService dish = new DishService(order.getTableNumber(), order.getTitle());
            System.out.println(String.format("Заказ для стола №%d готов", dish.getTableNumber()));
            manager.getDishes().add(dish);
        }
    }

}
