package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

//tareas: crear mapa de 50 x 50

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;

			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tierra.png"));

			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/camino.png"));

			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arbol.png"));
			tile[5].collision = true;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			//cambiamos el string a integer
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine(); //lee una linea de texto
				
				while (col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		
		//recrear escenario con las coordenadas de cada dibujo seria tedioso creamos de forma automatica
		
		//g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
		//g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
		//g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
		
		//se hace el mapa en un editor de texto
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];

			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			//con este if hacemos que dibuje las baldosas de al rededor del jugador, 
			//para que no relantice el juego dibujando el mapa entero todo el tiempo

			if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && 
			   worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){

				   g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

			   }
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
