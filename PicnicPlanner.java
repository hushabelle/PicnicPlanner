import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;


public class PicnicPlanner extends PicnicItemStore{
  //declare all item load
  private PicnicItemStore fruitLoad;
  private CheeseStore cheeseLoad;
  private DrinkStore drinkLoad;
  public int maxPrefix;

  //initialise PicnicPlanner() without an argument
  public PicnicPlanner()throws IOException{
    fruitLoad = new PicnicItemStore("fruits.txt");
    cheeseLoad = new CheeseStore("cheeses.txt");
    drinkLoad = new DrinkStore("drinks.txt");
  }

  //initialise PicnicPlanner() with one argument, maxPrefix. throws IOException if file is not found
  public PicnicPlanner(int maxPrefix)throws IOException{
    this.maxPrefix = maxPrefix;
    fruitLoad = new PicnicItemStore("fruits.txt", maxPrefix);
    cheeseLoad = new CheeseStore("cheeses.txt", maxPrefix);
    drinkLoad = new DrinkStore("drinks.txt", maxPrefix);
  }

  //generates the picnic planner based on given input and maxPrefix, returns list of items
  public List<String> generate(String input, int maxPrefix){
    //number of letters in a word
    int itemsToPrint = input.length();
    //number of letters sorted
    int sortedCount = 0;
    //case selection variable
    int i = 0;
    String PicnicItem = "";
    List<String> picnicItemList = new ArrayList<>();

    //loops until all letters in input are sorted
    while (i<itemsToPrint && sortedCount<itemsToPrint){
      int currentPrefix = maxPrefix;
      String letterOrLettersToGenerate;
      boolean havePrinted = false;
      int endPointer;
      //selects case 0:fruit 1:cheese 2:drink accordingly
      int caseSelection = i%3;
      switch (caseSelection){
        //in the case of printing a fruit,
        case 0 :
        //loops until something is printed
        while (havePrinted == false){
          //ensures endPointer will never go out of bounds
          if (sortedCount+currentPrefix > itemsToPrint){
            currentPrefix=itemsToPrint-sortedCount;
            endPointer = itemsToPrint;
          }
          else{
            endPointer = sortedCount+currentPrefix;
          }

          //creates "key" of size currentPrefix
          letterOrLettersToGenerate = input.substring(sortedCount, endPointer);
          //if "key" is found, print item; if not, decrement currentPrefix and create new "key"
          if (fruitLoad.m.containsKey(letterOrLettersToGenerate)){
            PicnicItem = fruitLoad.getRandomItem(letterOrLettersToGenerate, currentPrefix);
            picnicItemList.add(PicnicItem + "\n");
            sortedCount+= currentPrefix;
            i++;
            System.out.println(PicnicItem);
            havePrinted = true;
          }
          else{
            currentPrefix--;
            continue;
          }

          if (sortedCount == itemsToPrint) {
            break;
          }
        }
        break;


        //in the case of printing a cheese,
        case 1 :
        //loops until something is printed
        while (havePrinted == false){
          //ensures endPointer will never go out of bounds
          if (sortedCount+currentPrefix > itemsToPrint){
            currentPrefix=itemsToPrint-sortedCount;
            endPointer = itemsToPrint;
          }
          else{
            endPointer = sortedCount+currentPrefix;
          }

          //creates "key" of size currentPrefix
          letterOrLettersToGenerate = input.substring(sortedCount, endPointer);
          //if "key" is found, print item; if not, decrement currentPrefix and create new "key"
            if (cheeseLoad.m.containsKey(letterOrLettersToGenerate)){
              PicnicItem = cheeseLoad.getRandomItem(letterOrLettersToGenerate, currentPrefix);
              picnicItemList.add(PicnicItem + "\n");
              sortedCount+= currentPrefix;
              i++;
              System.out.println(PicnicItem);
              havePrinted = true;

            }

            else{
              currentPrefix--;
              continue;
            }


            if (sortedCount == itemsToPrint) {
              break;
            }
          }
          break;


        //in the case of printing a drink,
        case 2 :
        //loops until something is printed
        while (havePrinted == false){
          //ensures endPointer will never go out of bounds
          if (sortedCount+currentPrefix > itemsToPrint){
            currentPrefix=itemsToPrint-sortedCount;
            endPointer = itemsToPrint;
          }
          else{
            endPointer = sortedCount+currentPrefix;
          }

          //creates "key" of size currentPrefix
          letterOrLettersToGenerate = input.substring(sortedCount, endPointer);
          //if "key" is found, print item; if not, decrement currentPrefix and create new "key"
          if (drinkLoad.m.containsKey(letterOrLettersToGenerate)){
            PicnicItem = drinkLoad.getRandomItem(letterOrLettersToGenerate, currentPrefix);
            picnicItemList.add(PicnicItem + "\n");
            sortedCount+= currentPrefix;
            i++;
            System.out.println(PicnicItem);
            havePrinted = true;

          }

          else{
            currentPrefix--;
            continue;
          }

          if (sortedCount == itemsToPrint) {
            break;
          }
        }
        break;
      }
    }
    return picnicItemList;
  }

  //main method takes in command line arguments and handles exceptions
  public static void main (String[] args) throws IOException{
      int maxPrefix;
      //if only a name is given with no maxPrefix,
      if (args.length == 1){
        maxPrefix = 1;
      }

      else{
        maxPrefix = Integer.parseInt(args[1]);
      }

      try{
        if (args.length != 0) {
          String arg = args[0].toLowerCase();
          for (int i = 0; i < arg.length(); i++) {
            boolean isLetter = Character.isLetter(arg.toCharArray()[i]);
            if (isLetter) {
              break;
            }
          }
          PicnicPlanner generateWord = new PicnicPlanner(maxPrefix);
          generateWord.generate(arg, maxPrefix);
        }
      }
      catch (Exception e){
        System.err.println("Enter input of only letters!");
        System.exit(0);
      }
    }
  }
