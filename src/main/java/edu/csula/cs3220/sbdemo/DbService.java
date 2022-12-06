package edu.csula.cs3220.sbdemo;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

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

    @Transactional
    public void addHouse( House house )
    {
        entityManager.persist( house );
    }

    @Transactional
    public void addCharacter( Character character )
    {
        entityManager.persist( character );
    }
}
