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

		frame.setTitle("Home");

		setLayout(
			new MigLayout("fill")
		);

		// HEADER

		var header = new JPanel();
		header.setLayout(
			new MigLayout("fill")
		);
		add(header, "north, wrap");
		
		var menuButton = new JButton(
			new SvgIcon("bars")
		);
		header.add(menuButton);

		var logoLabel = new JLabel("Tech4C");
		header.add(logoLabel, "push");

		var loginButton = new JButton(
			new SvgIcon("user")
		);
		header.add(loginButton);

		// TODO: dynamic cart item count
		var cartButton = new JButton(
			new SvgIcon("cart-shopping")
		);
		header.add(cartButton, "alignx right, wrap");

		// SEARCHBAR

		var searchBar = new JPanel();
		searchBar.setLayout(
			new MigLayout()
		);
		add(searchBar, "north");

		var searchField = new JTextField();
		searchBar.add(searchField, "growx, pushx");

		var searchButton = new JButton(
			new SvgIcon("magnifying-glass")
		);
		searchBar.add(searchButton);

		// BODY

		var body = new JPanel();
		body.setLayout(
			new MigLayout()
		);
		add(
			new JScrollPane(body),
			"center, grow"
		);
	}
}

