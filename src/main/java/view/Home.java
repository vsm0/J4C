package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Home extends JPanel
{
	private static MFrame frame;

	private Home()
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu();
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

	public static void queue(MFrame _frame)
	{
		frame = _frame;

		PageLoader.invokeLater(
			() -> {
				var page = new Home();
				PageLoader.start(page, frame, 0);
			}
		);
	}
}

