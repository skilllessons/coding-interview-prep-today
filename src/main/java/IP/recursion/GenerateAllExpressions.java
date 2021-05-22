package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * s="222", target=24.
 */

public class GenerateAllExpressions {
    static String[] generate_all_expressions(String s, long target) {
        if(s.length() == 0 || s==null)
        {
            return new String[]{};
        }
        List<String> result = new ArrayList<>();
        char[] path = new char[s.length() * 2];
        char[] digits = s.toCharArray();
        long n = 0;
        for(int i=0;i<s.length();i++)
        {
            n = n*10 + (digits[i] - '0');
            path[i] = digits[i];
            generate_all_expressions_helper(result, path, digits, i+1, i+1, 0, n, target);
        }

        return result.toArray(new String[0]);
    }
    static void generate_all_expressions_helper(List<String> result, char[] path, char[] digits, int index, int pos, long prev, long curr, long target)
    {
        //Base case:
        if(pos == digits.length)
        {
            if(prev+curr == target)
            {
                result.add(new String(path, 0, index));
            }
        }
        //Recursive case:
        long n = 0;
        int j = index + 1;
        for(int i=pos; i<digits.length;i++)
        {
            n = n*10 + (digits[i] - '0');
            path[j++] = digits[i];

            path[index] = '+';
            generate_all_expressions_helper(result, path, digits, j, i+1, prev+curr, n, target);
            path[index] = '*';
            generate_all_expressions_helper(result, path, digits, j, i+1, prev, curr*n, target);
        }
    }

    public static void main(String[] args) {
        String[] result = generate_all_expressions("222", 24);
        System.out.println(result);
    }

}
