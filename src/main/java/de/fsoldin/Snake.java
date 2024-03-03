package de.fsoldin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Snake {
    private final List<SnakeBody> snakeBodies;
    private final int height;
    private final int width;

    public Snake(Vector2f position, Direction direction, int width, int height) {
        this.snakeBodies = new ArrayList<>();
        this.snakeBodies.add(new SnakeBody(position, direction, width, height));
        this.height = height;
        this.width = width;
    }

    public void setDirection(Direction newDirection) {
        for (int i = snakeBodies.size() - 1; i > 0; i--) {
            SnakeBody previous = snakeBodies.get(i - 1);
            SnakeBody current = snakeBodies.get(i);
            current.setDirection(previous.getDirection());
        }
        this.snakeBodies.getFirst().setDirection(newDirection);
    }

    public void setDirection() {
        for (int i = snakeBodies.size() - 1; i > 0; i--) {
            SnakeBody previous = snakeBodies.get(i - 1);
            SnakeBody current = snakeBodies.get(i);
            current.setDirection(previous.getDirection());
        }
    }

    public void move() {
        this.snakeBodies.forEach(SnakeBody::move);
    }

    public Vector2f getHeadPosition() {
        return this.snakeBodies.getFirst().getPosition();
    }

    public List<Vector2f> getPositions() {
        return this.snakeBodies.stream().map(SnakeBody::getPosition).collect(Collectors.toList());
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void intersects(Apple apple) {
        if (apple.getPosition().getX() < this.getHeadPosition().getX() + width &&
                this.getHeadPosition().getX() < apple.getPosition().getX() + apple.getWidth() &&
                apple.getPosition().getY() < this.getHeadPosition().getY() + height &&
                this.getHeadPosition().getY() < apple.getPosition().getY() + apple.getHeight()) {
            apple.nextPosition();
            snakeBodies.add(snakeBodies.getLast().createNextTail());
        }
    }

    public boolean isGameOver() {
        //Wenn Head mit irgendeinen Snake Body außer sich selbst überschneided, dann true, ansonsten false
        SnakeBody head = snakeBodies.getFirst();
        for (int i = 2; i < snakeBodies.size(); i++) {
            SnakeBody tail = snakeBodies.get(i);
            if(head.intersects(tail)){
                return true;
            }
        }
        return false;
    }
}
