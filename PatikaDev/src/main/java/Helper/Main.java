package Helper;

import java.util.*;
import java.io.*;

class Main {

    public static String StringChallenge(String str) {
        // code goes here
        StringBuilder builder= new StringBuilder();
        char currentChar = str.charAt(0);
        int c=1;
        for(int i = 1; i< str.length(); i++){
            char nextChar = str.charAt(i);

            if(nextChar==currentChar){
                c++;
            }
            else{
                builder.append(c).append(currentChar);
                currentChar = nextChar;
                c = 1;
            }
        }
        builder.append(c).append(currentChar);
        return builder.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

}