package model;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

public class ScaledIcon extends ImageIcon
{
	public enum ScaleMode
	{
		FIT,
		EXPAND,
		STRETCH
	};

	public enum ScaleType
	{
		FAST(Image.SCALE_FAST),
		SMOOTH(Image.SCALE_SMOOTH);

		public final int type;

		private ScaleType(int type)
		{
			this.type = type;
		}
	};

	BufferedImage image;

	public ScaledIcon(String path)
	{
		super(path);

		try
		{
			image = ImageIO.read(
				getClass()
				.getClassLoader()
				.getResource(path)
			);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ImageIcon getScaled(int w, int h)
	{
		return getScaled(w, h, ScaleMode.FIT, ScaleType.SMOOTH);
	}

	public ImageIcon getScaled(int w, int h, ScaleMode mode, ScaleType type)
	{
		var res = getResolution(w, h, mode);

		return new ImageIcon(
			image.getScaledInstance(
				res.width,
				res.height,
				type.type
			)
		);
	}

	private Dimension getResolution(int w, int h, ScaleMode mode)
	{
		var width = image.getWidth();
		var height = image.getHeight();

		var wr = (double) w / width;
		var hr = (double) h / height;

		switch (mode) {
			case FIT -> {
				wr = Math.min(wr, hr);
				hr = wr;
			}
			case EXPAND -> {
				wr = Math.max(wr, hr);
				hr = wr;
			}
			default -> {
				width = w;
				height = h;

			}
		};

		width = (int) ((double) width * wr);
		height = (int) ((double) height * hr);
		
		return new Dimension(width, height);
	}
}

