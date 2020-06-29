/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author vuhoa
 */
public class Product implements Comparable<Product>{
    private int ID;
    private String name;
    private Float Price;

    public Product(int ID){
        super();
        this.ID = ID;
    }
    public Product(int ID, String name, Float Price) {
        this.ID = ID;
        this.name = name;
        this.Price = Price;
    }

    public Product() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float Price) {
        this.Price = Price;
    }

    @Override
    public int compareTo(Product that) {
        return (this.getID() - that.getID());
    }

   

}
