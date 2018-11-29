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
    private Double price;

    private String category;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }


    public Item(int id, String title, Double price,String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category= category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	@Override public
	String toString() {
		final StringBuilder sb = new StringBuilder("Item{");
		sb.append("id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append(", price=").append(price);
		sb.append(", category='").append(category).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
