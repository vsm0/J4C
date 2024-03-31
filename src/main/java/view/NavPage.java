package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class NavPage extends Page
{
	private static String title = "Nav";
	private Runnable onRefresh;

	public NavPage(MFrame frame)
	{
		super(title);

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame, title);
		add(header, "north, wrap");

		var trackerButton = new JButton("Tracker");
		trackerButton.addActionListener(
			e -> LoadingPage.queue(
				frame,
				TrackerPage.queue(frame)
			)
		);
		add(trackerButton);

		onRefresh = () -> {
			header.refresh();
		};
	}

	public void refresh()
	{
		onRefresh.run();
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = getPage(title);
			if (page == null)
				page = new NavPage(frame);
			PageLoader.start(frame, page, 0);
		};
	}
}

