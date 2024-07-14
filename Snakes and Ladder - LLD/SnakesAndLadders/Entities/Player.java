package SnakesAndLadders.Entities;

public class Player {
    String username;
    int position;

    public Player(String username) {
        this.username = username;
        this.position = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
