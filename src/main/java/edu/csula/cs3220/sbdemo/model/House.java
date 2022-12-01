package edu.csula.cs3220.sbdemo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "houses")
public class House {

    @Id
    private String name;

    @OneToMany(mappedBy = "house")
    private List<Character> characters;

    public House()
    {
    }

    public House( String name )
    {
        this.name = name;
        this.characters = new ArrayList<Character>();
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Character> getCharacters()
    {
        return characters;
    }

    public void setCharacters( List<Character> characters )
    {
        this.characters = characters;
    }
}
