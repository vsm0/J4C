package controller;

import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DynamicGridLayout extends GridLayout
{
	private MFrame frame;
	private JPanel panel;
	private int maxColumns = 10;

	public DynamicGridLayout(MFrame frame, JPanel panel)
	{
		super(0, 1);

		this.frame = frame;
		this.panel = panel;

		panel.addComponentListener(
			new ComponentAdapter()
			{
				public void componentResized(ComponentEvent e)
				{
					resize();
				}
			}
		);
	}

	public void constrain(int maxColumns)
	{
		this.maxColumns = maxColumns;
	}

	private void resize()
	{
		var columnCount = getColumnCount();
		panel.setLayout(
			new GridLayout(0, columnCount)
		);
	}
	
	private int getColumnCount()
	{
		var frameWidth = frame.getWidth();
		var panelWidth = 0;

		for (Component c : panel.getComponents())
			panelWidth = Math.max(panelWidth, c.getWidth());
		
		if (panelWidth == 0 || frameWidth < panelWidth)
			return 1;

		return clamp(frameWidth / panelWidth, 1, maxColumns);
	}

	private int clamp(int val, int min, int max)
	{
		return Math.max(min, Math.min(val, max));
	}
}

