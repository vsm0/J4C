package controller;

import java.awt.*;
import javax.swing.*;

public class LayerLayout implements LayoutManager
{
	private Container target;
	private static Dimension preferredSize;

	public LayerLayout(Container target, Dimension d)
	{
		this.target = target;
		preferredSize = d;
	}

	public void addLayoutComponent(String name, Component c)
	{
	}

	public void layoutContainer(Container container)
	{
		for (Component c : container.getComponents())
			c.setBounds(
				new Rectangle(
					0,
					0,
					target.getWidth(),
					target.getHeight()
				)
			);
	}

	public Dimension minimumLayoutSize(Container parent)
	{
		return parent.getPreferredSize();
	}

	public Dimension preferredLayoutSize(Container parent)
	{
		return preferredSize;
	}

	public void removeLayoutComponent(Component c)
	{
	}
}

