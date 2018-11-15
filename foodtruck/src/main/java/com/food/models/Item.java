package com.food.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "menu")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int qty;
    
    @NotNull
    private String title;

    @NotNull
    private String link;

    @NotNull
    private Double price;

    private String category;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }
    

    public Item(int id, String title, String link, Double price,String category,int qty) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.price = price;
        this.category= category;
        this.qty= qty;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", price=").append(price);
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
