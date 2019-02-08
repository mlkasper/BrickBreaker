package TextAdventure;



public class World
{
  Room room;
  
  Room endingRoom;
  

  public Room getStartingRoom()
  {
    return room;
  }
  
  public Room getEndingRoom() { return endingRoom; }
  
  public World(Room startingRoom, Room endingRoom) {
    room = startingRoom;
    this.endingRoom = endingRoom;
  }
}
