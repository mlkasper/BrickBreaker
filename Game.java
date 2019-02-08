package TextAdventure;

import java.io.PrintStream;
import java.util.Scanner;





public class Game
{
  private World world;
  private Player player;
  private Room currentRoom;
  private String startText = "Welcome to Text Adventure!";
  private String victoryText = "You won!";
  
  private Scanner scan;
  
  public Game(World world, Player player)
  {
    this.world = world;
    this.player = player;
    
    currentRoom = world.getStartingRoom();
    
    scan = new Scanner(System.in);
  }
  
  public void setStartText(String text)
  {
    startText = text;
  }
  
  public void setVictoryText(String text)
  {
    victoryText = text;
  }
  
  public void start()
  {
    displayStartText();
    
    while (currentRoom != world.getEndingRoom())
    {

      describeRoom();
      

      describeExits();
      

      describeItem();
      

      describeCreatures();
      

      processInputUntilRoomChange();
    }
    
    System.out.println(currentRoom.getDescription());
    
    displayVictoryText();
  }
  
  private void displayStartText()
  {
    System.out.println(startText);
  }
  
  private void displayVictoryText()
  {
    System.out.println(victoryText);
  }
  
  private void describeRoom()
  {
    System.out.println(currentRoom.getDescription());
  }
  
  private void describeExits()
  {
    System.out.println("Visible Exits:");
    

    if (currentRoom.getExit1() != null)
    {
      System.out.println(" " + currentRoom.getExit1().getName());
    }
    
    if (currentRoom.getExit2() != null)
    {
      System.out.println(" " + currentRoom.getExit2().getName());
    }
    
    if (currentRoom.getExit3() != null)
    {
      System.out.println(" " + currentRoom.getExit3().getName());
    }
    
    if (currentRoom.getExit4() != null)
    {
      System.out.println(" " + currentRoom.getExit4().getName());
    }
  }
  
  private void describeItem()
  {
    System.out.println("Visible Items:");
    

    if (currentRoom.getItem() != null)
    {
      System.out.println(" " + currentRoom.getItem().getName());
    }
    else
    {
      System.out.println(" None");
    }
  }
  
  private void describeCreatures()
  {
    System.out.println("Creatures Present:");
    System.out.println(" You");
    

    if (currentRoom.getCreature() != null)
    {
      System.out.println(" " + currentRoom.getCreature().getName());
    }
  }
  
  private void displayCommands()
  {
    System.out.println("Commands:");
    System.out.println("look - examine a Room, Exit, Creature, or Item.");
    System.out.println("get - acquire an Item.");
    System.out.println("use - use an Item.");
    System.out.println("go - move to a different Room through an Exit.");
    System.out.println("inventory - list each Item held by the player.");
  }
  
