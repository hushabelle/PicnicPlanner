import java.util.*;
import java.io.*;

public class DrinkStore extends PicnicItemStore{
  //initialise DrinkStore() without an argument
  public DrinkStore(){
    super();
  }
  //initialise DrinkStore() with one argument, input. throws IOException if file is not found
  public DrinkStore(String input) throws IOException{
    super(input);
  }

  //initialise DrinkStore() with two arguments, input and maxPrefix. throws IOException if file is not found
  public DrinkStore(String input, int maxPrefix) throws IOException{
    super(input,maxPrefix);
  }

  //override getRandomItem() in PicnicItemStore class, and considers alcohol percentage
  @Override
  public String getRandomItem(String key){
    key = key.toLowerCase();
    //if given key is not in HashMap
    if (m.containsKey(key) == false){
      return null;
    }
    //if given key is in HashMap
    else{
      Random rand = new Random();
      if (m.containsKey(key)) {
        int randomItemPointer = rand.nextInt(m.get(key).size());
        String randomItem = m.get(key).get(randomItemPointer);
        String randomCapital = randomItem.substring(0,1).toUpperCase() + randomItem.substring(1);
        //make list of drink, seperate by space and get the last element a.k.a. the percentage
        String[] DrinkSep;
        DrinkSep = randomCapital.split(" ");
        String alcLevel = DrinkSep[DrinkSep.length-1];
        //make the last element into integer
        int level = Integer.parseInt(alcLevel);
        if (level>= 12){
          randomCapital = randomCapital.concat(" (strong wine)");
        }
        else if (level > 0){
          randomCapital = randomCapital.concat(" (wine)");
        }
        else{
          randomCapital = randomCapital.concat(" (soft drink)");
        }
        return randomCapital;
      }
      else{
        return null;
      }
    }
  }

  //override getRandomItem() in PicnicItemStore class which takes in extra input, maxPrefix, and considers alcohol percentage
  @Override
  public String getRandomItem(String key, int maxPrefix){
    key = key.toLowerCase();
    //if given key is not in HashMap
    if (m.containsKey(key) == false){
      return null;
    }
    else{
      Random rand = new Random();
      if (m.containsKey(key)) {
        int randomItemPointer = rand.nextInt(m.get(key).size());
        String randomItem = m.get(key).get(randomItemPointer);
        String randomCapital = randomItem.substring(0,maxPrefix).toUpperCase() + randomItem.substring(maxPrefix);
        //make list of drink, seperate by space and get the last element aka the percentage
        String[] DrinkSep;
        DrinkSep = randomCapital.split(" ");
        String alcLevel = DrinkSep[DrinkSep.length-1];
        //make the last element into integer
        int level = Integer.parseInt(alcLevel);
        if (level>= 12){
          randomCapital = randomCapital.concat(" (strong wine)");
        }
        else if (level > 0){
          randomCapital = randomCapital.concat(" (wine)");
        }
        else{
          randomCapital = randomCapital.concat(" (soft drink)");
        }
        return randomCapital;
      }
      else{
        return null;
      }
    }
  }
}
