package view.ui;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class SearchBar extends JPanel
{
	public SearchBar()
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var searchField = new JTextField();
		add(searchField, "growx, push");

		var searchButton = new JButton(
			new Svg("magnifying-glass").getIcon()
		);
		add(searchButton);
	}
}

