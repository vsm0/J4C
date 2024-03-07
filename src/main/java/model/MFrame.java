package model;

import javax.swing.*;

public class MFrame extends JFrame
{
	public MFrame(String title)
	{
		super(title);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void display()
	{
		toFront();
		requestFocus();
		setVisible();
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

