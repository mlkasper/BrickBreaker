package TextAdventure;

import java.util.Scanner;





public class TextAdventure
{
  public TextAdventure() {}
  
  public static void main(String[] args)
    throws Exception
  {
    Scanner scan = new Scanner(System.in);
    setup();
    scan.next();
  }
  
  public static void setup()
  {
    Player player = new Player("James Stanton", "Tall, unshaved stubble, and glasses. The average 23 year old working to make it through his dreadful life.");
    

    Room bedroom = new Room("Bed Room", "Lavish in every meaning of the word, this room is fit for a king! Looking to the left of the bed you notice a window, it's pitch black. \"I can't tell the time.. damnit.\" Many features grace your eyes as you glance over the room quickly, tiger rug in the middle, and many beautiful painting hang from the walls, getting up to walk about the room, you can't help but feel their eyes follow you. In the corner of the room there is a door.");
    

    Room hallway = new Room("Hallway", "More cold tile on the floor as you step around. The walls are a beautiful embrordered wood with more painting of people hung from their great walls. \"Who the hell owns this place?\" comes accross your mind. Unsure of what to do you look around once more stairs on the right, a dead end on the left. Continuing to look around, across the hall is a cane sitting against the wall.");
    
    Room stairway = new Room("Stairway", "The grand staircase stretches accross two areas meeting at one point to continue down. Carpet covers the middle of the stairs in perfect symetry.The railing made of more beautiful hardwood, a perfect work of craftsmenship. ");
    

    Room greatHall = new Room("The Great Hall", "This place is even bigger than you expected, you see many doors, surely one of them should be open you think. Walking to one exit, you feel the cool breeze from the outside. \"Freedom\" But it's locked. There has to be a key around here somewhere. Trying many other doors you finally find one that is open. Before opening a door, you see millions of spiders coming for you, they may be smallbut they have numbers.");
    


    Room pantry = new Room("The Pantry", "How old do you think this food is? It's probably really old, it's all moldy. The smell hits your nostrils and pierces through you almost knocking you to the groundThere are rats on the ground running around, maybe you should end them. \"They probably drop really good loot, like a video game\"you think. Looking around you see small cracks in the wall, but you're unable to see what's behind it. Something is making a larger noise... You see it. A Mega Rat.");
    


    Room secretRoom = new Room("Torture Den", " \"What the hell is this!\" The room is already lit, someone is here... Many items of torture you've seen in books lie in this room.You're terrifed, \"Why the hell am I here, who brought me here, why is this here!\" you say aloud, not caring if someone could hear you. Locked chests line the walls, there could be something in one of them. Opening one you finda knife. \"This is much better than a wooden cane.\"");
    


    Room secretEnding = new Room("The Tunnels", "Dank, wet and, and dark. The smell of mold hits your nostrils. \"Disgusting.\" The only light you have is from the open door behind you, but you continue into the dark.You hear somethings... It's not rats... it's getting closer... or you're getting closer to it. What could it be. It hits you, knocking you to the floor. You collect yourself and know if you don't fight backyou die. Take this thing head on, and kill it.");
    

    Room forest = new Room("The Forrest", "Tree's and grass, there is much to see here.");
    Room bathroom = new Room("The Bathroom", "There isn't much here besides a golden throne. Something shines in the corner that catches your eye.");
    Room ending = new Room("Dark Tunnels", "Darkness takes your soul.");
    Room outside = new Room("The Outside", "Something hits you, knocking you to the floor. You can't see it, hits you again, you're almost out cold. Fight for survival.");
    
    Item key = new Item("Key", "An old rusted iron key, \"this has to open something.\" ");
    Item cane = new Item("Wooden Cane", "A sturdy wooden cane, possible weapon material.. if you needed it of course.");
    Item knife = new Item("Knife", "Careful it's sharp.");
    Item plunger = new Item("Plunger", "Ewww...");
    Item lamp = new Item("Lamp", "A candle styled lamp... Fire!");
    

    Creature rat = new Creature("Large Rat", "3x the size of a normal rat, this creature is hungry for something more than scraps.", "The rat bursts into flames, killing it slowly. Possible food?");
    Creature theVoid = new Creature("The Void", "Another demention takes this world. Not much is known about this creature as you don't have your lore book.", "The blade must be made of something special, it kills the hellfiend.");
    Creature spiders = new Creature("Spider Hoarde", "There must be thousands of them.", "You smack them with your cane, it leaves an odd smell. Your cane breaks. You toss it to the side.");
    Creature theVoid2 = new Creature("The Void", "A demon from another demention. Not much is known about them since you don't have your lore book.", "I can't tell you why a plunger kills this...");
    
    Exit bedroomDoor = new Exit("Through Bedroom Door", "A heavy wooden door.", "You open the door and enter a long hallway.", null, hallway, false);
    Exit hallwayToStairs = new Exit("To Staircase", "", "You walk down the hallway and come to a set of stairs", stairway);
    Exit stairsToGreatHall = new Exit("Down The Stairs", "The stairs go down to a level point which goes up, then down the middle.", "You walk down the stairs", greatHall);
    Exit stairsToPantry = new Exit("Across The Hall", "A door marked \"Pantry\",", "The door opens subbornly. with it's loud hinges.", pantry);
    Exit greatHallToBathroom = new Exit("Through Bathroom Door", "a lighter wooden door", "You open the door to the bathroom.", bathroom, true);
    Exit greatHallToOutside = new Exit("Through Front Door", "the breeze comes through the wooden and glass door, freedom, but locked.", "You open the door to the outside.", key, outside, true);
    Exit pantryToSecret = new Exit("Wall Crack", "You tear open the wall with your fists, and find a tunnel.", "Naturally you crawl through it... \"What could possibly go wrong\"", secretRoom, true);
    Exit secretToBoss = new Exit("To Metal Door", "This door is made a metal, \"This person doesn't want them to leave\"", "You open the door to continue.", plunger, secretEnding);
    Exit toEnd = new Exit("Farther Down Tunnel", "Darkness", "You continue your way down the tunnels... taking twists and turns until you no longer know where you are. \"Shit.. I wish I didn't have to destroy the lamp...\"", ending, true);
    Exit outsideToForrest = new Exit("To The Forest", "Heavily wooded", "You wander around the forrest, only to realize there isn't much here, you decide to go back.", forest, true);
    
    Exit hallwayToBedroom = new Exit("Back To Bedroom", "A heavy wooden door.", "You open the door and enter a luxurious bedroom.", bedroom);
    Exit stairsToHallway = new Exit("Down The Hallway", "A long hallways that brings you to the masterbed room.", "You climb up the remaining stairs to the bedroom.", hallway);
    Exit greathallToStairs = new Exit("Back To Staircase", "Stairs in the middle which go up and branch off to two sides, one to the hallway, one to the pantry", "You climb up the stairs to the middle platform.", stairway);
    Exit pantryToStairs = new Exit("Back Through Door", "A door opens to stairs that go down a middle platform, which lead up to the hallway, or down to the Great Hall", "You climb down the stairs to the middle platform.", stairway);
    Exit bathroomToGreatHall = new Exit("Back To The Great Hall", "A light wooden door", "You open the door and you walk out to the Great Hall.", greatHall);
    Exit outsideToGreatHall = new Exit("Through Front Door", "A beautiful wooden and glass door that leads to the Great Hall", "You open the door to the hall, it smells of mold. \"The fun stops here\"", greatHall);
    Exit secretToPantry = new Exit("Back to Pantry", "The tunnel is dark", "You're unsure you want to go back through there.");
    Exit bossToSecret = new Exit("Through Metal Door", "The door is open to let the light in.", "You walk back through the door, back to the torture room. ", secretRoom);
    Exit youCantLeave = new Exit("Back to Torture Room", "Darkness", "You've come too far to turn back");
    Exit forrestToOutside = new Exit("Back To Castle", "an open courtyard", "You leave the forest to enter the courtyard of the castle. ", outside);
    
    hallway.setItem(cane);
    pantry.setItem(key);
    secretRoom.setItem(knife);
    bathroom.setItem(plunger);
    bedroom.setItem(lamp);
    
    greatHall.setCreature(spiders);
    outside.setCreature(theVoid2);
    secretEnding.setCreature(theVoid);
    pantry.setCreature(rat);
    
    theVoid.setItemToDestroy(plunger);
    theVoid2.setItemToDestroy(knife);
    spiders.setItemToDestroy(cane);
    rat.setItemToDestroy(lamp);
    

    bedroom.setExit1(bedroomDoor);
    

    hallway.setExit1(hallwayToBedroom);
    hallway.setExit2(hallwayToStairs);
    

    stairway.setExit1(stairsToHallway);
    stairway.setExit2(stairsToGreatHall);
    stairway.setExit3(stairsToPantry);
    

    pantry.setExit1(pantryToSecret);
    pantry.setExit2(pantryToStairs);
    

    bathroom.setExit1(bathroomToGreatHall);
    

    greatHall.setExit1(greatHallToBathroom);
    greatHall.setExit2(greatHallToOutside);
    greatHall.setExit3(greathallToStairs);
    

    outside.setExit1(outsideToGreatHall);
    outside.setExit2(outsideToForrest);
    

    forest.setExit1(forrestToOutside);
    

    secretRoom.setExit1(secretToPantry);
    secretRoom.setExit2(secretToBoss);
    

    secretEnding.setExit2(bossToSecret);
    secretEnding.setExit1(toEnd);
    


    World world = new World(bedroom, ending);
    
    Game game = new Game(world, player);
    
    game.setStartText("You awake in a new place. On top of a comfortable bed. You don't remember falling asleep here \"This place is too nice for me.\" You look around the room for anything that might help you.");
    game.setVictoryText("But where does it take you?");
    
    game.start();
  }
}
