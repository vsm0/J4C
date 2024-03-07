package model;

import javax.swing.*;

public class MFrame extends JFrame
{
	public MFrame(String title)
	{
		super(title);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void display()
	{
		// must be called after setSize() or pack()
		setLocationRelativeTo(null);

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

