package view;

import model.*;
import vendor.model.*;
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
		cartButton.setText("0");
		header.add(cartButton, "wrap");

		// SEARCHBAR

		var searchBar = new JPanel();
		searchBar.setLayout(
			new MigLayout("fill")
		);
		add(searchBar, "north, wrap");

		var searchField = new JTextField();
		searchBar.add(searchField, "growx, push");

		var searchButton = new JButton(
			new SvgIcon("magnifying-glass")
		);
		searchBar.add(searchButton);

		// BODY

		var body = new ScrollablePanel();
		body.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
		body.setScrollableHeight(ScrollablePanel.ScrollableSizeHint.STRETCH);
		body.setLayout(
			new MigLayout("fill")
		);
		add(
			new JScrollPane(body),
			"grow"
		);

		var banner = new JPanel();
		banner.setLayout(
			new MigLayout(
				"debug, fill"
			)
		);
		body.add(banner, "growx, wrap");

		var quote = new Paragraph(
			banner,
			Paragraph.CENTER,
			"Shop here. Now."
		);
		banner.add(quote, "growx, wrap");

		var subquote = new Paragraph(
			banner,
			Paragraph.CENTER,
			"Tech4C is the world's #1 gadget retail service, bringing you the best value for the best price since 2024."
		);
		banner.add(subquote, "growx, wrap");

		var tip = new Paragraph(
			banner,
			Paragraph.CENTER,
			"Please sign-in for the best experience."
		);
		banner.add(tip, "growx, wrap");

		var loginButton2 = new JButton("Login");
		banner.add(loginButton2, "al center, split 2");

		var registerButton = new JButton("Register");
		banner.add(registerButton);
	}
}

