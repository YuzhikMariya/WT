package by.bsuir.Yuzhik;

import by.bsuir.Yuzhik.model.XMLToRestaurant.StaxHandler;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
//        Controller controller = new Controller();
//        controller.choiceController();

        StaxHandler staxHandler = new StaxHandler();
        try{
            RestaurantWrapper restaurantWrapper = staxHandler.parse("D:\\Doc\\ВТ\\Epam_servlets\\src\\main\\resources\\restaurant.xml");
            System.out.println(restaurantWrapper.toString());
        }
        catch (FileNotFoundException e){

        }


    }
}
