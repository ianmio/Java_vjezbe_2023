package com.vjezba5.vjezba5.handlers;

public class Handler {
    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
