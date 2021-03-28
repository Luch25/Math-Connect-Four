import java.util.Scanner;

class ConnectFour{
  //states
  String player1, player2;
  int gradeLevel1, gradeLevel2;
  int roundNum;
  String gameBoard [][] = new String [6][7];
  Scanner scan;
  Kindergarten student10, student20;
  First student11, student21;
  Second student12, student22;
  Third student13, student23;
  Fourth student14, student24;
  Fifth student15, student25;
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  private static final String ANSI_RED_BACKGROUND = "\u001B[42m";
  private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  private static final String ANSI_RAND_BACKGROUND = "\u001B[47m";

  
  public ConnectFour(String p1, String p2, int grade1, int grade2){
    player1 = p1;
    player2 = p2;
    gradeLevel1 = grade1;
    gradeLevel2 = grade2;
    initializeMathObjects();
    int roundNum = 0;
    scan = new Scanner(System.in);
    for(int i = 0; i < 6; i++)
      for(int j = 0; j < 7; j++)
        gameBoard[i][j] = ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET;
  }

  public void initializeMathObjects()
  {
      if(gradeLevel1 == 0)student10 = new Kindergarten();
      else if(gradeLevel1 == 1)student11 = new First();
      else if(gradeLevel1 == 2)student12 = new Second();
      else if(gradeLevel1 == 3)student13 = new Third();
      else if(gradeLevel1 == 4)student14 = new Fourth();
      else student15 = new Fifth();
      
      if(gradeLevel2 == 0)student20 = new Kindergarten();
      else if(gradeLevel2 == 1)student21 = new First();
      else if(gradeLevel2 == 2)student22 = new Second();
      else if(gradeLevel2 == 3)student23 = new Third();
      else if(gradeLevel2 == 4)student24 = new Fourth();
      else student25 = new Fifth();
  }

  public void printBoard(){
    System.out.println();
    for(int i = 1; i < 13; i++){
      System.out.print(ANSI_BLUE_BACKGROUND + "  " + ANSI_RESET);
      for(int j = 0; j < 7; j++){
        if(i % 2 == 0)
          System.out.print(gameBoard[i/2 - 1][j] + (ANSI_BLUE_BACKGROUND + "  " + ANSI_RESET));
        else
          System.out.print(ANSI_BLUE_BACKGROUND + "    " +  ANSI_RESET);
      }
      System.out.println();  
    }

    int j = 1;
    for(int i = 0; i < 7; i++){
        System.out.print(ANSI_BLUE_BACKGROUND + "  " + j + " " +  ANSI_RESET);
        j++;
    }

    System.out.println(ANSI_BLUE_BACKGROUND + "  " +  ANSI_RESET);

  }

