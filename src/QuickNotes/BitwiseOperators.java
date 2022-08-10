package QuickNotes;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 67;
        System.out.println("******************** Operators ********************");
        System.out.println("1. And (&): " + (a&1) + ":" + (a&0));
        /*
         * to check if a number is even or odd we can use bitwise operator
         * use and (&) operator with the last bit
         * eg: a & 1
         * if the ans is 1 then the number is odd else even
         * i.e. if the last bit of the number is 1 then performing & with 1 will give 1 else 0
         * eg: 67 & 1 will be
         *  1000011
         * &0000001
         * _________
         * =0000001
         * ---------
         * hence the number is odd
         */

        System.out.println("2. Or (|): " + (a|1) + ":" + (a|0));
        // we cannot check whether the number is even or odd with or (|) operation since it will return only the higher bit

        System.out.println("3. XOR (^): " + (a^1) + ":" + (a^0) + ":" + (a^a));
        /*
         * if we xor a number with:
         * 1. 1 we get complement (number - 1)
         * 2. 0 we get the same number
         * 3. the number itself we get 0.
         * */

        System.out.println("4. not (~): " + (~a));
        // negation or not is a unary operator which will give the negative value of (number - 1)

        System.out.println("5. Left Shift Operator (<<): " + (a<<1));
        /*
         * the left shift operator will shift the bits by a given value towards the left
         * eg: binary value of 67 is 1000011, and we will perform left shift on it
         * we will shift all the bits to the left by 1 and add a 0 at the last index/position
         * the ans will be 10000110 which is equal to 134
         * hence we will b 0's to the right of the binary value
         * left shift with 1 is equivalent to multiply by 2
         * the generalized formula is:    a<<b = a * (2 power b)
         * */

        System.out.println("6. Right Shift Operator (>>): " + (a>>1));
        /*
         * shifts the bits to the right and ignore the last bit
         * in the given eg, the binary value of 67, i.e., 1000011, will change to 100001 which is equal to 33
         * removing the last b digits in a>>b
         * right shift with 1 is equivalent to divide by 2
         * the generalized formula is: a>>b = a / (2 power b)
         * division with a large number will give 0
         * */

        System.out.println("\n******************** Usages ********************");
        System.out.println("1. To check whether the number is even or odd.");
        System.out.println("2. To find the unique element in an array we can use xor operator and the property: a^a = 0 to eliminate the similar elements.");
        System.out.println("3. To find the ith bit of a number by performing and operation with 1 at the ith position (bitmasking).");
        int mask = 1 << (a - 1);
        System.out.println("\tfor eg: mask of 67 is: " + mask + " and after performing operation: " + (a & mask));
        System.out.println("4. To set the ith bit, i.e, change the value to 1 if not already, use the or operator.");
        System.out.println("5. To reset the ith bit, i.e, change the value to 0, use & operator with 0 at ith position.mask = !(1<<(a-1))");
        System.out.println("6. To find if the given number is a power of two: n&(n-1)=0");
        System.out.println("7. To create mask in a given range for eg: 000 to 111 where n=3, we can use the range 2powern to 2powern+1 (int this case 1000 to 1111) and create a substring from the next index.");
        System.out.println("bitmask: " + (a & ~(a-1)));
        int xor = 7;
        System.out.println("bitmask for the rightmost set bit: " + (xor & (~xor + 1)) + " or " + (xor & -xor));
    }
}
