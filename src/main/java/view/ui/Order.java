package view.ui;

import model.*;
import net.miginfocom.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Order extends JPanel
{
	protected Delivery order;
	public Order(Delivery d)
	{
		super();

		order = d;

		setLayout(new MigLayout("fill"));

		var header = new JPanel();
		header.setLayout(new MigLayout("fill"));
		var headLabel = new JLabel(d.getId(), FlowLayout.LEFT);
		headLabel.setFont(
			UIManager.getFont("h3.font")
		);
		header.add(headLabel, "label, push");
		add(header, "growx, north");
	}

	protected void listen(Runnable runner)
	{
		addMouseListener(
			new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					runner.run();
				}
			}
		);
	}

	public abstract void refresh();
}

