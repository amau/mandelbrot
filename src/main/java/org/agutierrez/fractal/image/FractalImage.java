package org.agutierrez.fractal.image;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.agutierrez.fractal.core.EscapeTime;
import org.agutierrez.fractal.core.EscapeTimeInfo;

public class FractalImage extends BufferedImage
{
	EscapeTime fractal;
	double centerX;
	double centerY;
	double sizeX;
	double sizeY;
	ColorPalette colors;

	public FractalImage(EscapeTime fractal, int width, int height)
	{
		super(width, height, BufferedImage.TYPE_INT_RGB);
		this.fractal = fractal;
		this.centerX = 0.0;
		this.centerY = 0.0;
		this.sizeX = 4;
		this.sizeY = 2.25;
		this.colors = new WikipediaPallete(0,fractal.getMax());
	}
	
	public void paint(boolean bands)
	{
		for (int i = 0; i < getWidth(); i++)
		{
			for (int j = 0; j < getHeight(); j++)
			{
				double re = centerX - sizeX / 2 + sizeX * i / getWidth();
				double im = sizeY * j / getHeight() - centerX - sizeY / 2;
				
				if(re < - 1.0 && re > - 1.1 && im < .05 && im > -.05)
					{
						int k=0;
						k = k + 1;
					}
				
				EscapeTimeInfo info  =  fractal.escapeTime(re, im);
				Color color =  colors.getColor(info, bands);
				this.setRGB(i,j,color.getRGB());
			}
		}	
	}
	
	public EscapeTime getFractal()
	{
		return fractal;
	}

	public void setFractal(EscapeTime fractal)
	{
		this.fractal = fractal;
	}

	public double getCenterX()
	{
		return centerX;
	}

	public void setCenterX(double centerX)
	{
		this.centerX = centerX;
	}

	public double getCenterY()
	{
		return centerY;
	}

	public void setCenterY(double centerY)
	{
		this.centerY = centerY;
	}

	public double getSizeX()
	{
		return sizeX;
	}

	public void setSizeX(double sizeX)
	{
		this.sizeX = sizeX;
	}

	public double getSizeY()
	{
		return sizeY;
	}

	public void setSizeY(double sizeY)
	{
		this.sizeY = sizeY;
	}

	public ColorPalette getColors()
	{
		return colors;
	}

	public void setColors(ColorPalette colors)
	{
		this.colors = colors;
	}
	
}
