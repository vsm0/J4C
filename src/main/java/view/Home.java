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

		SvgIcon.setDefaultTheme("dark");

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

		var body = new ScrollablePanel();
		body.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
		body.setScrollableHeight(ScrollablePanel.ScrollableSizeHint.STRETCH);
		add(
			new JScrollPane(body),
			"center, grow"
		);

		// need to add before setLayout if using DynamicGridLayout
		for (int i = 0; i < 40; ++i)
			body.add(
				new JLabel("Example " + i)
			);

		var bodyLayout = new DynamicGridLayout(frame, body);
		bodyLayout.constrain(3);
		bodyLayout.resize();

		body.setLayout(bodyLayout);

	}
}

