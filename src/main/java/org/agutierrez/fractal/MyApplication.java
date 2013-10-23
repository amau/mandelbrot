
package org.agutierrez.fractal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.agutierrez.fractal.core.EscapeTime;
import org.agutierrez.fractal.core.EscapeTimeInfo;
import org.agutierrez.fractal.image.FractalImage;
import org.agutierrez.mandelbrot.Mandelbrot;
import org.agutierrez.mandelbrot.MandelbrotInfo;

public class MyApplication
{

	public static int WIDTH = 1920;

	public static int HEIGHT = 1080;


	public static void main(String[] args)
	{
		start();
	}


	public static void start()
	{
		System.out.println("Mandelbrot Set");
		EscapeTime mandelbrot = new Mandelbrot(255, 10.0);
		FractalImage fractalImage = new FractalImage(mandelbrot,WIDTH, HEIGHT);
		
		fractalImage.paint(false);

		//drawShapesTwo(bufferedImage);
		try
		{
			ImageIO.write(fractalImage, "png", new File(
					"mandelbrot.png"));
			System.out.println("Image has been created.");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void drawShapes(BufferedImage bufferedImage)
	{
		EscapeTime mandelbrot = new Mandelbrot(255, 4.0);
		double pixelValueWidth = 0.50 / WIDTH;
		double pixelValueHeight = 0.50 / HEIGHT;
		double re = -0.75;
		double im = -0.75;

		for (int j = 0; j < HEIGHT; j++)
		{
			im += pixelValueHeight;
			re = -1.0;
			for (int i = 0; i < WIDTH; i++)
			{
				re += pixelValueWidth;
				EscapeTimeInfo color = mandelbrot.escapeTime(re, im);
				Color c = new Color(color.getN(), color.getN(),
						color.getN());
				bufferedImage.setRGB(i, j, c.getRGB());
			}
		}
	}


	public static void drawShapesTwo(BufferedImage bufferedImage)
	{
		EscapeTime mandelbrot = new Mandelbrot(255, 4.0);
		double pixelValueWidth = 0.50 / WIDTH;
		double pixelValueHeight = 0.50 / HEIGHT;
		double re = -0.75;
		double im = -0.75;
		int array[] = new int[WIDTH * HEIGHT];
		int counter = 0;
		for (int j = 0; j < HEIGHT; j++)
		{
			im += pixelValueHeight;
			re = -1.0;
			for (int i = 0; i < WIDTH; i++)
			{
				re += pixelValueWidth;
				EscapeTimeInfo color = mandelbrot.escapeTime(re, im);
				Color c = new Color(color.getN(), color.getN(),
						color.getN());
				array[counter] = c.getRGB();
				counter++;
			}
		}
		bufferedImage.setRGB(0, 0, WIDTH, HEIGHT, array, 0, WIDTH);
	}


	public static void drawShapesThree(BufferedImage bufferedImage,
			int[] colors)
	{
		EscapeTime mandelbrot = new Mandelbrot(255, 4.0);
		double pixelValueWidth = 0.4 / WIDTH;
		double pixelValueHeight = 0.5 / HEIGHT;
		double re = -0.75;
		double im = -0.75;
		int array[] = new int[WIDTH * HEIGHT];
		int counter = 0;

		for (int j = 0; j < HEIGHT; j++)
		{
			im += pixelValueHeight;
			re = -1.0;
			for (int i = 0; i < WIDTH; i++)
			{
				re += pixelValueWidth;
				MandelbrotInfo color = (MandelbrotInfo) mandelbrot
						.escapeTime(re, im);
				double radius = Math.sqrt(color.squaredIm
						+ color.squaredRe);

				// System.out.println(radius);

				int loc = (int) ((float) color.getN() + 1 - Math
						.log(Math.log((float) radius)) / Math.log(2));

				int finalColor = loc % 255;
				finalColor = (finalColor << 8) + loc % 255;
				finalColor = (finalColor << 8) + loc % 255;

				// array[counter] = colors[loc%255];
				array[counter] = finalColor;

				counter++;
			}
		}
		bufferedImage.setRGB(0, 0, WIDTH, HEIGHT, array, 0, WIDTH);
	}


	public static int[] generateRandomArray(int n)
	{
		Random random = new Random();

		int array[] = new int[n];

		for (int i = 0; i < n; i++)
		{
			Color c = new Color(random.nextInt(256),
					random.nextInt(256), random.nextInt(256));
			array[i] = c.getRGB();
		}
		return array;
	}

}