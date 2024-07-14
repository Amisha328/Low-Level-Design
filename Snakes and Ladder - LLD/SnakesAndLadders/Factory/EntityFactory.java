package SnakesAndLadders.Factory;

import SnakesAndLadders.Entities.BoardEntity;
import SnakesAndLadders.Entities.Ladder;
import SnakesAndLadders.Entities.Snake;

public class EntityFactory {
    public static BoardEntity getEntity(BoardEntityEnum boardEntityEnum, int start, int end){
        if(boardEntityEnum.equals(BoardEntityEnum.SNAKE)){
            return new Snake(start, end);
        }
        else if(boardEntityEnum.equals(BoardEntityEnum.LADDER)){
            return new Ladder(start, end);
        }
        System.out.println("Invalid Entity Type");
        return null;
    }
}
