package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Chest extends SuperObjetos{

    public Obj_Chest(){
    
        name = "Chest";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objetos/cofre.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
