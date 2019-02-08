package TextAdventure;

import java.util.ArrayList;







public class Player
{
  private String name;
  private String description;
  private ArrayList<Item> inventory;
  
  public Player(String name, String description)
  {
    this.name = name;
    this.description = description;
    
    inventory = new ArrayList();
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public void addItemToInventory(Item item)
  {
    inventory.add(item);
  }
  
  public void removeItemFromInventory(Item item)
  {
    inventory.remove(item);
  }
  
  public boolean isItemInInventory(Item item)
  {
    return inventory.contains(item);
  }
  
  public Item getItemFromInventory(String item)
  {
    for (Item currentItem : inventory)
    {
      if (item.equalsIgnoreCase(currentItem.getName()))
      {
        return currentItem;
      }
    }
    
    return null;
  }
  
  public String listInventory()
  {
    if (inventory.size() == 0)
    {
      return "You're not currently carrying anything.\n";
    }
    
    String inventoryDescription = "";
    
    for (Item item : inventory)
    {
      inventoryDescription = inventoryDescription + item.getName() + " - " + item.getDescription() + "\n";
    }
    
    return inventoryDescription;
  }
}
