
package chess.game;

/**
 *
 * @author ABDUL MUQSIT
 */
public  class Rook extends Piece {		//Rook class 
	
	Rook(String col, char sym, String name){
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	Rook()
	{
	}
	
public boolean Move(int y1,int x1,int y2,int x2) {		//move_piece function
		
		boolean valid=false;
		Board board1 = new Board();
		Piece temp_board[][]= board1.getBoard();
		
		int r1=Math.abs(y2-y1);	//assigning absolute value of coordinate difference positivr
		int r2=Math.abs(x2-x1);
		
		if((r1==0&&r2!=0)||(r1!=0&&r2==0))
                {
		
			int count=1;
                        int col=0,row =0;
			while(count<=r1)
                        {	
                            if(x2==x1)
                            {
				if(y1>y2)
                                {		                 //left 
					col=y1-count;
					row=x2;
				}
                                else 
                                {	                      	// right 
					col=y1+count;
					row=x1;
				}
                            }
                               else if(y2==y1)
                               { 
                                   if(x1>x2)
                                {                		//up
					col=y2;
					row=x1-count;
                                }
                                else
                                {						//Down
					col=y1;
					row=x1+count;
				}
                               }
				if(temp_board[col][row]==null)
                                {
					count++;
				}
                                else 
                                {
					count--;
					break;
				}
			}
			
			
			if(temp_board[y2][x2]==null&&count==r1+1) 
                        {
				valid=true;
			}
                        else if(temp_board[y2][x2]!=null&&count==r1-1&&board1.playercolor!=temp_board[y2][x2].color) {
				valid=true;
			}
		}
		
		return valid;
	}
}

