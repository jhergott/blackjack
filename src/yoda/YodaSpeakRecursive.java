package yoda;

import java.util.Scanner;

/**
 * Created by jakehergott on 11/13/14.
 */
public class YodaSpeakRecursive {

    private static String yodaSentence = "";

    //recursive function
    private static String yodaSentence(String[] words, int index){
        if(index == words.length){
            return yodaSentence;
        }
        return yodaSentence(words,index + 1) + words[index] + " " + yodaSentence;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a sentence:");

        //Takes sentence, splits the words into an array
        String sentence = in.nextLine();
        String[] words = sentence.split(" ");


        String ySentence = yodaSentence(words,0);


        System.out.println(ySentence);
    }
}
