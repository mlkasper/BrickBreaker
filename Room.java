package TextAdventure;

public class Room
{
  private String name;
  private String description;
  private Exit exit1;
  private Exit exit2;
  private Exit exit3;
  private Exit exit4;
  private Exit secretExit;
  private Item item;
  private Creature creature;
  
  public Room(String name, String description) {
    this.name = name;
    this.description = description;
  }
  
  public Room(String name, String description, Exit exit1, Exit exit2, Exit exit3, Exit exit4, Exit secretExit, Item item, Creature creature) { this.name = name;
    this.description = description;
    this.exit1 = exit1;
    this.exit2 = exit2;
    this.exit3 = exit3;
    this.exit4 = exit4;
    this.secretExit = secretExit;
    this.item = item;
    this.creature = creature;
  }
  
  public String getName() { return name; }
  
  public String getDescription() {
    return description;
  }
  
  public Exit getExit1() { return exit1; }
  
  public Exit getExit2() {
    return exit2;
  }
  
  public Exit getExit3() {
    return exit3;
  }
  
  public Exit getExit4() { return exit4; }
  
  public void setExit1(Exit exit)
  {
    exit1 = exit;
  }
  
  public void setExit2(Exit exit) { exit2 = exit; }
  
  public void setExit3(Exit exit) {
    exit3 = exit;
  }
  
  public void setExit4(Exit exit) { exit4 = exit; }
  
  public Exit getSecretExit() {
    return secretExit;
  }
  
  public void setSecretExit(Exit exit) { secretExit = exit; }
  
  public Item getItem() {
    return item;
  }
  
  public void setItem(Item item) { this.item = item; }
  
  public Creature getCreature() {
    return creature;
  }
  
  public void setCreature(Creature creature) { this.creature = creature; }
}
