package edu.csula.cs3220.sbdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private DbService dbService;

    @RequestMapping("/")
    public String listCharacters( String houseName, ModelMap models )
    {
        List<House> houses = dbService.getHouses();
        House house = houses.get( 0 );
        if( houseName != null )
        {
            for( House h : houses )
                if( h.getName().equals( houseName ) )
                {
                    house = h;
                    break;
                }
        }

        models.put( "houses", houses );
        models.put( "house", house );

        return "listCharacters";
    }

    @GetMapping("/AddHouse")
    public String addHouse()
    {
        return "addHouse";
    }

    @PostMapping("/AddHouse")
    public String addHouse( String houseName )
    {
        dbService.addHouse( new House( houseName ) );
        return "redirect:/";
    }

    @GetMapping("/AddCharacter")
    public String addCharacter( String houseName, ModelMap models )
    {
        models.put( "houseName", houseName );
        models.put( "characters", dbService.getCharacters() );
        return "addCharacter";
    }

    @PostMapping("/AddCharacter")
    public String addCharacter( String houseName, Character c )
    {
        c.setHouse( new House( houseName ) );
        dbService.addCharacter( c );
        return "redirect:/?houseName=" + houseName;
    }
}
