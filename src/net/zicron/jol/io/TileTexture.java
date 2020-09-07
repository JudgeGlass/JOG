package net.zicron.jol.io;

public class TileTexture {
	
	public static int getTextureById(byte id) {
		switch(id) {
			case 0:
			case 2:
				return 0;
			case 1:
				return 0;
			default:
				return 00;
		}
	}
}
