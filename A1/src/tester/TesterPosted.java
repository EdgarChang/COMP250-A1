package tester;

import java.math.BigInteger;

public class TesterPosted {
    
    public static void main(String[] args) throws Exception {
                        
        //  You can test the correctness of your NaturalNumber implementation 
        //  by using Java's BigInteger class.  
        
        //  Here is an example.  
        
        //String s1 = "42345614234561000343453440000343453440";
        //String s2 = "22320000423456100034345344000042";

        int base = 8;
        String s1 = "7154752147";
        String s2 = "176472476";
        
        BigInteger big1 = new BigInteger(s1,base);
        BigInteger big2 = new BigInteger(s2,base);
        
        NaturalNumber n1 = new NaturalNumber(s1, base);
        System.out.println("n1 is    " + n1);
        NaturalNumber n2 = new NaturalNumber(s2, base);
        System.out.println("n2 is    " + n2);
        System.out.println("");
              
        //  The BigInteger class uses an 'add' method for addition, but NaturalNumber 
        //  uses 'plus' instead, to avoid confusion with the LinkedList's 'add' method
        //  which inserts an element.
        
        System.out.print("sum: big1+big2 =        (");
        System.out.println(big1.add(big2).toString(base) + ")_" + base );  // BigInteger
        System.out.print("sum: n1+n2     =        ");
        System.out.println(n1.plus(n2));                     // NaturalNumber
        System.out.println();
        //  The BigInteger class uses a 'subtract' method for addition, but NaturalNumber 
        //  uses 'minus' instead.  This name was chosen because it was a better match 
        //  for 'plus'.

        System.out.print("diff: big1-big2 =       (");
        System.out.println(big1.subtract(big2).toString(base)  + ")_" + base );  // BigInteger
        System.out.print("diff: n1-n2     =       ");
        System.out.println(n1.minus(n2));                         // NaturalNumber
        //  The BigInteger class uses a 'multiply' method for addition. NaturalNumber 
        //  uses 'times' instead.  
        System.out.println();
        
        System.out.print("multiply: big1*big2   = ("  );              // BigInteger
        System.out.print(big1.multiply(big2).toString(base)  );
        System.out.println( ")_" + base);
        
        System.out.print("multiply: n1*n2       = ");               // NaturalNumber
        System.out.println(n1.times(n2));
        System.out.println();
        
        System.out.print("slow multiply: n1*n2  = ");               // NaturalNumber
        //System.out.println(n1.slowTimes(n2));
        System.out.println();
        System.out.print("divide: big1/big2     = (");              // BigInteger  
        System.out.println(big1.divide(big2).toString(base)  + ")_" + base);

        System.out.print("divide: n1/n2         = ");                 // NaturalNumber
        System.out.println(n1.divide(n2));
        System.out.println();
        
        System.out.print("slow divide: n1/n2    = ");               // NaturalNumber
        //System.out.println(n1.slowDivide(n2));

        /*   mod
        
        System.out.print("mod = ");
        System.out.println(big1.subtract(big1.divide(big2).multiply(big2)));
        System.out.println(big1.mod(big2));
        
        */
    }
    
}



/*
int i;
int carry = 0;
for (i = 0; i < firstClone.coefficients.size(); i++) {
  sum.coefficients.addLast(
      (firstClone.coefficients.get(i) + secondClone.coefficients.get(i) + carry) % getBase());
  carry =
      (firstClone.coefficients.get(i) + secondClone.coefficients.get(i) + carry) / getBase();
}
if (carry != 0) {
  sum.coefficients.addLast(1);
  
  
  
  NaturalNumber mix = new NaturalNumber(this.base);

  for (int i = 0; i < this.coefficients.size(); i++) {

    mix = this.timesSingleDigit(this.coefficients.get(i), multiplicand);

    mix.timesBaseToThePower(i);

    product = product.plus(mix);
  }
  while ((product.coefficients.size() > 1) & (product.coefficients.getLast().intValue() == 0)) {
    product.coefficients.removeLast();
  }

  public NaturalNumber timesSingleDigit(int a, NaturalNumber multiplicand) {
    NaturalNumber result = new NaturalNumber(this.base);
    int carry = 0;
    for (int i = 0; i < multiplicand.coefficients.size(); i++) {
      result.coefficients.addLast((a * multiplicand.coefficients.get(i) + carry) % this.base);
      carry = ((a * multiplicand.coefficients.get(i)) + carry) / this.base;
    }
    if (carry != 0) {
      result.coefficients.addLast(carry);
    }
    return result;
  }
  
  
  int diff = first.coefficients.size() - secondClone.coefficients.size();

  while (diff > 0) {
    secondClone.coefficients.addLast(0);
    diff--;
  }
  for (int i = 0; i < first.coefficients.size(); i++) {
    if (first.coefficients.get(i) >= secondClone.coefficients.get(i)) {
      difference.coefficients
          .addLast(first.coefficients.get(i) - secondClone.coefficients.get(i));
    } else {
      difference.coefficients.addLast(first.coefficients.get(i) + first.base - secondClone.coefficients.get(i));
      int j = i + 1;
      while (first.coefficients.get(j) == 0) {
        j++;
      }
      
      first.coefficients.set(j, first.coefficients.get(j) - 1);
      
      for (int k = j - 1; k > i; k--) {
        first.coefficients.set(k, first.base - 1);
      }
    
    }
    

  }
  
  NaturalNumber div = divisor.clone();
  NaturalNumber set = this.clone();
  NaturalNumber temp = new NaturalNumber(this.base);

  int size = set.coefficients.size() - 1;
  for (int i = 0; i < set.coefficients.size(); i++) {
    temp.coefficients.addFirst(set.coefficients.get(size - i));
    int sam = temp.slowDivide(div).coefficients.get(0);
    quotient.coefficients.addFirst(sam);
    NaturalNumber quot = new NaturalNumber(this.base);
    quot.coefficients.addLast(quotient.coefficients.getFirst());
    if (temp!=quot.times(div)) {
      temp=temp.minus(quot.times(div));
    } else {
      temp.coefficients.addLast(0);
    }
  }
  remainder = temp;
  while ((quotient.coefficients.size() > 1)
      & (quotient.coefficients.getLast().intValue() == 0)) {
    quotient.coefficients.removeLast();
*/