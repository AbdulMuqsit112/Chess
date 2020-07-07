package chess.game;

/**
 *
 * @author ABDUL MUQSIT
 */
 public class Board
 {		
	
	static Piece[][] a2dp=new Piece[8][8]; 
	static String playercolor="black";
		        public  void setChessBoard()
                        {	  //set the pieces in the board
			for(int i=0;i<8;i++)
                        {
				Pawn pawn1= new Pawn("white",'p',"pawn");		//white pawn 
				a2dp[1][i]=pawn1;
			}	
				for(int i=0;i<=7;i+=7)
                                {
					Rook rook1=new Rook("white",'r',"rook");
					a2dp[0][i]=rook1; 
				}
				
				for(int i=1;i<=6;i+=5) 
                                {
					Knight knight1=new Knight("white",'n',"knight");
					a2dp[0][i]=knight1; //white knight initialization
				}
				
				for(int i=2;i<=5;i++) 
                                {
					Bishop bishop1=new Bishop("white",'b',"bishop");
					a2dp[0][i]=bishop1; //white bishop initialization
				}
				
				King king_obj=new King("white",'k',"king");
				Queen queen_obj=new Queen("white",'q',"queen");
						a2dp[0][3]=king_obj;  //white king  and queen initialization
						a2dp[0][4]=queen_obj;
							
				//black piece initialization
				for(int i=0;i<8;i++)
                                {
					Pawn pawn1= new Pawn("black",'P',"pawn");	//black pawn
					a2dp[6][i]=pawn1;				
				}		
						for(int i=0;i<=7;i+=7)
                                                {
							Rook rook_obj=new Rook("black",'R',"rook");
							a2dp[7][i]=rook_obj;        //Rook initialization
						}
						
						for(int i=1;i<=6;i+=5) 
                                                {
							Knight knight1=new Knight("black",'N',"knight");
							a2dp[7][i]=knight1; //black knight initialization
						}
						
						for(int i=2;i<=5;i++)
                                                {
							Bishop bishop1=new Bishop("black",'B',"bishop");
							a2dp[7][i]=bishop1;      //black bishop initialization
						}
						
						King blackKing=new King("black",'K',"king");
						Queen black_queen_obj=new Queen("black",'Q',"queen");
						
						a2dp[7][4]=blackKing;        //black king  and queen initialization
						a2dp[7][3]=black_queen_obj;	
						
																						
			}
                        public Piece getPieceLocation(int p,int q)       //method of  location piece object to finding
                        { 
			
				return a2dp[p][q];
			}
		 	public Piece[][] getBoard()
                        {                                        //get chess board when called
				
				return a2dp;
		 	}
		 	public void ShowBoard()
                        {	                                 //show current board function
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++)
                                        {
				
					if(a2dp[i][j]!=null)
                                        {
						System.out.printf(a2dp[i][j].symbol+"  ");
					}else {
						System.out.printf('-'+"  ");
					}
					}
					System.out.println();
				}
			}
			public void setPiece(int c,int d,Piece type) //set particular location in board with piece type
			{  
				a2dp[c][d]=type;
			}
			public void setPlayer(String ply)			//method to set player colour
			{
				playercolor=ply;
				
			}
			public String getPlayer()                                  //method to get player
                        {			
				
				return playercolor;
			}
			public static void ChangeTurn()
                        {		//method for changing turn of user
				
				if(playercolor=="white")
                                {
					playercolor="black";
				}
                                else if(playercolor=="black")
                                {
					playercolor="white";
				}
			}
								
}
