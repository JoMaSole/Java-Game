package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Boots extends SuperObjetos{

    public Obj_Boots(){

        name = "Key";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objetos/botas.png"));

        }catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
    
}
