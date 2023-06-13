/**
345. Reverse Vowels of a String
Easy

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

package leetcode;

public class LC_0345_ReverseVowelsOfAString {

//    public String reverseVowels(String s) {
//        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
//        char[] chars = s.toCharArray();
//        List<Integer> indexes = new ArrayList<>();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (vowels.contains(s.charAt(i))) {
//                indexes.add(i);
//                stack.push(s.charAt(i));
//            }
//        }
//        for (Integer index : indexes) {
//            chars[index] = stack.pop();
//        }
//        return String.valueOf(chars);
//    }

    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start<end){
            while(start < end && !vowels.contains(chars[start] + "")){
                start++;
            }
            while(start<end && !vowels.contains(chars[end] + "")){
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}
