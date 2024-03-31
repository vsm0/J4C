package model;

import controller.*;
import com.formdev.flatlaf.extras.*;
import javax.swing.*;

public class Svg extends JLabel
{
	public Svg(String path)
	{
		this(path, 20, 20);
	}

	public Svg(String path, int w, int h)
	{
		super();

		var name = "gfx/svg/" + path + ".svg";

		var tmp = new FlatSVGIcon(name);

		var res = ImageScaler.scale(
			tmp.getWidth(),
			tmp.getHeight(),
			w,
			h,
			ImageScaler.ScaleMode.FIT
		);

		setIcon(
			new FlatSVGIcon(
				name,
				res.width,
				res.height
			)
		);
	}
}

