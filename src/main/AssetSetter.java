package main;

import objetos.Obj_Chest;
import objetos.Obj_Door;
import objetos.Obj_Key;
import objetos.Obj_Boots;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObjeto(){

        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new Obj_Key();
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        gp.obj[3] = new Obj_Door();
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 9 * gp.tileSize;
        
        gp.obj[4] = new Obj_Door();
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        gp.obj[5] = new Obj_Door();
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;

        gp.obj[6] = new Obj_Chest();
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 7 * gp.tileSize;

        gp.obj[7] = new Obj_Boots();
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;
    }
}
