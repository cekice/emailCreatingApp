package sumprime;

public class SumPrime {

    public static void main(String[] args) {
        
    int count = 0;
    int sum = 0;
    int number = 2;
     
     while(count<1000){
         if(isPrime(number)){
         sum += number;
         count++;
                 }
        number++;

     }
     System.out.println(sum);
    }

    private static boolean isPrime(final int number){
        for(int i=2; i<=number/2; i++){
            if(number % i == 0){
            return false;
            }
        }
    return true;
    }
}
