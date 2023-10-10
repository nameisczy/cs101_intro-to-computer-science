package edu.nyu.cs;

import java.util.Scanner;

import javax.lang.model.element.Element;

/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {

  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

    // complete this function according to the instructions
    System.out.println("Welcome to Blackjack!");
    int card1 = (int)(2 + Math.random() * (11-2+1));
    int card2 = (int)(2 + Math.random() * (11-2+1));
    System.out.println("Your cards are: " + card1 + " and " + card2);
    int allCardAsInt = card1 + card2;
    String allCard = new String(card1 + ", " +card2);
      while (true) {
        if (allCardAsInt > 21) {
          System.out.println("You have bust!");
          System.out.println("Dealer wins!");
          break;
        }
        else{
          Scanner scnr = new Scanner(System.in);
          System.out.println("Would you like to hit or stand? ");
          String response = scnr.nextLine();
          if (response.equals("stand") || response.equals("stop") || response.equals("pass")){
            int dealerCard1 = (int)(2 + Math.random() * (11-2+1));
            int dealerCard2 = (int)(2 + Math.random() * (11-2+1));
            int dealerAllCard = dealerCard1 + dealerCard2;
            String dealerAllCardAsString = new String(dealerCard1 + ", " + dealerCard2);
            while (true) {
              if (dealerAllCard > 21) {
                System.out.println("The dealer stands.");
                break;
              }
              else if (dealerAllCard == 21) {
                break;
              }
              int choice = (int)(Math.random() * 1);
              if (choice == 1){
                System.out.println("The dealer stands.");
                break;
              }
              else if (choice == 0) {
                System.out.println("The dealer hits.");
                int dealerCard = (int)(2 + Math.random() * (11-2+1));
                dealerAllCard = dealerAllCard + dealerCard;
                dealerAllCardAsString = dealerAllCardAsString + ", " + dealerCard;
                }
              }
            System.out.println("Your cards are: " + allCard);
            System.out.println("The dealer's cards are: " + dealerAllCardAsString);
            if (dealerAllCard > 21) {
              System.out.println("The dealer has bust!");
              System.out.println("You win!");
            }
            else if (dealerAllCard > allCardAsInt) {
              System.out.println("Dealer wins!");
            }
            else if (allCardAsInt > dealerAllCard) {
              System.out.println("You win!");
            }
            else if (dealerAllCard == allCardAsInt) {
              System.out.println("Tie!");
            }
            break;
          }
          else if (response.equals("hit")) {
            int card = (int)(2 + Math.random() * (11-2+1));
            System.out.println("Your cards are: " + allCard + ", and " + card);
            allCardAsInt = allCardAsInt + card;
            allCard = allCard + ", " + card;
          }
        }
      }
    }
  } // main