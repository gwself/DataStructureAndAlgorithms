package com.yunus.datastucture.stack;

/**
 * Created by yunus on 2017/9/14.
 */
public class ReversalStr {

    private String input;
    public ReversalStr(String input){
        this.input = input;
    }

    public String doReserve(){
        CharStack stack = new CharStack(input.length());
        for(int i = 0 ;i<input.length();i++){
            char ch = input.charAt(i);
            stack.push(ch);
        }
        String out = "";
        while(!stack.isEmpty()){
            out += stack.pop();
        }
        return out;
    }

}
