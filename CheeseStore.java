import java.util.*;
import java.io.*;
import java.io.IOException;


public class CheeseStore extends PicnicItemStore{
  //initialise CheeseStore() without an argument
  public CheeseStore(){
    super();
  }

  //initialise CheeseStore() with an argument, input. throws IOException if file is not found
  public CheeseStore(String input) throws IOException{
    super(input);
  }
  //initialise CheeseStore() with two arguments, input and maxPrefix. throws IOException if file is not found
  public CheeseStore(String input, int maxPrefix) throws IOException{
    super(input, maxPrefix);
  }

  //override getRandomItem() in PicnicItemStore class
  @Override
  public String getRandomItem(String key){
    key = key.toLowerCase();
    if (m.containsKey(key) == false){
      return null;
    }
    else{
      Random rand = new Random();
      if (m.containsKey(key)) {

        int randomItemPointer = rand.nextInt(m.get(key).size());
        String randomItem = m.get(key).get(randomItemPointer);
        String randomCapital = randomItem.substring(0,1).toUpperCase() + randomItem.substring(1) + " (cheese)";
        return randomCapital;
      }
      else{
        return null;
      }
    }
  }

  //override getRandomItem() in PicnicItemStore class which takes in extra input, maxPrefix
  @Override
  public String getRandomItem(String key, int maxPrefix){
    key = key.toLowerCase();
    if (m.containsKey(key) == false){
      return null;
    }
    else{
      Random rand = new Random();
      if (m.containsKey(key)) {

        int randomItemPointer = rand.nextInt(m.get(key).size());
        String randomItem = m.get(key).get(randomItemPointer);
        String randomCapital = randomItem.substring(0,maxPrefix).toUpperCase() + randomItem.substring(maxPrefix) + " (cheese)";
        return randomCapital;
      }
      else{
        return null;
      }
    }
  }
}
