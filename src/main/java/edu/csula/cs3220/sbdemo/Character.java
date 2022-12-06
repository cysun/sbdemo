package edu.csula.cs3220.sbdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    private String name;

    private String father;

    private String mother;

    @ManyToOne
    private House house;

    public Character()
    {
    }

    public Character( String name, String father, String mother )
    {
        this.name = name;
        this.father = father;
        this.mother = mother;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getFather()
    {
        return father;
    }

    public void setFather( String father )
    {
        this.father = father;
    }

    public String getMother()
    {
        return mother;
    }

    public void setMother( String mother )
    {
        this.mother = mother;
    }

    public House getHouse()
    {
        return house;
    }

    public void setHouse( House house )
    {
        this.house = house;
    }
}
