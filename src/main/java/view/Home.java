package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Home extends JPanel
{
	private Home(MFrame frame)
	{
		super();

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

		frame.setTitle("Home");
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = new Home(frame);
			PageLoader.start(page, frame, 0);
		};
	}
}

