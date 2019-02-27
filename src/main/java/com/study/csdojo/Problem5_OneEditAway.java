package com.study.csdojo;

public class Problem5_OneEditAway {

    public Boolean isOneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        } else if (s1.length() == s2.length()) {
            return isOneAwaySameLength(s1, s2);
        } else if (s1.length() > s2.length()) {
            return isOneAwayDiffLength(s1, s2);
        } else {
            return isOneAwayDiffLength(s2, s1);
        }
    }

    private Boolean isOneAwaySameLength(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private Boolean isOneAwayDiffLength(String s1, String s2) {
        int diffCount = 0;
        int i = 0;
        while (i < s2.length()) {
            if (s1.charAt(i + diffCount) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

}
