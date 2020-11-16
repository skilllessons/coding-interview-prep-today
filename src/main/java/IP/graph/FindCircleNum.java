package main.java.IP.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/friend-circles/
 * 547. Friend Circles
 * Medium
 *
 * 2351
 *
 * 161
 *
 * Add to List
 *
 * Share
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *
 *
 *
 * Constraints:
 *
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 * Accepted
 * 204,044
 * Submissions
 * 343,276
 * Seen this question in a real interview before?
 *
 * Yes
 */

public class FindCircleNum {

    public int findCircleNum(int[][] m) {
        int count = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int i = 0; i<m.length ;i++) {

            if(!visited.contains(i)) {
                dfs(i, m, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int source, int[][] m, Set<Integer> visited){
        visited.add(source);

        for(int j=0;j<m.length;j++){
            if(m[source][j] == 1 && !visited.contains(j)){
                visited.add(j);
                dfs(j,m,visited);
            }
        }

    }
}
