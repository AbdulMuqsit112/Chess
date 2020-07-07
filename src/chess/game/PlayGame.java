package chess.game;
import java.util.*;
/**
 *
 * @author ABDUL MUQSIT
 */
public class PlayGame
{
	
	public static boolean is_check()
        {		//is_check method for check condition in chess
	
		Board board1=new Board();
		boolean ret_flag=false;
		int x=0,y=0;
		
		for(int i=0;i<8;i++) {		// loop for getting king's location
			for(int j=0;j<8;j++) {
				
				if(board1.getBoard()[i][j]!=null)
                                {
					if(board1.getBoard()[i][j].color!=board1.playercolor&&board1.getBoard()[i][j].name=="king")
                                        {
						x=i;y=j;
						
					}
				}	
			}
		}
		
		boolean bool=false;
		for(int i=0;i<8;i++)
                {		//loop for checking opposite can attack or not
			for(int j=0;j<8;j++) 
                        {
				
				if(board1.getBoard()[i][j]!=null&&(board1.getBoard()[i][j].color!=board1.getBoard()[x][y].color))
                                {
					bool =board1.getBoard()[i][j].Move(i, j, x, y);
					if(bool==true)
                                        {
						ret_flag=true;
						break;
					}
				}
				
			}
		}
		
		return ret_flag;
	}		                   //end of is_check function
	public static boolean is_checkmate()
        {		             
		boolean Rflag=false;
		Board board1=new Board();
		for(int i=0;i<8;i++) 
                {			                 //loop for getting board piece
			for(int j=0;j<8;j++)
                        {
				
			Piece piece1=board1.getBoard()[i][j];		//access piece from chess board
				
			if(piece1!=null) 
                        {
					
					for(int k=0;k<8;k++)
                                        {
						for(int m=0;m<8;m++)
                                                {
							
							board1.ChangeTurn();
							boolean  flag=false;
							if(piece1.color==board1.playercolor)
                                                        {
								flag=piece1.Move(i, j, k, m);
							}
							if(flag==true)
                                                        {
								board1.setPiece(k, m, piece1);
								board1.setPiece(i, j, null);
								board1.ChangeTurn();
								boolean temp_flag=is_check();
								if(temp_flag==true)
                                                                {}
                                                                else 
                                                                {
									Rflag=true;
                                                                        break;
								}
								board1.setPiece(k, m, null);
								board1.setPiece(i, j, piece1);
							}
                                                        else
                                                        {
								board1.ChangeTurn();
							}		
						}
					}
							
			}
			
			}
		}
		
		if (Rflag==true)
                {
			return false;
		}
                else
                {
			return true;
		}
	}	
	public static void main(String arg[])
        {			//main method defined
		
	Board board1=new Board();
	board1.setChessBoard();
	System.out.println("Capital Letter Pieces Are Black: ");
	System.out.println("Small Letter Pieces Are White: ");
	System.out.println();
	board1.ShowBoard();
	
	Scanner input=new Scanner(System.in);
	while(true)
        {			//while loop for many player turn 
		
		System.out.println();
		System.out.println(board1.playercolor+" Piece Turn  ");
		
		System.out.println("Enter the position x1: ");
		int x1=input.nextInt();
                System.out.println("Enter the position y1: ");
		int y1=input.nextInt();
		System.out.println("Enter the position x2: ");
		int x2=input.nextInt();
                System.out.println("Enter the position y2: ");
		int y2=input.nextInt();
		Piece pi=board1.getPieceLocation(y1, x1);
		
		if(pi.color==board1.playercolor)
                {		                  //condition for checking valid or invalid move
			
			boolean bool=pi.Move(y1, x1, y2, x2);
			if(bool==false) 
                        {
				System.out.println();
				System.out.println("Invalid move -- Position Not valid !!");
				System.out.println("Again user "+board1.playercolor+" turn");
				System.out.println();
			}
                        else 
                        {
				boolean prev_check_flag=is_check();
                                   board1.ChangeTurn();
                                    board1.setPiece(y2, x2, pi);
                                    board1.setPiece(y1, x1, null);
				
				
				if(prev_check_flag==false)
                                {
                                   	
				}
                                else
                                {
					board1.setPiece(y2, x2, null);
					board1.setPiece(y1, x1, pi);
				}
				boolean check_flag=is_check();
				if(check_flag==true)
                                {
				
					boolean CheckMate=is_checkmate();		
					
					if(CheckMate==true)
                                        {
						System.out.println("CHECKMATE !!!! GAME OVER");
					}
                                        else
                                        {
						System.out.println("CHECK !! BE CAREFUL");
						board1.ChangeTurn();
					}
					
				}
                                else
                                {
					if(prev_check_flag!=true) 
                                        {		//checking that current no check condition on king
						
						board1.setPiece(y2, x2, pi);
						board1.setPiece(y1, x1, null);
						System.out.println();
						System.out.println("Sucessfully moved!!");
						System.out.println();
						board1.ChangeTurn();
                                        }
                                        else
                                        {
						System.out.println("You Are In Check Cann't Move Piece ");
					}
								
				}	
			}
			
				board1.ShowBoard();
		}
                else
                {
			System.out.println();
			System.out.println("Invalid Move --Not Your Piece:");
			continue;
		}
		
	}
		
	}

}	


 
