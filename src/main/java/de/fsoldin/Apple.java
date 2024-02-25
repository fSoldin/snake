package de.fsoldin;

import java.util.Random;

public class Apple {
    public static Apple createRandomApple(){
        Random random = new Random();
        return new Apple(new Vector2f(random.nextInt(299), random.nextInt(299)), 10, 10);
    }

    private final int height;
    private final int width;
    private final Vector2f position;

    public Apple(Vector2f position, int width, int height){
        this.height = height;
        this.width= width;
        this.position = position;
    }

    public void nextPosition(){
        Random random = new Random();
        this.position.setVector2f(random.nextInt(299), random.nextInt(299));
    }

    public Vector2f getPosition(){
        return this.position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
