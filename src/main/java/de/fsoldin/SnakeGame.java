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
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private final Timer timer;
    private final KeyAdapter keyAdapter;

    private Snake snake;

    public SnakeGame() {
        this.keyAdapter = new KeyAdapter();
        this.addKeyListener(keyAdapter);
        this.snake = new Snake(new Vector2f(150, 150), Direction.DOWN);
        this.timer = new Timer(75, this);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) snake.getPosition().getX(), (int) snake.getPosition().getY(), 10, 10);
    }

}
