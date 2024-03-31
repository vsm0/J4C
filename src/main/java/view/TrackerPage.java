package view;

import model.*;
import view.ui.*;
import controller.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TrackerPage extends Page
{
	private static String title = "Tracker";

	public TrackerPage(MFrame frame)
	{
		super(title);

		setLayout(
			new GridLayout(1, 2)
		);

		// Left section: List of packages sorted by delivery time
		var packageListScrollPane = new JScrollPane();
//		JTable packageListTable = new JTable(); // You can use a custom TableModel to sort the packages by delivery time
		var packageListTable = new JPanel();
		packageListScrollPane.setViewportView(packageListTable);
		add(packageListScrollPane);

		packageListTable.setLayout(
			new BoxLayout(
				packageListTable,
				BoxLayout.Y_AXIS
			)
		);
		for (int i = 0; i < 20; i++)
			packageListTable.add(
				new PackageEntry()
			);

		// Right section: Info side panel
		var infoSidePanel = new JPanel();
		infoSidePanel.setLayout(new BorderLayout());

		// Add labels and text fields to display package details (e.g. items, price, address)
		var itemLabel = new JLabel("Package Info:");
		itemLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		infoSidePanel.add(itemLabel, BorderLayout.PAGE_START);

		var meta = new PackageMetadata();
		infoSidePanel.add(meta);

		add(infoSidePanel);
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

