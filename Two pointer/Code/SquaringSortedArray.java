
public class SquaringSortedArray{


    public static void main(String[] args){


        int nums[] = {-4,-1,0,3,10};

        nums = squaringSortedArray(nums);

        System.out.print("[ ");

        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }

        System.out.println("]");

    }


    public static int[] squaringSortedArray(int[] nums){

        if(nums[0]>=0){
            
            //whole array is positive
           return squaringArray(nums);

        }else if(nums[nums.length-1]<0){
           
           //whole array is negative
            nums = reverseArray(nums);
            return squaringArray(nums);

        }else{

        //find size of negative elements
          int k =0;

            while(nums[k]<0){
                k++;
            }

            //neg sub array size
            int negArrSize = k;

            //positive sub array length
            int posArrSize =nums.length;


            //starting pos for both sub array 
            int neg = 0;
            int pos =negArrSize;

            //square whole array
            nums = squaringArray(nums);

            //reverse negative part
            nums = reverseSubArray(nums,negArrSize);


            int[] resultArr = new int[nums.length];

            int m=0;


            //merge neg and pos part 
            while(neg<negArrSize && pos<posArrSize){

                if(nums[neg]<nums[pos]){
                    resultArr[m] = nums[neg];
                    m++;
                    neg++;
                }else{
                    resultArr[m] = nums[pos];
                    m++;
                    pos++;
                }
            }


            //if neg elements remains
            while(neg<negArrSize){
                resultArr[m] = nums[neg];
                    m++;
                    neg++;
            }

            //if pos elements remains
            while(pos<posArrSize){
                resultArr[m] = nums[pos];
                    m++;
                    pos++;
            }

            return resultArr;

        }
        
    }

    public static int[] squaringArray(int[] nums){

        for(int i=0; i<nums.length; i++){

            nums[i] = nums[i]*nums[i];
        }

        return nums;
    }

    public static int[] reverseArray(int[] nums){

        int start =0;
        int end = nums.length-1;

        int mid = nums.length/2;

        for(int i=0; i<mid; i++){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }

          System.out.print("[ ");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+",");
        }
        System.out.print(" ]");

        return nums;
    }


    public static int[] reverseSubArray(int[] nums,int subArrayLength){

        int mid = (subArrayLength)/2;

        int start =0;
        int end = subArrayLength-1;

        for(int i=0; i<mid; i++){

                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
        }

        return nums;
    }
}