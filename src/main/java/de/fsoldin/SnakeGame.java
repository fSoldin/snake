package de.fsoldin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SnakeGame extends JPanel implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SnakeGame snakeGame = new SnakeGame();
        frame.add(snakeGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private final Snake snake;
    private final Apple apple;
    private final KeyAdapter keyAdapter;

    public SnakeGame() {
        this.keyAdapter = new KeyAdapter();
        this.addKeyListener(keyAdapter);
        this.setFocusable(true);
        this.snake = new Snake(new Vector2f(150, 150), Direction.DOWN,10,10);
        this.apple = Apple.createRandomApple();
        Timer timer = new Timer(75, this);
        timer.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(keyAdapter.isLeft()){
            snake.setDirection(Direction.LEFT);
        }else if(keyAdapter.isRight()){
            snake.setDirection(Direction.RIGHT);
        } else if(keyAdapter.isUp()){
            snake.setDirection(Direction.UP);
        }else if(keyAdapter.isDown()){
            snake.setDirection(Direction.DOWN);
        }else {
            snake.setDirection();
        }
        snake.move();
        snake.intersects(apple);
        repaint();
        if(snake.isGameOver()) {
            System.err.println("GAME OVER!");
            System.exit(0);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) apple.getPosition().getX(), (int) apple.getPosition().getY(),apple.getWidth(),apple.getHeight());
        g.setColor(Color.BLACK);
        //foreach
        for(Vector2f position: snake.getPositions()){
            g.fillRect((int) position.getX(), (int) position.getY(), snake.getWidth(), snake.getHeight());
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
