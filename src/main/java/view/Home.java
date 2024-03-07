package view;

import model.*;
import net.miginfocom.swing.*;
import java.awt.*;
import javax.swing.*;

public class Home extends JPanel
{
	public Home(MFrame frame)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		// HEADER START

		var header = new JPanel();
		header.setLayout(
			new MigLayout("debug, fill")
		);
		add(header, "north, wrap");
		
		var menuButton = new JButton("•••");
		header.add(menuButton);

		var logoLabel = new JLabel("Tech4C");
		header.add(logoLabel, "push, gapleft unrel");

		var loginButton = new JButton("Login");
		header.add(loginButton);

		// TODO: dynamic cart item count
		var cartButton = new JButton("Cart (0)");
		header.add(cartButton, "alignx right, wrap");

		// HEADER END
		// SEARCHBAR START

		var searchBar = new JPanel();
		searchBar.setLayout(
			new MigLayout("debug")
		);
		add(searchBar, "north");

		var searchField = new JTextField();
		searchBar.add(searchField, "growx, pushx");

		var searchButton = new JButton("Search");
		searchBar.add(searchButton);

		// SEARCHBAR END
		// BODY START

		var body = new JPanel();
		body.setLayout(
			new MigLayout()
		);
		add(
			new JScrollPane(body),
			"center, grow"
		);
		// BODY END
	}
}

