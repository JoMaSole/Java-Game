package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Door extends SuperObjetos {

    public Obj_Door(){
    
            name = "Door";
            try{
    
                image = ImageIO.read(getClass().getResourceAsStream("/objetos/puerta.png"));
    
            }catch(IOException e){
                e.printStackTrace();
            }
        }

}
