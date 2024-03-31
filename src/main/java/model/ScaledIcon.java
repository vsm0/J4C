package model;

import controller.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

public class ScaledIcon extends ImageIcon
{
	private BufferedImage image;

	public ScaledIcon(String path) throws Exception
	{
		super();

		image = ImageIO.read(
			getClass()
			.getClassLoader()
			.getResource(path)
		);

		setImage(image);
	}

	public ImageIcon getScaled(int w, int h)
	{
		return getScaled(
			w,
			h,
			ImageScaler.ScaleMode.FIT
		);
	}

	public ImageIcon getScaled(
		int w,
		int h,
		ImageScaler.ScaleMode mode
	)
	{
		var res = ImageScaler.scale(
			image.getWidth(),
			image.getHeight(),
			w,
			h,
			mode
		);

		var newImage = new BufferedImage(
			res.width,
			res.height,
			BufferedImage.TYPE_INT_RGB
		);

		var graphics = newImage.createGraphics();

		graphics.drawImage(
			image,
			0,
			0,
			res.width,
			res.height,
			null
		);

		graphics.dispose();

		return new ImageIcon(newImage);
	}
}

