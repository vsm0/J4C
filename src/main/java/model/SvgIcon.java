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

//		setPaint(getThemeColor());
	}

	public SvgIcon(String name)
	{
		super(getName(name), w, h);

//		setPaint(getThemeColor());
	}

	public static void setDefaultRes(int _w, int _h)
	{
		w = _w;
		h = _h;
	}

	public static void setDefaultTheme(String _theme)
	{
		theme = _theme;
	}

	private static String getName(String name)
	{
		return "gfx/svg/" + name + ".svg";
	}

	private static Color getThemeColor()
	{
		if (theme.equals("light"))
			return Color.black;
		else if (theme.equals("dark"))
			return Color.white;

		return Color.red;
	}
}

