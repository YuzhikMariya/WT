package by.bsuir.Yuzhik.model.service;

import by.bsuir.Yuzhik.model.bean.Waiter;

/**
 * This class describes waiter behavior
 */
public class WaiterService{

    /**
     * Field waiter
     */
    private Waiter waiter;

    /**
     * Waiter constructor
     */
    public WaiterService(){
        this.waiter = new Waiter();
    }

    /**
     * If there are cooked dishes, then take the dish.
     * Otherwise take the order at the next table
     */
    public void serveTable(){
        ManagerService manager = ManagerService.getManager();

        if(!manager.getDishes().isEmpty()){
            DishService dish = manager.getDishes().poll();
            System.out.println("Официант отнес заказ для стола №" + dish.getTableNumber());
        }
        else{
            TableService nextTable = manager.getNextTable();
            OrderService order = nextTable.getOrder();
            System.out.println("Получен заказ от стола №" + order.getTableNumber());
            manager.getOrders().add(order);
        }
    }

}
