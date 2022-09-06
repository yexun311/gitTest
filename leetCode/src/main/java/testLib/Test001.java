package testLib;

public class Test001 {
    public void moveZeroes(int[] nums) {
        int count = 0;//零的个数
        for (int i = 0; i < nums.length; i++){
            if (i == nums.length - count)
                break;
            if (nums[i] == 0){
                count++;
                for (int j = i; j < nums.length - count; j++){
                    nums[j] = nums[j+1];
                }
                nums[nums.length - count] = 0;
                i--;
            }
        }
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;
        int repeat = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] && repeat < 2){
                nums[j] = nums[i];
                repeat++;
                j++;
                count++;
            }else if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
                count++;
                repeat = 1;
            }
        }
        return count;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int i = 0;
        int count = 0;
        if (nums1.length != m+n)
            System.out.println("Error!");
        for (; i < n; i++){
            if (nums2[i] <= nums1[j]){
                for (int k = nums1.length - 1; k > j; k--)
                    nums1[k] = nums1[k-1];
                nums1[j] = nums2[i];
                count++;
            }else if (j == m + count-1){
                break;
            }else{
                i--;
                j++;
            }
        }
        j++;
        for (;j < m + n; j++){
            nums1[j] = nums2[i];
            i++;
        }
    }
}