// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * These are what can kill the ladybug
 */
public class CannonBall extends Actor
{

    /**
     * Act - do whatever the CannonBall wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        collide();
        
        if (isGameOver()) {
            transitionToGameIsOver();
        }
    }

    /**
     * When cannonball collides with ladybug, ladybug disappears
     */
    public void collide()
    {
        Actor ladybug = getOneIntersectingObject(Ladybug.class);
        if (ladybug != null) {
            World world = getWorld();
            world.removeObject(ladybug);
            Greenfoot.playSound("lose.wav");
        }
    }

    /**
     * If game screen changes or not
     */
    public boolean isGameOver()
    {
        World world = getWorld();
        if (world.getObjects(Ladybug.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This methods transitions to the losing screen
     */
    public void transitionToGameIsOver()
    {
        World gameIsOver =  new  GameOver();
        Greenfoot.setWorld(gameIsOver);
    }
}
