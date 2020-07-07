
package chess.game;

/**
 *
 * @author ABDUL MUQSIT
 */
public  class Knight extends Piece {		//Knight class
	
	Knight(String col,char sym,String name){		 //Knight constructor
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	
	public boolean Move(int y1,int x1,int y2,int x2) {		//move_piece function checking valid move
		
		boolean valid=false;
		Board board_class_obj = new Board();
		Piece temp_board[][]= board_class_obj.getBoard();
		
		int abs1=Math.abs(y2-y1);	//assigning absolute value of coordinate difference positive
		int abs2=Math.abs(x2-x1);
		
		if((abs1==1&&abs2==2)||(abs1==2&&abs2==1))
                {
			if(temp_board[y2][x2]==null || board_class_obj.playercolor!=temp_board[y2][x2].color) 
                        {
				valid=true;
			}
		
		}	
		
		return valid;
	
	}
	
	}
