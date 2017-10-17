package tester;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class Tester2 {

      // Number of tests to run per base
      final static long TEST_COUNT = 50;
      
      // Number of concatenations
      final static long CONCAT_COUNT = 3;
      
      public static void main(String[] args) throws Exception
      {
          
          for (int base = 2; base <= 10; base++)
          {
              System.out.println("BASE: " + base + "...");
              
              int count = 0;
              while (count++ < TEST_COUNT)
              {
                  StringBuilder s1 = new StringBuilder();
                  StringBuilder s2 = new StringBuilder();
                  
                  int concat = 0;
                  while (concat++ < CONCAT_COUNT)
                  {
                      long a = ThreadLocalRandom.current().nextLong(2, Long.MAX_VALUE);
                      long b = ThreadLocalRandom.current().nextLong(1, a);
          
                      assert(a > b);
                      
                      s1.append(Long.toString(a, base));
                      s2.append(Long.toString(b, base));
                      
                  }
                  
                  String bigResult;
                  String nnResult;
                  
                  NaturalNumber n1 = new NaturalNumber(s1.toString(), base);
                  NaturalNumber n2 = new NaturalNumber(s2.toString(), base);
                  
                  BigInteger big1 = new BigInteger(s1.toString(), base);
                  BigInteger big2 = new BigInteger(s2.toString(), base);
                  
                  // ADDITION
                  bigResult = "(" + big1.add(big2).toString(base) + ")_" + base;
                  nnResult = n1.plus(n2).toString();
                  
                  if (!bigResult.equals(nnResult))
                  {
                      printErrMessage("Addition", bigResult, nnResult, base);
                      return;
                  }
                  
                  System.out.println("Addition: Complete");
                  
                  // SUBTRACTION
                  bigResult = "(" + big1.subtract(big2).toString(base)  + ")_" + base;
                  nnResult = n1.minus(n2).toString();
                  
                  if(!bigResult.equals(nnResult))
                  {
                      printErrMessage("Subtraction", bigResult, nnResult, base);
                      return;
                  }
                  
                  System.out.println("Subtraction: Complete");
                  
                  // MULTIPLICATION
                  bigResult = "(" + big1.multiply(big2).toString(base) + ")_" + base;
                  nnResult = n1.times(n2).toString();
                  
                  if (!bigResult.equals(nnResult))
                  {
                      printErrMessage("Multiplication", bigResult, nnResult, base);
                      return;
                  }
                  
                  System.out.println("Multiplication: Complete");
                  
                  // DIVISION
                  bigResult = "(" + big1.divide(big2).toString(base) + ")_" + base;
                  nnResult = n1.divide(n2).toString();
                  
                  if (!bigResult.equals(nnResult))
                  {
                      printErrMessage("Division", bigResult, nnResult, base);
                      return;
                  }
                  
                  System.out.println("Division: Complete");
                  
                  // DIVISION FLIP
                  bigResult = "(" + big2.divide(big1).toString(base) + ")_" + base;
                  nnResult = n2.divide(n1).toString();
                  
                  if (!bigResult.equals(nnResult))
                  {
                      printErrMessage("Flipped division", bigResult, nnResult, base);
                      return;
                  }
                  
                  System.out.println("Flipped Division: Complete");
                  
              }
              
              System.out.println("Complete!");
              System.out.println("\n-------------\n");
              
              
          }

          System.out.println("\nTEST SUCCESS");
      }
      
      public static void printErrMessage(String operation, String expected, String computed, int base)
      {
          System.err.println("Error! " +  operation + " problem detected with base " + base);
          System.err.println("Expected:");
          System.err.println(expected);
          System.err.println("Computed:");
          System.err.println(computed);
      }
          
  }
