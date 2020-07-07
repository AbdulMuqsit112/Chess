package chess.game;
/**
 *
 * @author ABDUL MUQSIT
 */
public class Queen extends Piece
{
	 Queen(String col, char sym,String name)
         {
		 this.color=col;
		 this.symbol=sym;
		 this.name=name;
	 }
	
	public  boolean Move (int y1,int x1,int y2,int x2)
        {
		
		boolean valid=false;
		int q1=Math.abs(y2-y1);            //absolute value finding positive
		int q2=Math.abs(x2-x1);
		
		if(q1==q2) 
                {
			Bishop bishop1=new Bishop();
			valid=bishop1.Move(y1, x1, y2, x2);
			
		}
                else if(q2==0||q1==0) 
                {
			Rook rook1=new Rook();
			valid=rook1.Move(y1, x1, y2, x2);	
		}
		
		return valid;
	}
	
} 
