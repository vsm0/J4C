package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class HomePage extends JPanel
{
	private HomePage(MFrame frame)
	{
		super();

		frame.setPreferredTitle("Home");

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame);
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

		var categoryGrid = new CategoryGrid(frame);
		body.add(
			new JScrollPane(categoryGrid),
			"grow, wrap"
		);
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = new HomePage(frame);
			PageLoader.start(page, frame, 0);
		};
	}
}

