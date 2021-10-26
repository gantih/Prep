package Stacks;

import java.util.Stack;

class ValidParanthesis {
    Stack<Character> st = new Stack<Character>();
    public boolean isValid(String s) {
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    continue;
                }
            } else if(c == ']') {
                if(!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                    continue;
                }

            }
            else if(c == '}') {
                if(!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                    continue;
                }

            }
            st.push(c);
        }
        return st.isEmpty();
    }

    public static void main (String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("(){}["));
    }
}