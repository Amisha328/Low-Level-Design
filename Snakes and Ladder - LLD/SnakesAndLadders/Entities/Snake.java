package SnakesAndLadders.Entities;

public class Snake extends BoardEntity{
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Encountered a Snake";
    }
}
