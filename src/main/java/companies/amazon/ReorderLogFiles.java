package main.java.companies.amazon;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * 937. Reorder Data in Log Files
 *
 * 937. Reorder Data in Log Files
 * Easy
 *
 * 731
 *
 * 2198
 *
 * Add to List
 *
 * Share
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 *
 */

public class ReorderLogFiles {
    public static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].codePointAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].codePointAt(0));

            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;

                return split1[0].compareTo(split2[0]);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

        });
        return logs;
    }

    public static void main(String[] args) {
      String[]  logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println("Before sorting");
        System.out.println(printLog(logs));
        System.out.println("After sorting");
        System.out.println(printLog(reorderLogFiles(logs)));
    }

    private static String printLog(String[] reorderLogFiles) {
        StringBuilder sb = new StringBuilder();
        for (String str: reorderLogFiles){
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }
}
