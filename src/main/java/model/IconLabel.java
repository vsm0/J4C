package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IconLabel extends JLabel
{
	private ScaledIcon icon;
	private Container parent;
	
	public IconLabel(Container parent, String path)
	{
		super();

		this.parent = parent;

		icon = new ScaledIcon(path);

		addComponentListener(
			new ComponentAdapter()
			{
				public void componentResized(ComponentEvent e)
				{
					resize();
				}
			}
		);

		resize();
	}

	private void resize()
	{
		var res = parent.getPreferredSize();

		setIcon(
			icon.getScaled(
				res.width,
				res.height,
				ScaledIcon.ScaleMode.EXPAND,
				ScaledIcon.ScaleType.SMOOTH
			)
		);
	}
}

