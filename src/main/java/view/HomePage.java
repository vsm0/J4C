package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import java.awt.*;
import javax.swing.*;

public class HomePage extends Page
{
	private static String title = "Home";
	private static Runnable onRefresh;

	private HomePage(MFrame frame)
	{
		super(title);

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame, title);
		add(header, "north, wrap");

		var searchBar = new SearchBar();
		add(searchBar, "north, wrap");

		var body = new ScrollPanel();
		body.setLayout(
			new MigLayout("fill")
		);
		add(
			new JScrollPane(body),
			"grow"
		);

		var banner = new Banner();
		body.add(banner, "growx, wrap");

		var itemSection = new JLabel("All Items");
		itemSection.setFont(
			UIManager.getFont("h2.font")
		);
		body.add(
			itemSection,
			"gapy 15, wrap"
		);

		Database
		.getInventory()
		.forEach(
			(id, product) -> body.add(
				new BrowseEntry(
					product,
					header
				),
				"growx, wrap"
			)
		);

		onRefresh = () -> {
			header.refresh();
			for (Component c : body.getComponents())
				if (c instanceof BrowseEntry)
					((BrowseEntry) c).refresh();
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
				page = new HomePage(frame);
			setNew(page);
			PageLoader.start(frame, page, 0);
		};
	}
}

