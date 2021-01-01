package stack;
import java.io.IOException;
import java.util.Stack;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if (null == s)
            return s;
        Stack<Character> stack = new Stack<>();
        for (int indx = 0; indx < s.length(); indx++) {
            if (s.charAt(indx) == '(' || s.charAt(indx) == '{' || s.charAt(indx) == '[')
                stack.push(s.charAt(indx));
            else if (s.charAt(indx) == ')' || s.charAt(indx) == '}' || s.charAt(indx) == ']') {
                if (stack.isEmpty())
                	return "NO";
                char elem = stack.pop();
                switch (elem) {
                case '(':
                	if (')' != s.charAt(indx))
                		return "NO";
                	break;
                case '{':
                	if ('}' != s.charAt(indx))
                		return "NO";
                	break;
                case '[':
                	if (']' != s.charAt(indx))
                		return "NO";
                	break;                	
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isBalanced("[](){()}"));
    }
}
