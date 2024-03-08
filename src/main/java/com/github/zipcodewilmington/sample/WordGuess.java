package com.github.zipcodewilmington.sample;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class WordGuess {
    Scanner scanner = new Scanner(System.in);
    public boolean isPlaying() {
        System.out.println("Welcome to Trey's Hangman: Forest Edition! Would you like to Play? Yes/No");
        String input = scanner.nextLine();

        if (input.equals("Yes")) {
            return true;
        } else if (input.equals("No")){
            return false;
        }
        else {
            System.out.println("Please select Yes or No.");
            return true;
        }
    }
    public void runGame() {
        String[] wordBank = {"deer", "moose", "bear", "hare", "wolf", "mouse", "squirrel", "owl", "eagle", "spider"};//initializes an array of strings

        while (isPlaying()) { //given "Yes" this will always be true
            Random rand = new Random(); //initializes random variable
            int randomNum = rand.nextInt(wordBank.length - 1); // random number picks a string in my wordBank by index

            String secretWord = wordBank[randomNum]; //secretWord is now equal to the word at the position of the random chosen number

            int length = secretWord.length(); // initializing counter for the length of the secret word
            StringBuilder wordHider = new StringBuilder(); // making a string builder to make new strings
            for (int i = 0; i < length; i++) { // loops through the amount of letters in random word
                wordHider.append('_'); // adds a underscore for each iteration of chars in the word
            }
            int guessAmt = length; // sets guesses to the length of the secret word
            int guessesLeft = guessAmt;
            int tries = 0; // tries will increase and once they're more than guessAmt, the game ends
            String wordHiderString = String.valueOf(wordHider);

            System.out.println("Guess the letters in this word: " + wordHider); // prints wordHider to show underscores of word


            while (tries <= guessAmt) {
                System.out.println("You have " + guessesLeft + " guesses left."); // prints amount of guesses


                wordHiderString = letterTester(secretWord, wordHiderString); // calls letterTester method and sets secretWord to updated string each iteration
                System.out.println(wordHiderString);
                tries++;
                guessesLeft--;

                if (wordHiderString == secretWord) { // if wordHiderString is == the secret word, they've won the game and the loop breaks
                    System.out.println("You win!");
                    break;
                }
                if (guessAmt < tries) {
                    System.out.println("You lose."); // if the amount of tries equals the amount of guesses they have, they lose
                    break;
                }
            }
        }
    }

    public String letterTester(String secretWord, String wordHider) { //bringing secretWord and wordHider to be used in this method
        Scanner scanner = new Scanner(System.in); // making a scanner for input of the guesses
        char blank = scanner.next().charAt(0);  // blank is equal to the char that the user guesses

        char[] guessedLetters = new char[0]; // makes a new array at the length of the secret word
        guessedLetters = Arrays.copyOf(guessedLetters, guessedLetters.length + 1); // creates a copy of the new letters, increasing length by one
        guessedLetters[guessedLetters.length - 1] = blank; // adding the character from the scanner input to the guessed array
        System.out.println(guessedLetters); // prints guessed letters in the new array


        char[] correctLetters = secretWord.toCharArray();

        for (int i = 0; i < secretWord.length(); i++) { // while i is the length of the word, it will go to the next char
            if (blank == correctLetters[i]) {// if the guessed char is equal to the character at the index,
                wordHider = wordHider.substring(0, i) + blank + wordHider.substring(i + 1); // replaces the underscore with the correct letter
            }
        }

        return wordHider;
    }
}
/* starts the game
a random word is chosen from a list
the number of tries allowed is set to the length of the word
setup the two (the solution and the player's guesses) character arrays
WHILE the numbers of tries is less than tries allowed AND
the player has not guessed the word
print the current state of the player's guesses
ask the player for a letter (a character)
if the letter is a minus "-", quit the game
else process the letter
if the letter makes the work complete,
the player wins
after the while loop
if the word is not guessed, player loses

 */