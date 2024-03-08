package model;

import javax.swing.*;

public class MFrame extends JFrame
{
	public MFrame(String title, int w, int h)
	{
		super(title);

		// here to allow dynamic layout checks
		setSize(w, h);
		// must be called after setSize() or pack()
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	public void setContent(JPanel p)
	{
		setContentPane(p);
		refresh();
	}
}

