import java.util.*;
import java.io.*;


public class PicnicItemStore {
  //initialise HashMap as m
  protected Map <String, List<String>> m;

  //initialise PicnicItemStore() without an argument
  public PicnicItemStore(){
    m = new HashMap<>();
  }

  //initialise PicnicItemStore() with one argument, throws IOException if file is not found
  public PicnicItemStore(String fileName) throws IOException {
    m = new HashMap<>();
    BufferedReader br = new BufferedReader(new FileReader(fileName));

    try{
      String key;
      String line;
      while ((line= br.readLine()) != null){
          line = line.toLowerCase();
          String item = line;
	        key = line.substring(0,1);
	        if (m.get(key) == null) {
	            m.put(key, new ArrayList<String>());
	        }
	        m.get(key).add(item);
    	  }
      }

    finally{
      br.close();
    }
  }

  //initialise PicnicItemStore() with two arguments, throws IOException if file is not found
  public PicnicItemStore(String fileName, int maxPrefix) throws IOException {
    m = new HashMap<>();
    BufferedReader br = new BufferedReader(new FileReader(fileName));

    try{
      String key;
      String line;
      //while loop goes through each item in item store
      while ((line= br.readLine()) != null){
          line = line.toLowerCase();
          String item = line;

        //for loop extracts prefixes of length 1 to maxPrefix, adds to HashMap accordingly with prefixes as "key" and item as "value"
    	  for (int i=1; i <= maxPrefix; i++) {
          if ( i > line.length()){
            break;
          }
    	        key = line.substring(0,i);
    	        if (m.get(key) == null) {
    	            m.put(key, new ArrayList<String>());
    	        }
    	        m.get(key).add(item);
    	  }
      }
    }

     catch (IOException e){
       System.out.println("file not found");
     }

    finally{
      br.close();
    }
  }

  //checks if given key is in HashMap m
  public boolean containsKey(String key){
    if (m.containsKey(key)){
      return true;
    }
    return false;
  }

  //puts key and value into HashMap
  public void put(String key, String item){
    if (m.get(key) == null) {
        m.put(key, new ArrayList<String>());
    }
    m.get(key).add(item);
  }

  //gets item randomly within a given key and returns item with the "key" capitalised
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
        String randomCapital = randomItem.substring(0,1).toUpperCase() + randomItem.substring(1);
        return randomCapital;
      }
      else{
        return null;
      }
    }
  }

  //  //gets item randomly within a given key and maxPrefix length, and returns item with the "key" capitalised
  public String getRandomItem(String key, int maxPrefix){
    key = key.toLowerCase();
    if (m.containsKey(key) == false){
      return null;
    }
    else{
      Random rand = new Random();
      if (m.containsKey(key)) {
        int randomItemPointer = rand.nextInt(m.get(key).size());
        String randomItem = m.get(key).get(rand.nextInt(m.get(key).size()));
        String randomCapital = randomItem.substring(0,maxPrefix).toUpperCase() + randomItem.substring(maxPrefix);
        return randomCapital;
      }
      else{
        return null;
      }
    }
  }
}
