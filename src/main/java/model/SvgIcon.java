package model;

import com.formdev.flatlaf.extras.*;

public class SvgIcon extends FlatSVGIcon
{
	private static int w = 20;
	private static int h = 20;

	public SvgIcon(String name, int w, int h)
	{
		super(getName(name), w, h);
	}

	public SvgIcon(String name)
	{
		super(getName(name), w, h);
	}

	public static void setDefaultRes(int _w, int _h)
	{
		w = _w;
		h = _h;
	}

	private static String getName(String name)
	{
		return "gfx/svg/" + name + ".svg";
	}
}

