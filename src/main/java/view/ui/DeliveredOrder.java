package view.ui;

import model.*;
import view.*;
import javax.swing.*;

public class DeliveredOrder extends Order
{
	private Runnable onRefresh;
	public DeliveredOrder(Delivery d, TrackerPage page)
	{
		super(d, page);

		d.lockDate();
		var sd = d.getDate();
		add(new JLabel("Delivered: " + sd), "label, wrap");

		var receiveButton = new JButton("Receive");
		receiveButton.addActionListener(
			e -> {
				page.deliveredList.remove(this);
				page.receivedList.add(
					new ReceivedOrder(d, page),
					"growx, wrap"
				);
			}
		);
		add(receiveButton);
	}

	public void refresh()
	{
		onRefresh.run();
	}
}

