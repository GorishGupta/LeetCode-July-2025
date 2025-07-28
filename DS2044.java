public class DS2044 {

    public void backTrack (int[] nums, int index, int currentOr,int maxOr, int[] count){
        if(currentOr == maxOr){
            count[0]++;
        }
        for(int i = index;i<nums.length;i++){
            backTrack(nums, i+1, currentOr | nums[i], maxOr,count);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num : nums){
            maxOr |= num;
        }
        int count [] = new int[1];
        backTrack(nums, 0,0,maxOr, count);
        return count[0];
    }
    public static void main(String[] args) {
        DS2044 ds2044 = new DS2044();
        int[] nums = { 3, 1 };
        int result = ds2044.countMaxOrSubsets(nums);
        System.out.println("Number of subsets with maximum OR: " + result);
        
    }
}