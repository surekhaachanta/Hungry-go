package com.food.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "menu")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String link;
    @NotNull
    private int price;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id,String title,String link,int price) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }
    
    
    public String getLink() {
        return link;
    }
    public void setLink(String value) {
        this.link = value;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int value) {
        this.price = value;
    }
    
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
