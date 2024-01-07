package de.fsoldin;

public class Snake {
    private Vector2f position;
    private Direction direction;

    public Snake(Vector2f position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case LEFT:
                position.substract(new Vector2f(1, 0));
                break;
            case RIGHT:
                position.add(new Vector2f(1, 0));
                break;
            case UP:
                position.substract(new Vector2f(0, 1));
                break;
            case DOWN:
                position.add(new Vector2f(0, 1));
                break;
        }
    }

    public Vector2f getPosition(){
        return this.position;
    }
}
