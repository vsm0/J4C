package model;

import controller.*;
import java.awt.*;
import javax.swing.*;

public class MFrame extends JFrame
{
	private Container[] layers;
	private JLayeredPane layerPane;
	private String preferredTitle;

	public MFrame(String title, int w, int h)
	{
		super(title);

		// here to allow dynamic layout checks
		setSize(w, h);
		// must be called after setSize() or pack()
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		layers = new Container[3];
		layerPane = getLayeredPane();
		layerPane.setLayout(
			new LayerLayout(layerPane, getSize())
		);
	}

	public void setPreferredTitle(String s)
	{
		preferredTitle = s;
	}

	public String getPreferredTitle()
	{
		return preferredTitle;
	}

	public void display()
	{
		toFront();
		requestFocus();
		setVisible(true);
	}

	public void refresh()
	{
		revalidate();
		repaint();
	}

	public void removeContent(int z)
	{
		if (z < 0 || z >= layers.length)
			return;

		var c = layers[z];

		if (c != null)
			layerPane.remove(c);
	}

	public Container getContent(int z)
	{
		if (z < 0 || z >= layers.length)
			return null;

		return layers[z];
	}

	public void setContent(Container c)
	{
		setContent(c, 0);
	}

	public void setContent(Container c, int z)
	{
		if (z < 0 || z >= layers.length)
			return;
		
		removeContent(z);

		if (z > 0)
			if (c instanceof JPanel)
				((JPanel) c).setOpaque(false);

		c.setSize(getSize());
		layers[z] = c;
		layerPane.add(c, Integer.valueOf(z));
	}
}

