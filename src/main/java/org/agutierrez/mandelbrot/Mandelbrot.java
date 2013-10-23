package org.agutierrez.mandelbrot;

import org.agutierrez.fractal.core.AbstractEscapeTimeFractal;
import org.agutierrez.fractal.core.EscapeTimeInfo;

public class Mandelbrot extends AbstractEscapeTimeFractal
{

	private int maxIteration;
	private double escapeRadius;

	public Mandelbrot(int maxIteration, double escapeRadius)
	{
		this.maxIteration =  maxIteration;
		this.escapeRadius = escapeRadius;
	}

	public EscapeTimeInfo escapeTime(double re0, double im0)
	{
		double Zr = 0;
		double Zi = 0;
	    double Tr = 0;
	    double Ti = 0;
	    int n = 0;
		for(; (Tr+Ti) <= escapeRadius && n < maxIteration;++n)
		{
			Zi = 2 * Zr * Zi + im0;
			Zr = Tr - Ti + re0;
		    Tr = Zr * Zr ;
		    Ti = Zi * Zi;
		}
		
		
		return new MandelbrotInfo(n,Tr,Ti);
	}
	
}