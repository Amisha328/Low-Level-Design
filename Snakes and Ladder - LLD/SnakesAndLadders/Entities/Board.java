package SnakesAndLadders.Entities;

import SnakesAndLadders.Factory.BoardEntityEnum;
import SnakesAndLadders.Factory.EntityFactory;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int size;
    Map<Integer, BoardEntity> cells;

    public Board(int dimension) {
        this.size = dimension * dimension;
        cells = new HashMap<>();

        for(int i = 0; i < dimension; i++){

            // generate snake at random positions
            int start = 2, end = size-1;
            int snakeStart = randomValueGenerator(start, end);
            end = snakeStart-1;
            int snakeEnd = randomValueGenerator(start, end);
            System.out.println("Snake start: "+snakeStart+" end: "+snakeEnd);
            // generate ladder at random positions
            if(!isSnakeOrLadder(snakeStart)){
                addEntityToBoard(EntityFactory.getEntity(BoardEntityEnum.SNAKE, snakeStart, snakeEnd), snakeStart);
            }

            // generate ladder at random positions
            start = 2;
            end = size-1;
            int ladderStart = randomValueGenerator(start,end);
            start = ladderStart+1;
            int ladderEnd = randomValueGenerator(start, end);
            System.out.println("Ladder start: "+ladderStart+" end: "+ladderEnd);
            if(!isSnakeOrLadder(ladderStart)){
                addEntityToBoard(EntityFactory.getEntity(BoardEntityEnum.LADDER, ladderStart, ladderEnd), ladderStart);
            }
        }
    }

    private int randomValueGenerator(int min, int max){
        return (int) Math.floor(Math.random() * (max-min + 1) + min);
    }

    public boolean isSnakeOrLadder(int index){
        return this.cells.containsKey(index);
    }

    private void addEntityToBoard(BoardEntity boardEntity, int index){
        this.cells.put(index, boardEntity);
    }
}
