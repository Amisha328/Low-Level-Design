package SnakesAndLadders.Entities;

import SnakesAndLadders.Service.DiceService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    int dimensions;
    int diceCount;

    Queue<Player> players;
    Queue<Player> winners;

    Board board;

    public Game(int dimensions, int diceCount){
        this.dimensions = dimensions;
        this.diceCount = diceCount;
        this.players = new LinkedList<>();
        this.winners = new LinkedList<>();
        board = new Board(dimensions);
    }

    public void launchGame(){
        while(players.size() > 1){
            Player currentPlayer = players.poll(); // getting the player out of the queue one by one
            System.out.println("Current player is " + currentPlayer.getUsername() + " is at position " + currentPlayer.getPosition());

            System.out.println("Enter any key to roll a dice");

            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);

            int diceValue = DiceService.rollDiceValue(this.diceCount);
            int positionPlayer = currentPlayer.getPosition() + diceValue;
            if(board.isSnakeOrLadder(positionPlayer)){
                // move the player to the end of the BoardEntity
                BoardEntity entity = board.cells.get(positionPlayer);
                positionPlayer = entity.getEnd();
                System.out.println(entity.getEncounterMessage());
            }
            if(positionPlayer == board.size){
                // Player has won
                System.out.println("Player "+ currentPlayer.getUsername() + " won the game");
                winners.add(currentPlayer);
            }
            else if(positionPlayer > board.size){
                // add the  player back to the end of the queue
                System.out.println("Cannot move the player out of the board");
                players.add(currentPlayer);
            }
            else {
                System.out.println(("Moving the player "+ currentPlayer.getUsername() + " to: " + positionPlayer));
                currentPlayer.setPosition(positionPlayer);
                players.add(currentPlayer);
            }
        }
        System.out.println("Winners list: ");
        int rank = 1;
        while(!winners.isEmpty()){
            System.out.println("Rank " + rank + " is " + winners.poll().getUsername());
            rank++;
        }
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
}
