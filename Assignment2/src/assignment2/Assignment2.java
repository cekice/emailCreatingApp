package assignment2;

import java.util.Arrays;


public class Assignment2  {

    public static void main(String[] args) {
        
        int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};
        
        int positive = 0;
        int negative = 0;
        
        for(int i : array){
        
            if(i > 0)
                positive++;
            if(0 > i)
                negative++;
        }
        
        int[] posArray = new int[positive];
        int[] negArray = new int[negative];
        
        positive = 0;
        negative = 0;
        
        for(int i : array){
            
            if(i > 0){
                posArray[positive] = i;
                positive++;
            }
            if(i < 0){
                negArray[negative] = i;
                negative++;
            }
        }
        System.out.print("Pozitivni brojevi niza su: ");
        System.out.println(Arrays.toString(posArray));
        System.out.print("Negativni brojevi niza su: ");
        System.out.println(Arrays.toString(negArray));
       
        Arrays.sort(array);
        
        { for(int i=1; i<array.length;i++){
                
                if(array[i-1] == array[i])
                
                System.out.println("Dupli brojevi iz niza su: " + array[i]);
            }
        }
        
        
        
    }
}
        
  