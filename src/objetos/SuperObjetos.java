package objetos;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import main.GamePanel;
import java.awt.Graphics2D;

public class SuperObjetos {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int  worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    
    public void draw(Graphics2D g2, GamePanel gp){

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        
        //con este if hacemos que dibuje las baldosas de al rededor del jugador, 
        //para que no relantice el juego dibujando el mapa entero todo el tiempo

        if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && 
           worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
           worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
           worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){

               g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

           }

    }
}
