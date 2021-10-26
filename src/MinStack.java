import java.io.*;
import java.util.*;
class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
    }

    public void push(int val) {
        stack.add(val);
        if(minStack.isEmpty()) {
            minStack.add(val);
        } else {
            if(val <= minStack.get(minStack.size()-1)) {
                minStack.add(val);
            }
        }
    }

    public void pop() {
        if(stack.get(stack.size()-1).equals(minStack.get(minStack.size()-1))){
            minStack.remove(minStack.size()-1);
        }
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */