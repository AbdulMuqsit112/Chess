package chess.game;

/**
 *
 * @author ABDUL MUQSIT
 */
 public class Bishop extends Piece                     
 {		
	
	Bishop(String col,char sym,String name)  //overloaded constructor
        {
		this.color=col;
		this.symbol=sym;
		this.name=name;
	}
	Bishop(){}
	public boolean Move(int y1,int x1,int y2,int x2)
        {
		
		boolean valid=false;
		Board board1 = new Board();
		Piece temp_board[][]= board1.getBoard();
		
		int b1=Math.abs(y2-y1);    //assigning absolute value of coordinate difference positive
		int b2=Math.abs(x2-x1);
		if(b1==b2) 
                {
		int count=1;
			while(count<=b2)
                        {	
				int col,row;
				if(y1>y2&&x1>x2)
                                {		           // upper left
					col=y1-count;
					row=x1-count;
				}
                                else if(y1<y2&&x1>x2)
                                {		           // upper right
					col=y1+count;
					row=x1-count;
				}
                                else if(y1>y2&&x1<x2)
                                {		            // Lower Left
					col=y1-count;
					row=x1+count;
				}
                                else
                                {			    // lower right
					col=y1+count;
					row=x1+count;
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
			
			
			if(temp_board[y2][x2]==null&&count==b1+1)
                        {
				valid=true;
			}
                        else if(temp_board[y2][x2]!=null&&count==b1-1&&board1.playercolor!=temp_board[y2][x2].color)
                        {
				valid=true;
			}
		
                }
		return valid;
	}
	

		
}
