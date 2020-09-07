package net.zicron.jol.level;

import net.zicron.jol.JOG;
import net.zicron.jol.gfx.Drawer;
import net.zicron.jol.gfx.Entity;
import net.zicron.jol.gfx.Renderer;
import net.zicron.jol.gfx.Screen;
import net.zicron.jol.io.Log;
import net.zicron.jol.logic.MathTools;
import org.lwjgl.input.Mouse;

public class Player extends Entity {

    private int pieceX;
    private int pieceY;

    public Player(){

        Renderer.addToEntityQueue(this);
    }

    public void tick(){
        pieceX = Mouse.getX();
        pieceY = Screen.current.height - Mouse.getY();

        pieceX = (Mouse.getX() / 32) * 32 + 16;
        pieceY = (pieceY / 32) * 32 + 16;
    }

    public void render(){
        Drawer.drawTexturedQuad(pieceX - 16, pieceY - 16, JOG.entityTextures, 0, 2);
        Drawer.drawTexturedQuad(pieceX, pieceY - 16, JOG.entityTextures, 1, 2);
        Drawer.drawTexturedQuad(pieceX - 16, pieceY, JOG.entityTextures, 32, 2);
        Drawer.drawTexturedQuad(pieceX, pieceY, JOG.entityTextures, 33, 2);
    }

}
