package SnakesAndLadders.Service;

public class DiceService {
    public static int rollDiceValue(int diceCount){
        int minVal = 1;
        int maxVal = diceCount * 6;
        int diceValue = (int) Math.floor(Math.random() * (maxVal - minVal + 1)) + minVal;

        System.out.println(("Rolled dice and got the value: " + diceValue));
        return diceValue;
    }
}

