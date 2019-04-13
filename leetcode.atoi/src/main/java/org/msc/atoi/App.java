package org.msc.atoi;

import java.util.HashMap;
import java.util.Map;

/**
 * atoi implementation
 */
public final class App {
    private static final Map<Character, Integer> numbers = new HashMap<Character,Integer>();

    static {
        char[] setup = {'0','1','2','3','4','5','6','7','8','9'};
        for (int i=0; i<setup.length; i++){
            numbers.put(setup[i], i);
        }
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int sign = 1;
        boolean isNumberSeen = false;
        int accum = 0;

        try{
            for (int i=0; i<chars.length; i++) {
                char current = chars[i];
                if (isNumberSeen){
                    if (!numbers.containsKey(current)) {
                        break;
                    } else {
                        int next = numbers.get(current) * sign;
                        accum = Math.multiplyExact(accum, 10);
                        accum = Math.addExact(accum, next);
                    }
                } else {
                    if (current == ' ') {
                        isNumberSeen = false;
                        continue;
                    } else if (current == '-') {
                        isNumberSeen = true;
                        sign = -1;
                    } else if (current == '+') {
                        isNumberSeen = true;
                        sign = 1;
                    } else if (numbers.containsKey(current)){
                        isNumberSeen = true;
                        accum = numbers.get(current) * sign;
                    } else {
                        break;
                    }
                }
            }
        } catch (ArithmeticException e) {
            if (sign == 1){
                accum = Integer.MAX_VALUE;
            } else {
                accum = Integer.MIN_VALUE;
            }
        }

        return accum;        
    }
}
