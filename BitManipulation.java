public class BitManipulation {

  public static void oddOrEven(int n) {
    int bitMask = 1;
    if ((n & bitMask) == 1) {
      System.out.println("The given number " + n + " is odd.");
    } else {
      System.out.println("The given number " + n + " is even.");
    }
  }

  public static int getithBit(int n, int i) {

    int bitMask = 1 << i;
    if ((n & bitMask) == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  public static int setIthBit(int n, int i) {

    int bitMask = 1 << i;

    return n | bitMask;
  }

  public static int clearIthBit(int n, int i) {

    int bitMask = ~(1 << i);

    return n & bitMask;
  }

  public static int updateIthBit(int n, int i, int newBit) {

    /*
     * if (newBit == 0){
     * return clearIthBit(n,i);
     * }else{
     * return setIthBit(n,i);
     * }
     */

    n = clearIthBit(n, i);
    int bitMask = newBit << i;
    return n | bitMask;
  }

  public static int clearIbits(int n, int i){

    int bitMask=(~0<<i);
    return n&bitMask;
  }
  public static int clearRangeBits(int n, int i, int j){

    int a = ((~0)<<(j+1));
    int b = (1<<i)-1;
    int bitMask = a|b;

    return n&bitMask;
  }

  public static void main(String[] args) {
    // System.out.println(5 & 6);
    // System.out.println(5|6);
    // System.out.println(5^6);
    // System.out.println(~5);
    // System.out.println(5>>2);
    // oddOrEven(3);
    // oddOrEven(14);
    // System.out.println(getithBit(10, 2));
    // System.out.println(getithBit(10, 3));
    // System.out.println(setIthBit(10, 2));
    // System.out.println(clearIthBit(10,1));
    // System.out.println(updateIthBit(10, 2, 1));
    System.out.println(clearIbits(15, 2));
  }
}