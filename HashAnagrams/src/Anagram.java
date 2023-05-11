import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    private HashMap<String,ArrayList<String>> myWords;
    
    public Anagram() {
        myWords = new HashMap<String,ArrayList<String>>();
    }
    
    private String sortString(String s){
       char[] theArray = s.toCharArray();
       Arrays.sort(theArray);
       return new String(theArray); 
    }

    public void initialize(String filename){
        //Read a file and load the words into the hashmap
        File f = new File(filename);
        Scanner theScanner = null;
        int count = 0;
        try{
            theScanner = new Scanner(f);
            while(theScanner.hasNextLine()){
                String line = theScanner.nextLine();
                String word = line.toLowerCase();
                String key = this.sortString(word);
                //Does the entry already exist?
                ArrayList<String> val = myWords.get( key );
                if(val == null){
                    //create new arraylist for the value
                    val = new ArrayList<String>();
                }
                //put the word in the return val arraylist
                val.add(word);
                //put the (key,arraylist) pair into the hashmap
                myWords.put(key,val);
                count++;
            }
            System.out.println(myWords.get(sortString("acenrt")));
            System.out.println(count);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        theScanner.close();
    }
    
    public void maxAnagram(){
        int max = 0;
        ArrayList<String> maxAna = new ArrayList<String>();
        for (ArrayList<String> anagramList : myWords.values()) {
            if(anagramList.size() > max){
                max = anagramList.size();
                maxAna = anagramList;
            }
        }
        System.out.println("The Largest Anagram list is : " + maxAna);
    }
}
