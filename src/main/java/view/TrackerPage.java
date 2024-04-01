package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class TrackerPage extends Page
{
	private static String title = "Tracker";

	public TrackerPage(MFrame frame)
	{
		super(title);

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame, title);
		add(header, "north");

		var tabPane = new JTabbedPane();
		add(tabPane, "grow");

		var transitList = new JPanel();
		transitList.setLayout(new MigLayout("fill"));
		Database.getTracker().forEach(
			(id, item) -> {
				if (item.isInTransit())
					transitList.add(
						new TransitOrder(item),
						"growx, wrap"
					);
			}
		);
		tabPane.addTab("In-Transit", new JScrollPane(transitList));

		var deliveredList = new JPanel();
		deliveredList.setLayout(
			new MigLayout("fill")
		);
		Database.getTracker().forEach(
			(id, item) -> {
				if (item.isDelivered())
					deliveredList.add(
						new DeliveredOrder(item),
						"growx, wrap"
					);
			}
		);
		tabPane.addTab("Delivered", new JScrollPane(deliveredList));

		var receivedList = new JPanel();
		receivedList.setLayout(
			new MigLayout("fill")
		);
		Database.getTracker().forEach(
			(id, item) -> {
				if (item.isReceived())
					receivedList.add(
						new ReceivedOrder(item),
						"growx, wrap"
					);
			}
		);
		tabPane.addTab("Received", new JScrollPane(receivedList));

		var infoPanel = new JPanel();
		add(infoPanel, "east");

		infoPanel.add(
			new JLabel("Click an item to learn more...")
		);
	}

	public void refresh()
	{
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = getPage(title);
			if (page == null)
				page = new TrackerPage(frame);
			setOld(page);
			PageLoader.start(frame, page, 0);
		};
	}
}

