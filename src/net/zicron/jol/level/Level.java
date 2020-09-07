package net.zicron.jol.level;

import net.zicron.jol.JOG;
import net.zicron.jol.gfx.Drawer;
import net.zicron.jol.gfx.Entity;
import net.zicron.jol.gfx.Renderer;
import net.zicron.jol.gfx.text.Font;

public class Level extends Entity {

    private byte[] gameBoard;

    public Level(){

        gameBoard = new byte[361];

        Renderer.addToEntityQueue(this);
    }

    public void tick() {

    }

    public void render() {
        Font.draw(5, 5, "FPS: " + Renderer.getFPS(), 0xFFFFFF, 2, false, JOG.fontTextures);

        for(int x = 0; x < 19; x++){
            for(int y = 0; y < 19; y++){
                if(x == 0 && y == 0){
                    Drawer.drawTexturedQuad(64, 64, JOG.gameTextures, (byte) 0, 4);
                }else if(x == 18 && y == 0){
                    Drawer.drawTexturedQuad(64 + (x * 32), 64, JOG.gameTextures, (byte) 2, 4);
                }else if(y == 0){
                    Drawer.drawTexturedQuad(64 + (x * 32), 64, JOG.gameTextures, (byte) 1, 4);
                }

                if(y > 0 && y < 18){
                    if(x == 0){
                        Drawer.drawTexturedQuad(64 + (x * 32), 64 + (y * 32), JOG.gameTextures, (byte) 16, 4);
                    }else if(x == 18){
                        Drawer.drawTexturedQuad(64 + (x * 32), 64 + (y * 32), JOG.gameTextures, (byte) 18, 4);
                    }else{
                        Drawer.drawTexturedQuad(64 + (x * 32), 64 + (y * 32), JOG.gameTextures, (byte) 17, 4);
                    }
                }

                if(y == 18){
                    if(x == 0){
                        Drawer.drawTexturedQuad(64 + (x * 32), 64 + (y * 32), JOG.gameTextures, (byte) 32, 4);
                    }else if(x == 18){
                        Drawer.drawTexturedQuad(64 + (x * 32), 64 + (y * 32), JOG.gameTextures, (byte) 34, 4);
                    }else{
                        Drawer.drawTexturedQuad(64 + (x * 32), 64 + (y * 32), JOG.gameTextures, (byte) 33, 4);
                    }
                }
            }
        }

    }
}
