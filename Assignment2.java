package assignments2017.A2PostedCode;

/* STUDENT NAME : Edgar Chang STUDENT ID : 260729484*/

import java.util.Stack;
import java.util.ArrayList;

public class Expression {
  private ArrayList<String> tokenList;

  // Constructor
  /**
   * The constructor takes in an expression as a string and tokenizes it (breaks it up into
   * meaningful units) These tokens are then stored in an array list 'tokenList'.
   */

  Expression(String expressionString) throws IllegalArgumentException {
    tokenList = new ArrayList<String>();
    StringBuilder token = new StringBuilder();

    // ADD YOUR CODE BELOW HERE
    // ..
    for (int i = 0; i < expressionString.length(); i++) {
      Character first = expressionString.charAt(i);
      if (first == ' ') {
        continue;
      }
      if (first == '(' || first == ')' || first == '[' || first == ']') {
        tokenList.add(expressionString.substring(i, i + 1));
      }
      if (first == '+' || first == '-' || first == '*' || first == '/') {
        if (expressionString.charAt(i + 1) == '+' || expressionString.charAt(i + 1) == '-') {
          tokenList.add(expressionString.substring(i, i + 2));
          i++;
          continue;
        }
        tokenList.add(expressionString.substring(i, i + 1));
      }
      if (Character.isDigit(first)) {
        int k = i + 1;
        while (Character.isDigit(expressionString.charAt(k))) {
          k++;
        }
        tokenList.add(expressionString.substring(i, k));
        i = k - 1;

      }
    }
  }
    // ..
    // ADD YOUR CODE ABOVE HERE
 

  /**
   * This method evaluates the expression and returns the value of the expression Evaluation is done
   * using 2 stack ADTs, operatorStack to store operators and valueStack to store values and
   * intermediate results. - You must fill in code to evaluate an expression using 2 stacks
   */
  public Integer eval() {
    Stack<String> operatorStack = new Stack<String>();
    Stack<Integer> valueStack = new Stack<Integer>();

    // ADD YOUR CODE BELOW HERE
    // ..
    for (int i = tokenList.size() - 1; i >= 0; i--) {
      if (isInteger(tokenList.get(i))) {
        valueStack.push(Integer.parseInt(tokenList.get(i)));
      } else {
        operatorStack.push(tokenList.get(i));
      }
    }
    
      
    
    help(operatorStack,valueStack);
    
    // ..
    // ADD YOUR CODE ABOVE HERE

    return valueStack.get(0); // DELETE THIS LINE
  }

  // Helper methods
  
  
  public static void help(Stack<String> op, Stack<Integer> num) {
    if( op.peek().equals("[")){
      op.pop();
      op.push("(");
      help(op,num);
     int i = Math.abs(num.pop());
     num.push(i);
    }
    if (op.peek().equals("(")) {
      op.pop();
      help(op, num);
      
      while(!op.peek().equals(")")&&!op.peek().equals("]")){
      String action = op.pop();
      if(action.equals("++")){
        if(op.peek().equals("(")){       
        help(op,num);   
        }
      }
      if(action.equals("--")){
        if(op.peek().equals("(")){       
        help(op,num);   
        }
      }
      int value = num.pop();
      help(op,num);
      if (action.equals("+")) {
        int interim = value + num.pop();
        num.push(interim);

      } else if (action.equals("-")) {
        int interim = value - num.pop();
        num.push(interim);

      } else if (action.equals("*")) {
        int interim = value * num.pop();
        num.push(interim);

      } else if (action.equals("/")) {
        int interim = value / num.pop();
        num.push(interim);

      } else if (action.equals("++")) {
        int interim = ++value;
        num.push(interim);

      } else if (action.equals("--")) {
        int interim = --value;
        num.push(interim);

      }
    }
      if(op.peek().equals(")")){
        op.pop();
      }
   }

  }
  
  /**
   * Helper method to test if a string is an integer Returns true for strings of integers like "456"
   * and false for string of non-integers like "+" - DO NOT EDIT THIS METHOD
   */
  private boolean isInteger(String element) {
    try {
      Integer.valueOf(element);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * Method to help print out the expression stored as a list in tokenList. - DO NOT EDIT THIS
   * METHOD
   */

  @Override
  public String toString() {
    String s = new String();
    for (String t : tokenList)
      s = s + "~" + t;
    return s;
  }

}
