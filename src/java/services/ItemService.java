/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Item;

/**
 *
 * @author ivorl
 */
public class ItemService {
    
    ArrayList<Item> shoppingList;

    public ItemService() {
        shoppingList = new ArrayList<>();
    }

    public void addToShoppingList(Item item) {
        shoppingList.add(item);
    }
    
    public void deleteFromShoppingList(Item item) {
        shoppingList.remove(item);
    }
}
