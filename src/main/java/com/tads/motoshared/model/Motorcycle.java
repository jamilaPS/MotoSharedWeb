package com.tads.motoshared.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by jamila on 13/08/16.
 */

@Entity
public class Motorcycle implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
    @ManyToOne
	private User owner;
    private Double price;
    private String brand;
    private String model;
    private String phone;
    private Integer year;

    public Motorcycle()
    {

    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }
}
