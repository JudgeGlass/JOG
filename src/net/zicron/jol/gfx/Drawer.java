package net.zicron.jol.gfx;

import net.zicron.jol.io.Texture;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex2i;


public class Drawer {
	public static void drawTexturedQuad(int x, int y, Texture t, byte index, int scale) {
		t.bind();
		
		int xx = index % 16;
		int yy = index / 16;
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glEnable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
			glTexCoord2f((xx / 16f), (yy / 16f));
			glVertex2f(x, y);
			glTexCoord2f((xx + 1) / 16f, yy / 16f);
			glVertex2f((x+8 * scale), y);
			glTexCoord2f((xx+1) / 16f, (yy+1) / 16f);
			glVertex2f((x + 8 * scale), (y + 8 * scale));
			glTexCoord2f(xx / 16f, (yy+1) / 16f);
			glVertex2f(x, (y + 8 * scale));
		glEnd();
		glDisable(GL_TEXTURE_2D);
		glDisable(GL_BLEND);
	}
	
	public static void drawTexturedQuad(int x, int y, Texture t, int index, int scale) {
		t.bind();
		
		int xx = index % 32;
		int yy = index / 32;
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glEnable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
			glTexCoord2f((xx / 32f), (yy / 32f));
			glVertex2f(x, y);
			glTexCoord2f((xx + 1) / 32f, yy / 32f);
			glVertex2f((x+8 * scale), y);
			glTexCoord2f((xx+1) / 32f, (yy+1) / 32f);
			glVertex2f((x + 8 * scale), (y + 8 * scale));
			glTexCoord2f(xx / 32f, (yy+1) / 32f);
			glVertex2f(x, (y + 8 * scale));
		glEnd();
		glDisable(GL_TEXTURE_2D);
		glDisable(GL_BLEND);
	}
	
	public static void drawLine(int x1, int y1, int x2, int y2) {
		glBegin(GL_LINES);
			glVertex2i(x1, y1);
			glVertex2i(x2, y2);
		glEnd();
	}
	
	public static void drawQuad(int x, int y, int w, int h, int color) {
		int r = (color & 0xFF0000) >> 16;
	    int g = (color & 0xFF00) >> 8;
	    int b = (color & 0xFF);
	    
	    glColor3f(r/255f, g/255f, b/255f);
		glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x + w, y);
			glVertex2f(x + w, y + h);
			glVertex2f(x, y + h);
		glEnd();
	}
	
	public static void enable(int function) {
		glEnable(function);
	}
	
	public static void disable(int function) {
		glDisable(function);
	}
}
