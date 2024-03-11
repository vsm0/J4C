package model;

import com.formdev.flatlaf.extras.*;
import java.awt.*;

public class SvgIcon extends FlatSVGIcon
{
	private static int w = 20;
	private static int h = 20;
	private static String theme = "light";

	public SvgIcon(String name, int w, int h)
	{
		super(getName(name), w, h);
	}

	public SvgIcon(String name)
	{
		super(getName(name), w, h);
	}

	private static String getName(String name)
	{
		return "gfx/svg/" + name + ".svg";
	}
}

