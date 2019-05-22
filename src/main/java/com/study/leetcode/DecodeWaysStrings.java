package com.study.leetcode;

/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:

Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".

Example 2:

Input: "1*"
Output: 9 + 9 = 18

Note:

    The length of the input string will fit in range [1, 105].
    The input string will only contain the character '*' and digits '0' - '9'.
 */
class DecodeWaysStrings {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();

        long ways0 = 1;
        long ways1 = s.charAt(0) == '*' ? 9 : 1;

        char prev = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);

            long ways2 = ways1;
            if (ch == '*') {
                if (prev == '1') {
                    ways2 = ways1 * 9 + ways0 * 9;
                } else if (prev == '2') {
                    ways2 = ways1 * 9 + ways0 * 6;
                } else if (prev == '*') {
                    ways2 = ways1 * 9 + ways0 * 15;
                } else {
                    ways2 = ways1 * 9;
                }
            } else if (ch == '0') {
                if (prev == '1' || prev == '2') {
                    ways2 = ways0;
                } else if (prev == '*') {
                    ways2 = 2 * ways0;
                } else {
                    return 0;
                }
                // next: ch = 1 .. 9
            } else if (prev == '1'
                    || (prev == '2' && ch >= '1' && ch <= '6')) {
                ways2 = ways1 + ways0;
            } else if (prev == '2' && ch >= '7' && ch <= '9') {
                ways2 = ways1;
            } else if (prev == '*' && ch >= '1' && ch <= '6') {
                ways2 = ways1 + 2 * ways0;
            } else if (prev == '*' && ch >= '7' && ch <= '9') {
                ways2 = ways1 + ways0;
            } else {
                ways2 = ways1;
            }

            ways0 = ways1;
            ways1 = ways2 % 1000000007;
            prev = ch;
        }

        return (int) ways1;
    }

}