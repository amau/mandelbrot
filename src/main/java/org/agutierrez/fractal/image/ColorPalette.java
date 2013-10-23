
package org.agutierrez.fractal.image;

import java.awt.Color;

import org.agutierrez.fractal.core.EscapeTimeInfo;

public interface ColorPalette
{
	public Color getColor(EscapeTimeInfo i, boolean bands);
}
