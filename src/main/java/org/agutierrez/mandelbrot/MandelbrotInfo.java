//
// Tom Sawyer Software
// Copyright 2007 - 2013
// All rights reserved.
//
// www.tomsawyer.com
//

package org.agutierrez.mandelbrot;

import org.agutierrez.fractal.core.EscapeTimeInfo;

/**
 * This class just holds the information of a given iteration for the
 * mandelbrot set.
 * 
 * @author agutierrez
 * 
 */
public class MandelbrotInfo extends EscapeTimeInfo
{

	public double squaredRe;

	public double squaredIm;


	public MandelbrotInfo(int n, double squaredRe, double squaredIm)
	{
		this.n = n;
		this.squaredRe = squaredRe;
		this.squaredIm = squaredIm;
	}


	public double getSquaredRe()
	{
		return squaredRe;
	}


	public void setSquaredRe(double squaredRe)
	{
		this.squaredRe = squaredRe;
	}


	public double getSquaredIm()
	{
		return squaredIm;
	}


	public void setSquaredIm(double squaredIm)
	{
		this.squaredIm = squaredIm;
	}
}
