public class SlidingWindowVariableSize{

    public static void main(String[] args){

        int[] arr = {2,3,1,2,4,3};

        int ans = smallestSizeArray(arr,7);

        System.out.println("smallest size arr: "+ans);
        
    }


    public static int smallestSizeArray(int[] nums,int target){

        int low =0;
        int high =0;

        int res = 0;

        int minimumSize = Integer.MAX_VALUE;

        int n = nums.length;

        while(high<n || res>=target){

            if(res<target){
                res = res + nums[high];
                high++;
            }else{
                
                int size = high-low;

                if(minimumSize>size){
                    minimumSize = size;
                }

                res = res - nums[low];
                low++;
            }

        }

        if(minimumSize==Integer.MAX_VALUE){
            return 0;
        }

        return minimumSize;
    }
}