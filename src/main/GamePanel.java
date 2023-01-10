package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
	
	Thread gameThread; 
	//cuando inicia llama automaticamente al metodo run
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		//gameLoop
		while (gameThread != null) {
			
			//System.out.println("El loop está en ejecucion");
			
			//1 UPDATE: cargar informacion de las posiciones del pj
			update();
			
			//2 DRAW: dibujar la pantalla con la nueva posicion del pj
			repaint();
		}
	}
	
	public void update() {
		
	}
	//con este metodo dibujamos el pj
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	}
	
	
	
	
}
