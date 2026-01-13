public class DutchFlagProblem{


    public static void main(String[] args){

        int[] nums = {2,0,1};

        solution(nums);

        
        printArrayNeatly(nums);
    }

    public static void  solution(int[] nums){
        
         int n = nums.length;


        int low = 0;
        int high = n-1;
        int mid =0;

        while(mid<=high){
                
            if(nums[mid]==0){
                
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

                printArrayNeatly(nums);
            }else if(nums[mid]==1){
                mid++;
            }else{

                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                high--;

                printArrayNeatly(nums);
            }
        }
    }

    public static void printArrayNeatly(int[] nums){
        for(int i :nums){
            System.out.print(i+" ");
        }

        System.out.println();
    }
}