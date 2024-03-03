package de.fsoldin;


public class SnakeBody {

    private Vector2f position;
    private Direction direction;

    private final int width;

    private final int height;

    public SnakeBody(Vector2f position, Direction direction, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.direction = direction;
    }

    public Vector2f getPosition() {
        return position;
    }

    public SnakeBody createNextTail(){
        return switch (direction) {
            case LEFT ->
                    new SnakeBody(new Vector2f(position.getX() + width, position.getY()), Direction.LEFT, width, height);
            case RIGHT ->
                    new SnakeBody(new Vector2f(position.getX() - width, position.getY()), Direction.RIGHT, width, height);
            case UP ->
                    new SnakeBody(new Vector2f(position.getX(), position.getY() + height), Direction.UP, width, height);
            case DOWN ->
                    new SnakeBody(new Vector2f(position.getX(), position.getY() - height), Direction.DOWN, width, height);
        };
    }

    public Direction getDirection() {
        return direction;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setDirection(Direction newDirection){
        if(direction==Direction.RIGHT && newDirection!= Direction.LEFT ||
                direction== Direction.LEFT && newDirection != Direction.RIGHT ||
                direction== Direction.UP && newDirection != Direction.DOWN ||
                direction== Direction.DOWN && newDirection != Direction.UP){
            this.direction = newDirection;
        }
    }

    public void move() {
        switch (direction) {
            case LEFT:
                position.substract(new Vector2f(10, 0));
                break;
            case RIGHT:
                position.add(new Vector2f(10, 0));
                break;
            case UP:
                position.substract(new Vector2f(0, 10));
                break;
            case DOWN:
                position.add(new Vector2f(0, 10));
                break;
        }
        if(position.getX() > 299){
            position.setX(0);
        }
        if(position.getX()<0){
            position.setX(299);
        }
        if(position.getY()>299){
            position.setY(0);
        }
        if(position.getY()<0){
            position.setY(299);
        }
    }

    public boolean intersects(SnakeBody snakeBody) {
        if (snakeBody.getPosition().getX() < this.getPosition().getX() + width &&
                this.getPosition().getX() < snakeBody.getPosition().getX() + snakeBody.getWidth() &&
                snakeBody.getPosition().getY() < this.getPosition().getY() + height &&
                this.getPosition().getY() < snakeBody.getPosition().getY() + snakeBody.getHeight()) {
            return true;
        }
        return false;
    }
}
