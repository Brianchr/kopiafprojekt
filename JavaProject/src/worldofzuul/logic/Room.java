package worldofzuul.logic;

import worldofzuul.presentation.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * The type Room.
 */
// Class that hold the information about a room
public class Room 
{
    // Room name.
    private String name;
    // Description of the room.
    private String description;
    // Has room been entered.
    private boolean hasBeenEntered;
    // The location of the room.
    private Point location;
    // How many things are in the room
    private int numberOfContent;
    // List of all the content in the room
    private ArrayList<RoomContent> content = new ArrayList<>();
    // Setter of HasBeenEntered
    public void setHasBeenEntered(boolean hasBeenEntered)
    {
        this.hasBeenEntered = hasBeenEntered;
    }
    // Getter of HasBeenEntered
    public boolean getHasBeenEntered()
    {
        return hasBeenEntered;
    }

    /**
     * Instantiates a new Room.
     */
    //Constructor
    //Parameters: point (coordinate) and numberOfContent.
    //Sets 
    public Room(Point p, int numberOfContent)
    {
        this.location = p;
        this.name = "Dungeon Room";
        this.description = "Just a plain old, boring room ;/";
        this.hasBeenEntered = false;
        this.numberOfContent = numberOfContent;

       // TODO something weird is happening here ... Hmm ... Gets to many similar things
        // Loop that generates a random number (0-100) and adds a (nothing here//monster//chest//helper) according to the number generated.
        // Loop runs as long theres available spaces in the room.
        // Every run of the loop fills a roomslot.
        for (int i = 0; i < this.numberOfContent; i++) //int er counter
        {
            int randomNumber = (int)(Math.random()*100);
            // If the number generated is 0-19 nothing here is added in the roomslot.
            if (randomNumber < 20)
            {
                content.add(new RoomContent());
            }
            // If the number generated is 20-49 a monster is added in the roomslot.
            else if (randomNumber < 50)
            {
                content.add(Monsters.getRandomMonster());
            }
            // If the number generated is 50-84 a chest is added in the roomslot.
            else if (randomNumber < 85)
            {
                content.add(new Chest());
            }
            // If the number generated is 85-100 a helper is added in the roomslot.
            else if (randomNumber <= 100)
            {
                content.add(new Helper());
            }
        }
    }

    public RoomContent getContent(int index)
    {
        if (content.get(index) instanceof Monster)
        {
            Monster monster = (Monster)content.get(index);
            return  monster;
        }
        if (content.get(index) instanceof Helper)
        {
            Helper helper = (Helper)content.get(index);
            return  helper;
        }
        if (content.get(index) instanceof Chest)
        {
            Chest chest = (Chest)content.get(index);
            return  chest;
        }
        else
        {
            RoomContent empty = (RoomContent)content.get(index);
            return  empty;
        }
    }

// TODO fix this method
    public void removeContent(int index)
    {
        content.add(index,new RoomContent());
//        content.remove(index);
    }



    // Getter of location.
    public Point getLocation()
    {
        return location;
    }
}