  public boolean isValid (int n){
    if(n ==  1){
      return gameBoard[0][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else if(n ==  2){
      return gameBoard[0][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else if(n ==  3){
      return gameBoard[0][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else if(n ==  4){
      return gameBoard[0][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else if(n ==  5){
      return gameBoard[0][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else if(n ==  6){
      return gameBoard[01][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else if(n ==  0){
      return gameBoard[0][n].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET);
    }
    else return false;
  }

  public boolean doMath(){
    if(roundNum % 2 == 1)
    {
      System.out.println("\nIt is your turn " + player1 + ", so answer this question. Good Luck!");
      if(gradeLevel1 == 0) return student10.kindMeth();
      else if(gradeLevel1 == 1) return student11.firstMeth();
      else if(gradeLevel1 == 2) return student12.secondMeth();
      else if(gradeLevel1 == 3) return student13.thirdMeth();
      else if(gradeLevel1 == 4) return student14.fourthMeth();
      else return student15.fifthMeth();
    }

    else
    {
      System.out.println("\nIt is your turn " + player2 + ", so answer this question. Good Luck!");
      if(gradeLevel2 == 0) return student20.kindMeth();
      else if(gradeLevel2 == 1) return student21.firstMeth();
      else if(gradeLevel2 == 2) return student22.secondMeth();
      else if(gradeLevel2 == 3) return student23.thirdMeth();
      else if(gradeLevel2 == 4) return student24.fourthMeth();
      else return student25.fifthMeth();
    }
  }

  public void playGame(){
    String mark;
    printBoard();

    while(winner() == 0){
      roundNum++;
      if(roundNum % 2 != 0) mark = ANSI_RED_BACKGROUND + "  " + ANSI_RESET;
      else  mark = ANSI_YELLOW_BACKGROUND + "  " +  ANSI_RESET;
        
      if(doMath()){
        if(roundNum % 2 != 0)System.out.println("\nNice Job " + player1 + "!!");
        else System.out.println("\nNice Job " + player2 + "!!");
        int column = 0;
        System.out.print("\nChoose which column (1-7) you would like your piece to go: ");
        column = scan.nextInt();
        while(!isValid(column - 1)){
          System.out.print("\nThat row either does not exist or is full. Please try again: ");
          column = scan.nextInt();
        }
        fillRow(column - 1,mark);
        printBoard();
      }else{
        System.out.println("Good try, but that was not the right answer. Better luck next time!");
      }
    }

    int win = winner();

    if(win == 1){
      printBoard();
      System.out.println("Congratulations " + player1 + ", you won!");
    }
    if(win == 2){
      printBoard();
      System.out.println("Congratulations " + player2 + ", you won!");
    }
    if(win == 3){
      printBoard();
      System.out.println("Tie! Good Luck next time!");
    }
  }

  public int fillRow(int col, String mark){
    for(int i = 1; i < gameBoard.length; i++){ 
      if(!gameBoard[i][col].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET)){
        gameBoard[i-1][col] = mark;
        return -1;
      }
      if(i == gameBoard.length - 1){
        gameBoard[i][col] = mark;
        return -1;
      }
    }
    return -1;
  }

  //returns int to determine wiiner (0 = no winner, 1 = player1, 2 = player 2, 3 = tie)
  private int winner(){
    if(roundNum < 7)
      return 0;
    
    //checks for horizontal 
    for(int row = 0; row<gameBoard.length; row++){
			for (int col = 0;col < gameBoard[0].length - 3;col++){
				if (gameBoard[row][col].equals(gameBoard[row][col+1]) && 
					gameBoard[row][col+1].equals(gameBoard[row][col+2]) &&
					gameBoard[row][col+2].equals(gameBoard[row][col+3]) &&
          !gameBoard[row][col].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET)){
            gameBoard[row][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            gameBoard[row][col+1] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            gameBoard[row][col+2] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            gameBoard[row][col+3] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            if(gameBoard[row][col].equals(ANSI_RED_BACKGROUND + "  " + ANSI_RESET)){
              return 1;
            }else  return 2;
			  }
			}	
    }	

    //checks for Vertical
    for(int row = gameBoard.length - 1; row > 3; row--){
			for (int col = 0;col < gameBoard[0].length;col++){
				if (gameBoard[row][col].equals(gameBoard[row-1][col]) && 
					gameBoard[row-1][col].equals(gameBoard[row-2][col]) &&
					gameBoard[row-2][col].equals(gameBoard[row-3][col]) && !gameBoard[row][col].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET)){
            gameBoard[row][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            gameBoard[row-1][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            gameBoard[row-2][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            gameBoard[row-3][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
            if(gameBoard[row][col].equals(ANSI_RED_BACKGROUND + "  " + ANSI_RESET)) return 1;
            else return 2;
			  }
			}	
    }	
    //checks diagonals

    //checks for Diagonal upwards
    for(int row = 3; row < gameBoard.length; row++){
			for(int col = 0; col < gameBoard[0].length - 3; col++){
				if (gameBoard[row][col].equals (gameBoard[row-1][col+1]) &&
					gameBoard[row-1][col+1].equals(gameBoard[row-2][col+2]) &&
					gameBoard[row-2][col+2].equals(gameBoard[row-3][col+3]) &&
          !gameBoard[row][col].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET)){
					gameBoard[row][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          gameBoard[row-1][col+1] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          gameBoard[row-2][col+2] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          gameBoard[row-3][col+3] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          if(gameBoard[row][col].equals(ANSI_RED_BACKGROUND + "  " 
          + ANSI_RESET)) return 1;
          else return 2;
				}
			}
		}

    //check for Diagonal downwards
    for(int row = 0; row < gameBoard.length-3; row++){
      for(int col = 0; col < gameBoard[0].length-3; col++){
        if(gameBoard[row][col].equals(gameBoard[row+1][col+1]) &&
          gameBoard[row+1][col+1].equals(gameBoard[row+2][col+2]) &&
          gameBoard[row+2][col+2].equals(gameBoard[row+3][col+3]) &&
          !gameBoard[row][col].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET)) {
          gameBoard[row][col] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          gameBoard[row+1][col+1] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          gameBoard[row+2][col+2] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          gameBoard[row+3][col+3] = ANSI_RAND_BACKGROUND + "  " + ANSI_RESET;
          if(gameBoard[row][col].equals(ANSI_RED_BACKGROUND + "  " 
          + ANSI_RESET)) return 1;
          else return 2;  
        }
      }
    }

    //checks for tie
    int counter = 0;
    for(int i = 0; i < gameBoard.length; i++){
      for(int j = 0; j < gameBoard[i].length; j++){
        if(gameBoard[i][j].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET) &&
          !gameBoard[i][j].equals(ANSI_BLACK_BACKGROUND + "  " + ANSI_RESET)) counter++;
      } 
    }
      
    
    if(counter == gameBoard.length * gameBoard[0].length) return 3;

    //nothing happened
    return 0;

  }
}