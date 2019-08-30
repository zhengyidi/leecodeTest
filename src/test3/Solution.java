package test3;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0; // 子串开始index
        int end = 0; // 子串截止index

        int length = 0; // 临时记录长度
        int result = 0; // 最终结果
        for (int len = s.length(); end < len; end++, length++) {
            int pos = s.indexOf(s.charAt(end), start); // 从子串开始位置到字符串截止位置获取重复字符的位置
            if (pos < end) { // 如果在子串范围内出现重复字符
                if (length > result) { // 更新最长的结果
                    result = length;
                }
                if (result >= s.length() - pos - 1) { // 如果最长长度大于剩余字符串长度则直接返回结果
                    return result;
                }
                length = end - pos - 1; // 更新长度，为字串截止位置到重复位置的长度
                start = pos + 1;
            }
        }
        return length;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}