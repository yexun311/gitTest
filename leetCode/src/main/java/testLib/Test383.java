package testLib;

import org.springframework.stereotype.Component;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 来源：力扣（LeetCode）链接：https://leetcode.cn/problems/ransom-note 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean flag = true;
        char[] str = new char[magazine.length()];
        for (int i = 0; i < magazine.length(); i++){
            str[i] = magazine.charAt(i);
        }
        for (int i = 0; i < ransomNote.length(); i++){
            for (int j = 0; j < str.length; j++){
                if(ransomNote.charAt(i) == str[j]){
                    str[j] = '0';
                    break;
                }
                if(j == str.length - 1)
                    return false;
            }
        }
        return true;
    }
}
