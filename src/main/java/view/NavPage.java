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
			new MigLayout("fill, align center center")
		);

		var header = new NavMenu(frame, title);
		add(header, "north, wrap");

		addNav(frame, "Home", HomePage.queue(frame));
		addNav(frame, "Cart", CartPage.queue(frame));
		addNav(frame, "Tracker", TrackerPage.queue(frame));
		addNav(frame, "Account", () -> {});
		addNav(frame, "Settings", () -> {});
		//if logged in: addNav(frame, "Sign out", () -> {});

		onRefresh = () -> {
			header.refresh();
		};
	}
	
	private void addNav(MFrame frame, String title, Runnable nextPage)
	{
		var button = new JButton(title);
		button.addActionListener(
			e -> LoadingPage.queue(frame, nextPage)
		);
		var wrapper = new JPanel();
		wrapper.add(button);
		add(wrapper, "growx, wrap");
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

