package view.ui;

import model.*;
import view.*;
import net.miginfocom.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Order extends JPanel
{
	protected Delivery order;
	public Order(Delivery d, TrackerPage page)
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

		addMouseListener(
			new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					var p = page.infoPanel;
					var info = new JPanel();
					info.setLayout(new MigLayout("fill"));
					label(p, info, "ID", d.getId());
					label(p, info, "Address", d.getAddress());
					label(p, info, "Recipiant", d.getReceiver());
					label(p, info, "Status", d.getStatus());
					label(p, info, "Items", d.getItems());
					label(p, info, "Price", "$" + d.getPrice());
					label(p, info, "Date received", d.getDate());
					page.infoPanel.removeAll();
					page.infoPanel.add(info, "grow");
					page.infoPanel.revalidate();
					page.infoPanel.repaint();
				}
			}
		);
	}

	private void label(JPanel parent, JPanel panel, String name, String value)
	{
		panel.add(
			new Paragraph(
				parent,
				Paragraph.LEFT,
				name + ": " + value
			),
			"label, growx, wrap"
		);
	}

	public abstract void refresh();
}

