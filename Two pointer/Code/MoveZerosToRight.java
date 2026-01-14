//leet code 283

public class MoveZerosToRight{

    public static void main (String[] args){

        int[] arr = {1,3,0,0,5,8,6};

        moveZeros(arr);

        for(int i :arr){

            System.out.print(" "+i);    
        }


    }


    public static void moveZeros(int[] nums){

        int n = nums.length;

        int prev =0;
        int curr = 0;

        while(curr<n){

            if(nums[curr]==0){
                curr++;

            }else if(nums[curr]!=0 && curr==prev){

                curr++;
                prev++;

            }else{

                int temp = nums[curr];

                nums[curr] = nums[prev];

                nums[prev] = temp;

                curr++;

                prev++;
            }
        }

    }

}