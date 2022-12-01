package edu.csula.cs3220.sbdemo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.csula.cs3220.sbdemo.model.House;
import edu.csula.cs3220.sbdemo.model.Character;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DbService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<House> getHouses()
    {
        return entityManager.createQuery( "from House", House.class )
            .getResultList();
    }

    public List<Character> getCharacters()
    {
        return entityManager.createQuery( "from Character", Character.class )
            .getResultList();
    }

    public List<Character> getCharacters( String houseName )
    {
        return entityManager
            .createQuery( "from Character where house.name = :name",
                Character.class )
            .setParameter( "name", houseName )
            .getResultList();
    }

    public House saveHouse( House house )
    {
        return entityManager.merge( house );
    }

    public Character saveCharacter( Character character )
    {
        return entityManager.merge( character );
    }
}
