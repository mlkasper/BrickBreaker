package TextAdventure;



public class Creature
{
  private String name;
  

  private String description;
  
  private String defeatedText;
  
  private Item itemToDestroy;
  

  public Creature(String name, String description, String defeatedText)
  {
    this.name = name;
    this.description = description;
    this.defeatedText = defeatedText;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() { return description; }
  
  public String getDefeatedText() {
    return defeatedText;
  }
  
  public Item getItemToDestroy() { return itemToDestroy; }
  
  public void setItemToDestroy(Item item) {
    itemToDestroy = item;
  }
}