  private void displayDescription(String thingToDescribe)
  {
    if ((thingToDescribe.equalsIgnoreCase("look")) || (thingToDescribe.equals("")))
    {
      describeRoom();
      describeExits();
      describeItem();
      describeCreatures();



    }
    else if ((currentRoom.getExit1() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getExit1().getName())))
    {
      System.out.println(currentRoom.getExit1().getDescription());
    }
    else if ((currentRoom.getExit2() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getExit2().getName())))
    {
      System.out.println(currentRoom.getExit2().getDescription());
    }
    else if ((currentRoom.getExit3() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getExit3().getName())))
    {
      System.out.println(currentRoom.getExit3().getDescription());
    }
    else if ((currentRoom.getExit4() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getExit4().getName())))
    {
      System.out.println(currentRoom.getExit4().getDescription());
    }
    else if ((currentRoom.getSecretExit() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getSecretExit().getName())))
    {
      System.out.println(currentRoom.getSecretExit().getDescription());



    }
    else if ((currentRoom.getItem() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getItem().getName())))
    {
      System.out.println(currentRoom.getItem().getDescription());



    }
    else if ((currentRoom.getCreature() != null) && (thingToDescribe.equalsIgnoreCase(currentRoom.getCreature().getName())))
    {
      System.out.println(currentRoom.getCreature().getDescription());



    }
    else if ((thingToDescribe.equalsIgnoreCase("me")) || (thingToDescribe.equalsIgnoreCase("you")))
    {
      System.out.println(player.getDescription());
      System.out.println("To see what items are currently in your possession, type \"inventory\"");



    }
    else if (player.getItemFromInventory(thingToDescribe) != null)
    {
      System.out.println(player.getItemFromInventory(thingToDescribe).getDescription());



    }
    else
    {


      System.out.println("You can't seem to find a " + thingToDescribe);
    }
  }
  
  private void acquireItem(String thingToAcquire)
  {
    if ((thingToAcquire.equalsIgnoreCase("get")) || (thingToAcquire.equals("")))
    {
      System.out.println("Get what?");
      return;
    }
    

    if ((currentRoom.getItem() != null) && (thingToAcquire.equalsIgnoreCase(currentRoom.getItem().getName())))
    {

      player.addItemToInventory(currentRoom.getItem());
      currentRoom.setItem(null);
      System.out.println("You pick up the " + thingToAcquire + " and add it to your inventory.");


    }
    else if ((thingToAcquire.equalsIgnoreCase("you")) || (thingToAcquire.equalsIgnoreCase("me")))
    {
      System.out.println("You can't get \"you\". No one could ever get you. Especially your parents, which is probably why you went on this adventure in the first place.");
    }
    else if ((currentRoom.getCreature() != null) && (thingToAcquire.equalsIgnoreCase(currentRoom.getCreature().getName())))
    {
      System.out.println("You can't get the " + thingToAcquire + ". You don't have anywhere to put it and there's no way your parent's would let you keep it.");

    }
    else
    {

      System.out.println("You can't get " + thingToAcquire);
    }
  }
  

  private boolean movePlayer(String placeToMoveTo)
  {
    if ((placeToMoveTo.equalsIgnoreCase("go")) || (placeToMoveTo.equals("")))
    {
      System.out.println("Go where?");
      return false;
    }
    

    if ((currentRoom.getExit1() != null) && (placeToMoveTo.equalsIgnoreCase(currentRoom.getExit1().getName())))
    {
      if (checkExit(currentRoom.getExit1()))
      {

        currentRoom = currentRoom.getExit1().getDestination();
        return true;
      }
    }
    else if ((currentRoom.getExit2() != null) && (placeToMoveTo.equalsIgnoreCase(currentRoom.getExit2().getName())))
    {
      if (checkExit(currentRoom.getExit2()))
      {

        currentRoom = currentRoom.getExit2().getDestination();
        return true;
      }
    }
    else if ((currentRoom.getExit3() != null) && (placeToMoveTo.equalsIgnoreCase(currentRoom.getExit3().getName())))
    {
      if (checkExit(currentRoom.getExit3()))
      {

        currentRoom = currentRoom.getExit3().getDestination();
        return true;
      }
    }
    else if ((currentRoom.getExit4() != null) && (placeToMoveTo.equalsIgnoreCase(currentRoom.getExit4().getName())))
    {
      if (checkExit(currentRoom.getExit4()))
      {

        currentRoom = currentRoom.getExit4().getDestination();
        return true;
      }
    }
    else if ((currentRoom.getSecretExit() != null) && (placeToMoveTo.equalsIgnoreCase(currentRoom.getSecretExit().getName())))
    {
      if (checkExit(currentRoom.getSecretExit()))
      {

        currentRoom = currentRoom.getSecretExit().getDestination();
        return true;
      }
      

    }
    else
    {

      System.out.println("It doesn't appear as though I can go there.");
      return false;
    }
    
    return false;
  }
  

  private boolean checkExit(Exit exit)
  {
    if ((currentRoom.getCreature() != null) && (exit.getCreatureBlocks()))
    {
      System.out.println("You attempt to leave, but the " + currentRoom.getCreature().getName() + " blocks the way.");
      return false;
    }
    

    if ((exit.getRequiredItem() != null) && (!player.isItemInInventory(exit.getRequiredItem())))
    {
      System.out.println("You do not possess the necessary Item to pass through this Exit.");
      return false;
    }
    

    System.out.println(exit.getTransition());
    return true;
  }
  



  private void useItem(String itemToUse)
  {
    if ((itemToUse.equalsIgnoreCase("")) || (itemToUse.equalsIgnoreCase("use")))
    {
      System.out.println("Use what?");
      return;
    }
    


    Item item = player.getItemFromInventory(itemToUse);
    


    if (item != null)
    {

      System.out.println("You use the " + item.getName());
      

      if ((currentRoom.getCreature() != null) && (currentRoom.getCreature().getItemToDestroy() != null) && (currentRoom.getCreature().getItemToDestroy() == item))
      {

        System.out.println(currentRoom.getCreature().getDefeatedText());
        currentRoom.setCreature(null);
        

        player.removeItemFromInventory(item);
      }
      

    }
    else
    {

      System.out.println("There is no " + itemToUse + " in your inventory.");
    }
  }
  


  private void processInputUntilRoomChange()
  {
    for (;;)
    {
      System.out.print("> ");
      String input = scan.nextLine();
      

      if (input.startsWith("help"))
      {
        displayCommands();
      }
      else if (input.startsWith("look"))
      {
        displayDescription(input.substring(input.indexOf(" ") + 1));
      }
      else if (input.startsWith("get"))
      {
        acquireItem(input.substring(input.indexOf(" ") + 1));
      }
      else if (input.startsWith("go"))
      {
        if (movePlayer(input.substring(input.indexOf(" ") + 1))) {
          break;
        }
        
      }
      else if (input.startsWith("use"))
      {
        useItem(input.substring(input.indexOf(" ") + 1));
      }
      else if (input.startsWith("inventory"))
      {
        System.out.print(player.listInventory());


      }
      else
      {

        System.out.println("I don't know how to " + input);
      }
    }
  }
}
