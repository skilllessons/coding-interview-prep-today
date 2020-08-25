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
        List<String> result = new ArrayList<>();
        helper(s.toCharArray(), 0, target, new StringBuilder(), result);

        String[] finalResult = new String[result.size()];
        int counter=0;
        for(String st : result){
            finalResult[counter] = st;
            counter++;
        }

        return finalResult;
    }

    static void helper(char[] input, int index, long target, StringBuilder sb, List<String> result) {

        if (index == input.length-1) {
            sb.deleteCharAt(sb.length()-1);
            if (checkTarget(sb.toString(), target) && !result.contains(sb.toString())) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i=index;i<input.length-1;i++){
            sb.append(input[i]+ "*");
            helper(input,index+1, target, sb, result);
            sb.deleteCharAt(sb.length()-1);

            sb.append(input[i]+ "+");
            helper(input,index+1, target, sb, result);
            sb.deleteCharAt(sb.length()-1);

        }


    }

    private static boolean checkTarget(String input, long target) {
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            if (Long.parseLong(String.valueOf(engine.eval(input))) == target) {
                return true;
            }

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String[] result = generate_all_expressions("222", 24);
        System.out.println(result);
    }

}
