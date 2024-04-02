package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import java.awt.*;
import javax.swing.*;

public class TrackerPage extends Page
{
	private static String title = "Tracker";
	public JPanel transitList, deliveredList, receivedList, infoPanel;
	public Timer timer;
	public static TrackerPage ctx;
	private Runnable onRefresh;
	public TrackerPage(MFrame frame)
	{
		super(title);
		ctx = this;

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame, title);
		add(header, "north");

		var tabPane = new JTabbedPane();
		add(tabPane, "grow");

		transitList = new JPanel();
		transitList.setLayout(new MigLayout("fill"));
		Database.getTracker().forEach(
			(id, item) -> {
				if (item.isInTransit())
					transitList.add(
						new TransitOrder(item, this),
						"growx, wrap"
					);
			}
		);
		tabPane.addTab("In-Transit", new JScrollPane(transitList));

		deliveredList = new JPanel();
		deliveredList.setLayout(
			new MigLayout("fill")
		);
		Database.getTracker().forEach(
			(id, item) -> {
				if (item.isDelivered())
					deliveredList.add(
						new DeliveredOrder(item, this),
						"growx, wrap"
					);
			}
		);
		tabPane.addTab("Delivered", new JScrollPane(deliveredList));

		receivedList = new JPanel();
		receivedList.setLayout(
			new MigLayout("fill")
		);
		Database.getTracker().forEach(
			(id, item) -> {
				if (item.isReceived())
					receivedList.add(
						new ReceivedOrder(item, this),
						"growx, wrap"
					);
			}
		);
		tabPane.addTab("Received", new JScrollPane(receivedList));

		infoPanel = new JPanel();
		add(infoPanel, "east");

		infoPanel.add(
			new JLabel("Click an item to learn more...")
		);

		timer = new Timer(500, e -> sync());
		timer.start();

		onRefresh = () -> {
			header.refresh();
		};
	}

	private void sync()
	{
		for (Component c : transitList.getComponents())
			if (c instanceof Order)
				((Order) c).refresh();
		transitList.revalidate();
		transitList.repaint();
		receivedList.revalidate();
		receivedList.repaint();
		deliveredList.revalidate();
		deliveredList.repaint();
	}

	public void refresh()
	{
		sync();
		onRefresh.run();
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

