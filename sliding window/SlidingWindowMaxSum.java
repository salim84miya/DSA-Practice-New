import java.util.*;

public class SlidingWindowMaxSum{

    public static void main(String[] args){


        int[] arr = {100,400,300,200,-100,-50};


        int max = maxSum(arr,2);

        System.out.println("Max: "+max);

    }


    public static int maxSum(int[] arr,int k){

        int n = arr.length;

        int low =0; 
        int high = k-1;

        int sum = 0;

        for(int i=0; i<k; i++){
            sum = sum + arr[i];
        }

        low++;
        high++;

        int max =0;

        while(high<n){

            sum = sum + arr[high];
            sum = sum - arr[low-1];

            max = Math.max(sum,max);

            low++;
            high++;  
        }

        return max;
    }
}