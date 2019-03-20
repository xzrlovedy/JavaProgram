package interfaceFactories;

/**
 * java编程思想工厂方法设计模式
 * @author Administrator
 *
 */
interface Games{boolean move();}
interface GamesFactory{Games getGames();}

//国际象棋
class Checkers implements Games{
	private int moves = 0;
	private static final int MOVES = 3;
	@Override
	public boolean move() {
		System.out.println("国际象棋移动："+moves);
		return ++moves!=MOVES;
	}
}
class CheckersFactory implements GamesFactory{
	@Override
	public Games getGames() {
		return new Checkers();
	}
}

//中国象棋
class Chess implements Games{
	private int moves = 0;
	private static final int MOVES = 4;
	@Override
	public boolean move() {
		System.out.println("中国象棋移动："+moves);
		return ++moves!=MOVES;
	}
}
class ChessFactory implements GamesFactory{
	@Override
	public Games getGames() {
		return new Chess();
	}
}
public class Game {
	public static void playGame(GamesFactory factory) {
		Games s = factory.getGames();
		while(s.move())
			;
	}
	public static void main(String[] args) {
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
	}
}
