package model;

import javax.swing.*;
import javax.imageio.*;

public class Gif extends JLabel
{
	public Gif(String path)
	{
		this(path, "Gif not avalable");
	}

	public Gif(String path, String alt)
	{
		super();

		try
		{
			var icon = new ImageIcon(
				getClass()
				.getClassLoader()
				.getResource(path)
			);

			icon.setImageObserver(this);
			setIcon(icon);
		}
		catch (Exception e)
		{
			setText(alt);
		}
	}
}

