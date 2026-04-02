import java.util.ArrayList;

public class NLPRunner {
  public static void main(String[] args) {

    // Instantiate a MyNLP object ("student-developed class")
    MyNLP nlp = new MyNLP();
  
  
  // Calls prompt() method to collect user input (optional)
    nlp.prompt();

    // Prints the summary/result of the NLP project
    nlp.printSummary();
    
  }
}
