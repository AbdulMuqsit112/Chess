
package chess.game;

/**
 *
 * @author ABDUL MUQSIT
 */
public class King extends Piece
{		
	King(String col,char sym, String name)
        {		                                 //King overloaded constructor
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	
	public  boolean Move(int y1,int x1,int y2,int x2){		//move piece function
		
		boolean valid=false;
		Board board1 = new Board();
		Piece temp_board[][]= board1.getBoard();
		
		int k1=Math.abs(y2-y1);       	//assigning absolute value of coordinate difference positive
		int k2=Math.abs(x2-x1);
		
		if((k1==1&&k2==0)||(k1==0&&k2==1)||(k1==1&&k2==1))
                {
			if(temp_board[y2][x2]==null) {
				valid=true;
			}
			else if((board1.playercolor!=temp_board[y2][x2].color)&&(temp_board[y2][x2]!=null)) {
				valid=true;
			}	
		}
		return valid;
	}  
	
	} 
