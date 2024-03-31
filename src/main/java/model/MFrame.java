package model;

import controller.*;
import java.awt.*;
import javax.swing.*;

public class MFrame extends JFrame
{
	private Page[] layers;
	private JLayeredPane layerPane;

	public MFrame(String title, int w, int h)
	{
		super(title);

		// here to allow dynamic layout checks
		setSize(w, h);
		// must be called after setSize() or pack()
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		layers = new Page[3];
		layerPane = getLayeredPane();
		layerPane.setLayout(
			new LayerLayout(layerPane, getSize())
		);
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

		var p = layers[z];

		if (p != null)
			layerPane.remove(p);
	}

	public Page getContent(int z)
	{
		if (z < 0 || z >= layers.length)
			return null;

		return layers[z];
	}

	public void setContent(Page p)
	{
		setContent(p, 0);
	}

	public void setContent(Page p, int z)
	{
		if (z < 0 || z >= layers.length)
			return;
		
		removeContent(z);

		if (z > 0)
			p.setOpaque(false);

		p.setSize(getSize());
		layers[z] = p;
		layerPane.add(p, Integer.valueOf(z));
	}
}

