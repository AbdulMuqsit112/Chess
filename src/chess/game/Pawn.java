
package chess.game;
/**
 *
 * @author ABDUL MUQSIT
 */
public class Pawn extends Piece
{	
	
	public Pawn(String col, char sym,String name){		//Pawn constructor
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	
	public boolean Move(int y1,int x1,int y2,int x2)			//move_piece function
	{
		boolean valid=false;
		Board board1 = new Board();
		Piece temp_board[][]= board1.getBoard();
		
		int p1=Math.abs(y2-y1);	//assigning absolute value of coordinate difference positive
		int p2=Math.abs(x2-x1);
		
		if((p1==1&&p2==0)||(p1==1&&p2==1))
                { 	                                  //one cell move
			boolean flag=false;
			
			if((temp_board[y2][x2]==null)&&(p1==1&&p2==0))
                        {
				flag=true;
					
			}
                        else if((p1==1&&p2==1)&&temp_board[y2][x2]!=null)
                        {
				if((temp_board[y2][x2].color!=board1.playercolor))
                                {
					flag=true;
				}
				
			}
			if(flag==true)
                        {		                    //checking that a pawn can not move backward
				if((board1.playercolor=="white"&&y2>y1)|| (board1.playercolor=="black"&&y2<y1))
                                {
					valid=true;
				}
			}
				
		}
                else if((p1==2)&&(x2==x1)&&(temp_board[y2][x2]==null) &&(y1==6||y1==1))
                {      //two cell move of pawn   
                    int row ,col=x1;
                       if(y1==6)
                       {
                           row=y1-1;
                           if(temp_board[row][col]==null)
                           {
                            valid=true;   
                           }
                       }
                       if(y1==1) 
			{
                           row=y1+1;
                           if(temp_board[row][col]==null)
                           {
                            valid=true;   
                           }
                       }

		}
		return valid;		//return valid
	}
	
}
