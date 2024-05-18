import java.util.Scanner;
//Nakul G
public class TicTacToe{
public static void main(String[]args){
	Scanner s = new Scanner(System.in);
	System.out.print("Would you like to play (1) player or (2) player: ");
	int ans = s.nextInt();
	int ans2 = 0;
	if(ans == 1){
		System.out.print("Would you like to play the (1)normal mode, or the (2) Nightmare mode: ");
		ans2 = s.nextInt();
	}
	TicTacToeBoard board = new TicTacToeBoard(620,800);
	int[][] grid = new int[4][4];
	grid[0][0]=0;			//make grid variables
	grid[0][1]=200;
	grid[0][2]=600;
	grid[0][3]=200;
	grid[1][0]=0;
	grid[1][1]=400;
	grid[1][2]=600;
	grid[1][3]=400;
	grid[2][0]=200;
	grid[2][1]=600;
	grid[2][2]=200;
	grid[2][3]=0;
	grid[3][0]=400;
	grid[3][1]=600;
	grid[3][2]=400;
	grid[3][3]=0;
	board.defineBoard(grid);
	board.repaint();
	board.setFiles("x.png", "o.png");
	char[][] arr = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	System.out.print(arr[0][0]);
	boolean winnerP1 = false;
	boolean winnerP2 = false;
	String winner = "";
	int tempx = 0;//more variables for placing "x"'s and "o"'s
	int tempy = 0;
	int botx = 0;
	int boty = 0;
	int count = 0;
	boolean p1moved = false;
	boolean p2moved = false;
	board.setBoard(arr);
	board.repaint();
	boolean botMove = true;


	if(ans==1){
	//1 player
	while(!winnerP1 || !winnerP2){

		botMove = true;
		System.out.print("Choose a column: ");//get player input
		tempx = s.nextInt();
		System.out.print("Choose a row: ");
		tempy = s.nextInt();
		if(tempx > 3 || tempy >3 ||tempx<1 || tempy<1)//check if it is not a legal move
			continue;
		if((arr[tempy-1][tempx-1] == ' ')){//check if not overlapping

			arr[tempy-1][tempx-1] = 'x';//sets coordinate to "x"
			winnerP1 = checkForWin(arr, 1);//did u win?
			if(winnerP1)
				break;

		if(ans2==2){//super mode ACTIVATE
			board.setBoard(arr); board.repaint();
			board.delay(1500);
			arr[tempy-1][tempx-1] = 'o';
			board.setBoard(arr);//print board
			board.repaint();
			arr[0][0]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[0][1]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[0][2]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[1][0]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[1][1]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[1][2]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[2][0]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[2][1]='o';
			board.setBoard(arr); board.repaint(); board.delay(1500);
			arr[2][2]='o';
			winnerP2=true;
			break;
		}
			while(botMove){//makes bot move if you have moved
				botx = (int)(Math.random()*3)+1;
				boty = (int)(Math.random()*3)+1;
				if((arr[boty-1][botx-1] == ' ')){
					arr[boty-1][botx-1] = 'o';
					botMove = false;
				}

			}//end of while loop

			winnerP2 = checkForWin(arr, 2);//did bot win?
			if(winnerP2)
				break;

			count++;

		}else
			System.out.println("That was already taken");//if overlapping


		board.setBoard(arr);//print board
		board.repaint();
		if(count==9)//if all moves played and no one has won
			break;


	}// while no one has won


	//end of player1 game
	}else if(ans == 2){


	while(!winnerP1 && !winnerP2){//while no one has won
		while(!p1moved){
		System.out.print("Choose a column for p1: ");//get player1 input
		tempx = s.nextInt();
		System.out.print("Choose a row for p1: ");
		tempy = s.nextInt();

		if(tempx > 3 || tempy >3 ||tempx<1 || tempy<1)//check if it is not a legal move
			continue;
		if((arr[tempy-1][tempx-1] == ' ')){//check if not overlapping
			p1moved = true;
			arr[tempy-1][tempx-1] = 'x';//sets coordinate to "x"
			winnerP1 = checkForWin(arr, 1);//did u win?
				if(winnerP1)
				break;

			}else{
			System.out.println("Not legal");
			p1moved = false;
		}
		board.setBoard(arr);
		board.repaint();
		}//when p1 has moved
		p1moved = false;
		count++;

		if(count==9)
			break;


		while(!p2moved && !winnerP1){
		System.out.print("Choose a column for p2: ");//get player input
		tempx = s.nextInt();
		System.out.print("Choose a row for p2: ");
		tempy = s.nextInt();
		if(tempx > 3 || tempy >3 ||tempx<1 || tempy<1)//check if it is not a legal move
			continue;
		if((arr[tempy-1][tempx-1] == ' ')){//check if not overlapping
			p2moved = true;
			arr[tempy-1][tempx-1] = 'o';//sets coordinate to "x"
			winnerP2 = checkForWin(arr, 2);//did u win?
			if(winnerP2)
				break;
		}else{
			System.out.println("Not legal");
			p2moved = false;
		}

		board.setBoard(arr);
		board.repaint();
	}//when p2 has moved
		p2moved = false;
		count++;


	}//end of while
	}//end of two player



	//after someone has won or tie
	board.setBoard(arr);
	board.repaint();

	if(winnerP1)
		winner = "X Won!";
	if(winnerP2)
		if(ans2==2)
			winner = "Ø ₩Ø₦!!";
		else
			winner = "O won!!";
	if(count==9)
		winner = "It was a tie!";

	board.setWinner(winner, 100, 700, 55);
	board.showText(true);
}//end of public static void main
public static boolean checkForWin(char[][] arr, int player){
	char p = ' ';
	if(player==1)
		p = 'x';
	else
		p = 'o';
	for(int i = 0; i<3; i++){
		if((arr[i][0]== p) && (arr[i][1]== p) && (arr[i][2]== p))//checks any row
			return true;
		if((arr[0][i]== p) && (arr[1][i]== p) && (arr[2][i]== p))//checks any column
			return true;
}
		if(arr[0][0]==p && arr[1][1]==p && arr[2][2]==p)//checks diagonals
			return true;
		if(arr[0][2]==p && arr[1][1]==p && arr[2][0]==p)
			return true;
	return false;
}
}