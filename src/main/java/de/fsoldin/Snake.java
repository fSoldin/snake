package de.fsoldin;

import java.util.List;

public class Snake {
    private List<Vector2f> positions;
    private Direction direction;
    private final int height;
    private final int width;
    public Snake(Vector2f position, Direction direction,int width, int height) {
        this.positions = List.of(position);
        this.direction = direction;
        this.height = height;
        this.width= width;
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
                positions.getFirst().substract(new Vector2f(1, 0));
                break;
            case RIGHT:
                positions.getFirst().add(new Vector2f(1, 0));
                break;
            case UP:
                positions.getFirst().substract(new Vector2f(0, 1));
                break;
            case DOWN:
                positions.getFirst().add(new Vector2f(0, 1));
                break;
        }
        if(positions.getFirst().getX() > 299){
            positions.getFirst().setX(0);
        }
        if(positions.getFirst().getX()<0){
            positions.getFirst().setX(299);
        }
        if(positions.getFirst().getY()>299){
            positions.getFirst().setY(0);
        }
        if(positions.getFirst().getY()<0){
            positions.getFirst().setY(299);
        }
    }

    public Vector2f getHeadPosition(){
        return this.positions.getFirst();
    }

    public List<Vector2f> getPositions(){
        return this.positions;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void intersects(Apple apple) {
        //return other.getLeft() < this->getRight() &&
        //			this->getLeft() < other.getRight() &&
        //			other.getTop() < this->getBottom() &&
        //			this->getTop() < other.getBottom();
        //getRight ist die rechte Ecke vom Viereck, x rechts vom Viereck
        //getLeft ist die linke Ecke vom Viereck x links vom Viereck
        if(apple.getPosition().getX() < this.getHeadPosition().getX() + width &&
            this.getHeadPosition().getX() < apple.getPosition().getX() + apple.getWidth() &&
                apple.getPosition().getY() < this.getHeadPosition().getY() + height &&
                this.getHeadPosition().getY() < apple.getPosition().getY() + apple.getHeight()){
            apple.nextPosition();
            Vector2f lastPosition = this.positions.getLast();
            //this.positions.add(new Vector2f());
        }
    }
}
