package SnakesAndLadders;

import SnakesAndLadders.Entities.Game;
import SnakesAndLadders.Entities.Player;

import java.util.Scanner;

public class Driver {
    public static  void main(String args[]){
        Scanner sn = new Scanner(System.in);
        int dimension, diceCount;

        System.out.println("Enter the dimension of the board: ");
        dimension = sn.nextInt();
        System.out.println("Enter the total dice count: ");
        diceCount = sn.nextInt();

        Player kyle = new Player("Kyle");
        Player eves = new Player("Eves");
        Player june = new Player("June");
        Player tom = new Player("Tom");
        Player jerry = new Player("Jerry");
        Player elena = new Player("Elena");

        Game game = new Game(dimension, diceCount);
        game.addPlayer(kyle);
        game.addPlayer(eves);
        game.addPlayer(june);
        game.addPlayer(tom);
        game.addPlayer(jerry);
        game.addPlayer(elena);

        game.launchGame();

    }
}
