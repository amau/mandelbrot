//
// Tom Sawyer Software
// Copyright 2007 - 2013
// All rights reserved.
//
// www.tomsawyer.com
//

package org.agutierrez.fractal.image;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.agutierrez.fractal.core.EscapeTimeInfo;
import org.agutierrez.mandelbrot.MandelbrotInfo;

public class WikipediaPallete implements ColorPalette
{

	private int max;

	public WikipediaPallete(int offset, int max)

	{
		
		this.max=max;
		this.offset = offset;
		
		mapping = new Color[16];
		
		mapping[(0+offset)%16] = new Color(66, 30, 15);
		mapping[(1+offset)%16] = new Color(25, 7, 26);
		mapping[(2+offset)%16] = new Color(9, 1, 47);
		mapping[(3+offset)%16] = new Color(4, 4, 73);
		mapping[(4+offset)%16] = new Color(0, 7, 100);
		mapping[(5+offset)%16] = new Color(12, 44, 138);
		mapping[(6+offset)%16] = new Color(24, 82, 177);
		mapping[(7+offset)%16] = new Color(57, 125, 209);
		mapping[(8+offset)%16] = new Color(134, 181, 229);
		mapping[(9+offset)%16] = new Color(211, 236, 248);
		mapping[(10+offset)%16] = new Color(241, 233, 191);
		mapping[(11+offset)%16] = new Color(248, 201, 95);
		mapping[(12+offset)%16] = new Color(255, 170, 0);
		mapping[(13+offset)%16] = new Color(204, 128, 0);
		mapping[(14+offset)%16] = new Color(153, 87, 0);
		mapping[(15+offset)%16] = new Color(106, 52, 3);
	}


	@Override
	public Color getColor(EscapeTimeInfo i, boolean bands)
	{	
		if (i.getN() == max)
		{
			return Color.black;
		}
		else
		{
			if(bands)
			{	
				return mapping[i.getN()%16];
			}
			else
			{
				return getContinuosColor(i);
			}
		}
	}


	private Color getContinuosColor(EscapeTimeInfo i)
	{
		MandelbrotInfo info = (MandelbrotInfo)i;
		
		double abs = Math.sqrt(info.getSquaredRe() + info.getSquaredIm());
		double logAbs = Math.log(abs);
		double continuous = 1 + info.getN() - Math.log(logAbs) / Math.log(2.0);
		


		int a = (int) Math.floor(continuous);
					
		Color res = getMean(mapping[a%16], mapping[(a + 1)%16],1- (continuous-a));

		return res;
	}


	private Color getMean(Color one, Color two, double p)
	{
		int r = (int) Math.floor(p*one.getRed() + (1-p)*two.getRed()) ;
		int g = (int) Math.floor(p*one.getGreen() + (1-p)*two.getGreen()) ;
		int b = (int) Math.floor(p*one.getBlue() + (1-p)*two.getBlue()) ;
		
		return new Color(r, g, b);	
	}

	private Color[] mapping;

	private int offset;
	
	private Map<String, Integer> m = new HashMap<String, Integer>();
}
