package TextAdventure;


public class Exit
{
  private String name;
  
  private String description;
  private String transition;
  private Room destination;
  private Item requiredItem;
  private boolean creatureBlocks;
  
  public String getName()
  {
    return name;
  }
  
  public String getDescription() { return description; }
  
  public String getTransition() {
    return transition;
  }
  
  public Room getDestination() { return destination; }
  
  public Item getRequiredItem() {
    return requiredItem;
  }
  
  public boolean getCreatureBlocks() { return creatureBlocks; }
  
  public void setDestination(Room destination)
  {
    destination = this.destination;
  }
  
  public void setRequiredItem(Item item) { item = requiredItem; }
  
  public void setCreatureBlocks(boolean value) {
    value = creatureBlocks;
  }
  
  public Exit(String name, String description, String transition, Item requiredItem, Room destination, boolean creatureBlocks) {
    this.name = name;
    this.description = description;
    this.transition = transition;
    this.requiredItem = requiredItem;
    this.destination = destination;
    this.creatureBlocks = creatureBlocks;
  }
  
  public Exit(String name, String description, String transition, Room destination) {
    this.name = name;
    this.description = description;
    this.transition = transition;
    this.destination = destination;
  }
  
  public Exit(String name, String description, String transition, Item requiredItem, Room destination) {
    this.name = name;
    this.description = description;
    this.transition = transition;
    this.requiredItem = requiredItem;
    this.destination = destination;
  }
  
  public Exit(String name, String description, String transition, Room destination, boolean creatureBlocks) { this.name = name;
    this.description = description;
    this.transition = transition;
    this.destination = destination;
    this.creatureBlocks = creatureBlocks;
  }
  
  public Exit(String name, String description, String transition) {
    this.name = name;
    this.description = description;
    this.transition = transition;
  }
}
