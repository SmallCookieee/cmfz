package com.baizhi.cmfz.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class IcodeUtil {

	public static char[] getRandomChars() {

		char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] vcode = new char[4];
		Random ran = new Random();
		for (int i = 0; i < vcode.length; i++) {
			vcode[i] = c[ran.nextInt(62)];
		}
		return vcode;
	}

	public static BufferedImage getImage(char[] icode) {

		BufferedImage buffer = new BufferedImage(90, 40,BufferedImage.TYPE_INT_RGB);

		Graphics g = buffer.getGraphics();

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 90, 40);

		g.setColor(Color.WHITE);
		g.drawString(icode[0] + "", 10, 25);
		g.drawString(icode[1] + "", 30, 25);
		g.drawString(icode[2] + "", 50, 25);
		g.drawString(icode[3] + "", 70, 25);

		g.dispose();

		return buffer;

	}

}
