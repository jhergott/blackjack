package yoda;

import java.util.Scanner;

/**
 * Created by jakehergott on 11/13/14.
 */
public class YodaSpeak {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a sentence:");

        //Takes sentence, splits the words into an array
        String sentence = in.nextLine();
        String[] words = sentence.split(" ");


        int wordLength = words.length;

        String yodaSentence = "";

        //goes backwards through array concatenating words
        for(int i = wordLength - 1; i >= 0; i--){
            yodaSentence += words[i] + " ";
        }

        System.out.println(yodaSentence);
    }
}
