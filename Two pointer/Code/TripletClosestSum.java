import java.util.*;

public class TripletClosestSum{


    public static void main(String[] args){


        int[]  arr = {2,3,8,9,10};

        //{ 0, 1, 1, 2, 3, 5, 6}

        //first loop -> (0,1,2) 3 
        //second loop ->(1,1,2) 4
        //third loop -> (1,2,3) 6
        //fouth loop -> (2,3,5) 10
        //fifth loop -> (3,5,6) 14

        System.out.println(closestSum(arr,16));
    }


    public static int closestSum(int[] nums,int target){

        Arrays.sort(nums);

        int n = nums.length;

        int closestSum = Integer.MAX_VALUE;

        for(int i=0; i<n-2; i++){

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = n-1;

            while(left<right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target){

                    return sum;
                }
                else if(sum<target){

                    int sumDiff = Math.abs(sum-target);
                    int maxValueDiff = Math.abs(closestSum-target);
                    
                    if(maxValueDiff>sumDiff){
                        closestSum = sum;
                    }

                    left++;
                }else{
                 
                    int sumDiff = Math.abs(sum-target);
                    int maxValueDiff = Math.abs(closestSum-target);
                    
                    if(maxValueDiff>sumDiff){
                        closestSum = sum;
                    }

                    right--;
                }
            }

            // if(right<n-1){
            //     int sum = nums[i] + nums[left]+nums[right+1];
            //     int sumDiff = Math.abs(sum-target);
            //     int maxValueDiff = Math.abs(closestSum-target);
                    
            //         if(maxValueDiff>sumDiff){
            //             closestSum = sum;
            //         }

            // }else{
            //     int sum = nums[i] + nums[left-1]+nums[right];
            //     int sumDiff = Math.abs(sum-target);
            //     int maxValueDiff = Math.abs(closestSum-target);
                    
            //         if(maxValueDiff>sumDiff){
            //             closestSum = sum;
            //         }
            // }
        
        }

      return closestSum;  
    }
}