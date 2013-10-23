package org.agutierrez.fractal.core;

public abstract class AbstractEscapeTimeFractal implements EscapeTime
{
	public abstract EscapeTimeInfo escapeTime(double re, double im);
}