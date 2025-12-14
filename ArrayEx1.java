public class ArrayEx1 {

    public static void main(String args[]) {
        int [] primeNum = new int[9];
        primeNum[0] = 2;
        primeNum[1] = 3;
        int[] primeNum2 = primeNum;
        System.out.println(primeNum2[0]);
        primeNum2[0] = 5;
        System.out.println(primeNum[0]);
        primeNum[0] = 5;
        // System.out.println(primes[0]);
       //int[] primeNum = new long[20];
        //int even=new int[5];
        long[] primes = new long[20];
        primes[0] = 5;
        primes[1] = 1;
        long[] primes2 = primes;
        System.out.println(primes2[0]);
        primes2[0] = 5;
        System.out.println(primes[0]);

        String[] names = {"Mary", "Bob", "Carlos"};
        int[] ages = {25, 27, 48};
        for (int idx = 0; idx < names.length; idx++) {
            System.out.println(names[idx] + " is " + ages[idx] + " years old.");
        }

    }

}
