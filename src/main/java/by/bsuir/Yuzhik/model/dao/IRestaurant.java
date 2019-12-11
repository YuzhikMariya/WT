package by.bsuir.Yuzhik.model.dao;

import by.bsuir.Yuzhik.model.dao.impl.DAOException;
import by.bsuir.Yuzhik.model.entity.RestaurantWrapper;

import java.util.ArrayList;

public interface IRestaurant {

    /**
     * Add employee to file
     * @param path Path to file
     * @param restaurantWrapper Object that describes restaurant
     * @throws DAOException If file not found
     */
    void writeRestaurant(String path, RestaurantWrapper restaurantWrapper) throws DAOException;

    /**
     * Delete employee from file
     * @param path Path to file
     * @throws DAOException If file not found
     */
    RestaurantWrapper readRestaurant(String path) throws DAOException;

}
