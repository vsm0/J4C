package model;

import javax.swing.*;
import javax.imageio.*;

public class Img extends JLabel
{
	public Img(String path, int w, int h)
	{
		this(path, "Image Unavailable", w, h);
	}

	public Img(String path, String alt, int w, int h)
	{
		super();

		try
		{
			var icon = new ScaledIcon(path)
					.getScaled(w, h);

			icon.setImageObserver(this);

			setIcon(icon);
		}
		catch (Exception e)
		{
			e.printStackTrace();

			setText(alt);
		}
	}
}

