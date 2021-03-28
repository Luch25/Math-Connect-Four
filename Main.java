//SO um basically 
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("\n\nWelcome to Math Connect Four! In this game, you and an opponent will be playing Connect Four, but with a twist.\nIn order to be able to put a chip down, you must get a math question right first. Answer these few questions here,\nand then you can begin. Good Luck!");


      System.out.print("\nWhat is the first players name? ");
      String player1 = scan.next();
      System.out.print("\nWhat is the second players name? ");
      String player2 = scan.next();

      System.out.print("\nWhat grade level are you " + player1 + "? (Please put 0 for Kindergarten) ");
      int grade1 = scan.nextInt();
      while(grade1 < 0 || grade1 > 5){
        System.out.print("\nThat was not a valid grade. Please try again: ");
        grade1 = scan.nextInt();
      }

      System.out.print("\nWhat grade level are you " + player2 + "? (Please put 0 for Kindergarten) ");
      int grade2 = scan.nextInt();
      while(grade2 < 0 || grade2 > 5){
        System.out.print("\nThat was not a valid grade. Please try again: ");
        grade2 = scan.nextInt();
      }

      ConnectFour game = new ConnectFour(player1, player2, grade1, grade2);

      game.playGame();
  }
}
