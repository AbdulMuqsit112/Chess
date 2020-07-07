package chess.game;

/**
 *
 * @author ABDUL MUQSIT
 */
public abstract class Piece
    {
	String color;
	char symbol;
	String name;
	
	abstract boolean Move(int y1,int x1,int y2,int x2);
    }
