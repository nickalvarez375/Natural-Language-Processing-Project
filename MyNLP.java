import java.util.ArrayList;
import java.util.Scanner;

public class MyNLP {

  // TODO: Create 1-2 meaningful ArrayList 
  
  ArrayList<String> firstNames; 
  ArrayList<String> lastNames;
  ArrayList<String> detectedNames;
   
public MyNLP() {
firstNames = new ArrayList<String>();
lastNames = new ArrayList<String>();
detectedNames = new ArrayList<String>();
loadNames();
}
  
  /**
   * Javadoc example
   * @param parameter1 the first parameter
   * @return what is returned from this method
   */

  /**
   * Starts the app and gets user input
   */
  public void loadNames() {
    TextProcessor firstProcessor = new TextProcessor("text-file1.txt");
    TextProcessor lastProcessor = new TextProcessor("text-file2.txt");    
    
    firstNames = firstProcessor.getWordList();
    lastNames = lastProcessor.getWordList();
  }

  public void detectNames(String input) {
    String[] words = input.split(" ");
  
    for (int i = 0; i < words.length; i++) {
      String currentWord = words[i].replaceAll("[^a-zA-Z]", "");
      if (firstNames.contains(currentWord) || lastNames.contains(currentWord)) {
        if(!detectedNames.contains(currentWord)) {
          detectedNames.add(currentWord);

          if (i < words.length - 1) {
            String nextWord = words[i+1].replaceAll("[^a-zA-Z]", "");
            String pair = currentWord + " " + nextWord;

            if (firstNames.contains(currentWord) && lastNames.contains(nextWord)) {
              if (!detectedNames.contains(pair)) {
                detectedNames.add(pair);
              }
            }
          }
        }
      }
    } 
  }

  public void prompt() {
    Scanner input = new Scanner(System.in);    
    //starting Text
    System.out.println("Welcome to my Name Detector!");
    System.out.println("Enter a sentence to analyze it:");
    String userSentence = input.nextLine(); // collect userInput
    detectNames(userSentence);

    System.out.println("analysis complete");
    
    // Logic for userInput
    String userInput = input.nextLine(); // Added this to capture the choice below
    if (userInput.equals("1")) {
      System.out.println("Option 1 selected");
      // add code here for option 1
      
    } else if (userInput.equals("2")) {
      System.out.println("Option 2 selected");
      // add code here for option 2
      
    } else {
      // Error Handling
      System.out.println("\nSorry, I dont understand that."); 
      System.out.println("Please restart, and only choose option 1 or 2"); 
    }
    
    System.out.println("\nGoodbye!");
    input.close();
  }  

  /**
   * Prints the summary of my NLP project
   */
  public void printSummary() {
    System.out.println("Potential Names Detected");
    if (detectedNames.isEmpty()) {
      System.out.println("No names found.");
    } else {
      for (String name : detectedNames) {
        System.out.println("- " + name);
      }
    }
  }
}