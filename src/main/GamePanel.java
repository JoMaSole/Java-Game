package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	// screen settings
	final int originalTileSize = 16; //16x16
	final int scale = 3;
	
	final int titleSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = titleSize * maxScreenCol; //768
	final int screenHeight = titleSize * maxScreenRow; //576
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; 
	//cuando inicia llama automaticamente al metodo run
	
	//setear posicion default del pj
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; //1seg
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		
		//gameLoop
		while (gameThread != null) {
			
			
			//1 UPDATE: cargar informacion de las posiciones del pj
			update();
			
			//2 DRAW: dibujar la pantalla con la nueva posicion del pj
			repaint();
			
		
			
				try {
					double remainingTime = nextDrawTime - System.nanoTime();
					remainingTime = remainingTime/1000000;
					
					if(remainingTime < 0) {
						remainingTime = 0;
					}
					
					Thread.sleep((long) remainingTime);
					
					nextDrawTime += drawInterval;
					
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void update() {
		
		if(keyH.upPressed == true) {
			playerY -= playerSpeed;
			//playerY = playerY - playerSpeed;
		}else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		}else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
		
	}
	//con este metodo dibujamos el pj
	public void paintComponent(Graphics g) { 
		//es el lapiz o pincel
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillOval(playerX, playerY, titleSize, titleSize);
		g2.dispose();
		
		
	}
	
	
	
	
}
