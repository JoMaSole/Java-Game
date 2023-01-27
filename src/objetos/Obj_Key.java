package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Key extends SuperObjetos{
    
    public Obj_Key(){

        name = "Key";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objetos/llave.png"));

        }catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
    }

}
