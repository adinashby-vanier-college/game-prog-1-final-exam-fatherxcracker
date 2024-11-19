// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Ladybug extends Actor
{

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAndTurn();
        collide();
        
        if (isGameWon()) {
            transitionToGameWonWorld();
        }
    }

    /**
     * Demonstrate how the player controls the ladybug with arrow keys.
     */
    public void moveAndTurn()
    {
        if (Greenfoot.isKeyDown("up")) {
            move(4);
        }
        if (Greenfoot.isKeyDown("down")) {
            move(-4);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(3);
        }
        if (Greenfoot.isKeyDown("left")) {
            turn(-3);
        }
    }

    /**
     * When ladybug hits target 
     */
    public void collide()
    {
        Actor finishLocation = getOneIntersectingObject(FinishLocation.class);
        if (finishLocation != null) {
            World world = getWorld();
            world.removeObject(finishLocation);
            Greenfoot.playSound("win.wav");
        }
    }

    /**
     * If game screen changes or not
     */
    public boolean isGameWon()
    {
        World world = getWorld();
        if (world.getObjects(FinishLocation.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This methods transitions to the winning screen
     */
    public void transitionToGameWonWorld()
    {
        World gameWonWorld =  new  WinningScreen();
        Greenfoot.setWorld(gameWonWorld);
    }
}
