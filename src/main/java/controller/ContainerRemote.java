package controller;

import java.awt.*;

public class ContainerRemote
{
	public static void setEnabled(
		Container container,
		boolean enabled
	)
	{
		for (Component c : container.getComponents())
		{
			c.setEnabled(enabled);
			if (c instanceof Container)
				setEnabled(
					(Container) c,
					enabled
				);
		}
	}

	public static void enable(Container container)
	{
		setEnabled(container, true);
	}

	public static void disable(Container container)
	{
		setEnabled(container, false);
	}
}

