package com.ye.testLib;

import org.springframework.util.StringUtils;

public class Test001 {
    public void moveZeroes(int[] nums) {
        int count = 0;//零的个数
        for (int i = 0; i < nums.length; i++){
            if (i == nums.length - count)
                break;
            if (nums[i] == 0){
                count++;
                if (nums.length - count - i >= 0) System.arraycopy(nums, i + 1, nums, i, nums.length - count - i);
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
                if (nums1.length - 1 - j >= 0) System.arraycopy(nums1, j, nums1, j + 1, nums1.length - 1 - j);
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

    public String reorderSpaces(String text){
        String str = "";
        int count = 0;
        int strNum = 0;
        for (char s : text.toCharArray()){
            if (s == ' ')
                count++;
        }
        String[] strs = text.split(" ");
        for (String s : strs){
            if (!s.equals("")) {
                str = str.concat(s + " ");
                strNum++;
            }
        }
        str = str.trim();
        if(strNum == 0)
            return text;
        if(strNum == 1){
            for (int i = 0; i < count; i++) {
                str = str.concat(" ");
            }
            return str;
        }
        int addNum = count / (strNum - 1);
        int lastNum = count % (strNum - 1);
        String insertSpace = "";
        String lastSpace = "";
        for (int i = 0; i < addNum; i++)
            insertSpace = insertSpace.concat(" ");
        for (int i = 0; i < lastNum; i++)
            lastSpace = lastSpace.concat(" ");
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                String temp = str.substring(i+1);
                str = str.substring(0,i);
                str = str.concat(insertSpace + temp);
                i = i + addNum;
            }
        }
        str = str.concat(lastSpace);

        return str;
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i = 0;
        while (i < arr.length){
            int temp = i;
            for (int[] piece : pieces) {
                for (int k = 0; k < piece.length; k++) {
                    if (arr[temp] == piece[k]) {
                        if (temp == arr.length - 1 && k == piece.length - 1)
                            return true;
                        else if (temp == arr.length - 1 && k != pieces.length - 1)
                            return false;
                        temp++;
                    } else {
                        temp = i;
                        break;
                    }
                }
                if (temp != i)
                    break;
            }
            if (i != temp){
                i = temp;
            }else {
                return false;
            }
        }
        return true;
    }
}