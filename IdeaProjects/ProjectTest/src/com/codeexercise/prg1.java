package com.codeexercise;

import java.util.*;

public class prg1 {
    public void getTargetNumber(ArrayList<Integer> list, Integer n){
        //Integer output=0;
        boolean boo = false;
        for (int i=0; i<list.size()-1;i++){
            for (int y=i+1; y< list.size(); y++){
                System.out.println (i + " " + y + " " + (list.get(i) + list.get(y)));

                Integer   sum  =list.get(i) + list.get(y);

                if ( sum == n){

                    System.out.println("index: " + i + " and Index " +y);
                    boo = true;
                }
                if (boo ==true)
                    break;
            }
            if (boo ==true)
                break;
        }
       // System.out.println(listStr.toString());
    }

    public boolean checkString(String s) {
        boolean output = true;
        // the array behaves as a stack
        char [] stack = new char [s.length()];
        int qind=-1;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                qind++;
                //When any kind of opening parenthesis, Just add it to the stack
                 stack[qind] =  s.charAt(i);
            } else {
                // If there is nothing left in the stack to pop but there are chars left in the String....
                if (qind < 0){
                    System.out.println("There is an extra closing parenthesis: "+ s.charAt(i));
                    output =false;
                }else {
                    // Closing parenthesis section
                    // If the current char does not closed the last parenthesis in the stack --> false
                    if ((s.charAt(i) == '}' && stack[qind]!= '{' )
                            || (s.charAt(i) == ']' && stack[qind]!= '[' )
                            || (s.charAt(i) == ')' && stack[qind]!= '(' ))
                    {
                        System.out.println("Current item " + s.charAt(i) + " does not match last open parenthesis : " + stack[qind]);
                        output =false;
                    } else {
                        qind--;
                    }
                }
            }

            if (output == false){
                break;
            }
        }
        if (qind >=0 && output==true){
            System.out.println( qind +1 + " Parenthesis remained unclosed");
            output =false;
        }

        return output;
    }

    public void printNumbers(){

        for (int i=1;i<=100;i++){

            String s = "";
            if (i % 3 == 0 ){
                s ="Fizz";
            }
            if (i % 5 == 0 ){
                s = s + "Buzz";
            }
            if (s.equals(""))
                s= String.valueOf(i);

            System.out.println(s);

            //System.out.println("");
        }

    }
    public void addNumbers(int a, int b){
        char [] arraya = new char[a];
        char [] arrayb = new char[b];

        ArrayList<String> arrayList= new ArrayList<String>();

        for (int i = 1 ; i<=a;i++){
            arrayList.add("Number");
        }
        for (int i = 1 ; i<=b;i++){
            arrayList.add("Number");
        }
        System.out.println(arrayList.size());
    }

    public static void main(String[] args){

        System.out.println("Welcome");
        String s = "({[()])";

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        prg1 runCode = new prg1();
        //runCode.addNumbers(5,3);
        //runCode.getTargetNumber(list, 5);

        System.out.println("TEST #1: Valid Test: ({[()]})");
        System.out.println("Result from Method: " + runCode.checkString("({[()]})"));
        System.out.println("");
        System.out.println("TEST #2: Closing one parenthesis at the wrong position  : ({[(])]})");
        System.out.println("Result from Method: " + runCode.checkString("({[(])]})"));
        System.out.println("");
        System.out.println("TEST #3: Closing more than the ones opened  : ({[(])]}))");
        System.out.println("Result from Method: " + runCode.checkString("({[()]}))"));
        System.out.println("");
        System.out.println("TEST #4: Some parenthesis stayed unclosed : (({[()]})");
        System.out.println("Result from Method: " + runCode.checkString("(({[()]})"));

    }


}
