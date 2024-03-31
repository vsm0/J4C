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

		var pendingList = new JPanel();
		pendingList.setLayout(new MigLayout("fill"));
		for (int i = 0; i < 20; i++)
			pendingList.add(
			//	new PendingPackageEntry(),
				new PackageEntry(),
				"growx, wrap"
			);
		tabPane.addTab("Pending", new JScrollPane(pendingList));

		var readyList = new JPanel();
		readyList.setLayout(
			new MigLayout("fill")
		);
		for (int i = 0; i < 8; i++)
			readyList.add(
			//	new ReadyPackageEntry(),
				new PackageEntry(),
				"growx, wrap"
			);
		tabPane.addTab("Arrived", new JScrollPane(readyList));

		var completeList = new JPanel();
		completeList.setLayout(
			new MigLayout("fill")
		);
		for (int i = 0; i < 10; i++)
			completeList.add(
			//	new CompletePackageEntry(),
				new PackageEntry(),
				"growx, wrap"
			);
		tabPane.addTab("Completed", new JScrollPane(completeList));

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
			setNew(page);
			PageLoader.start(frame, page, 0);
		};
	}
}

