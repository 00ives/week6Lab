/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ivorl
 */
public class Item {
    
    private String item;
    
    public Item(String item) {
        this.item = item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "ShoppingList{" + "item=" + item + '}';
    }

}
