package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	// screen settings
	final int originalTileSize = 16; //16x16
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //768
	public final int screenHeight = tileSize * maxScreenRow; //576
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //cuando inicia llama automaticamente al metodo run
	Player player = new Player(this,keyH);
	
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
		
		/*double drawInterval = 1000000000/FPS; //1seg
		double nextDrawTime = System.nanoTime() + drawInterval;
		//gameLoop
		while (gameThread != null) {
			update();//1 UPDATE: cargar informacion de las posiciones del pj
			repaint(); //2 DRAW: dibujar la pantalla con la nueva posicion del pj
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
			}*/
		
		double drawInterval = 1000000000/FPS; //1seg
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		//gameLoop
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				update();   
				repaint(); 
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		
		player.update();
		
	}
	//con este metodo dibujamos el pj
	
	public void paintComponent(Graphics g) { 
		//es el lapiz o pincel
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2); //primero se dibuja el fondo y despues el pj
		player.draw(g2);
		g2.dispose();
		
		
	}
	
	
	
	
}
