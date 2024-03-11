package view.ui;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CategoryGrid extends ScrollPanel
{
	public CategoryGrid(MFrame frame)
	{
		super();

		var layout = new DynamicGridLayout(frame, this);
		setLayout(layout);

		addCategory(
			"Desktops",
			"desktop",
			()->{}
		);

		addCategory(
			"Laptops",
			"laptop",
			()->{}
		);

		addCategory(
			"Tablets",
			"tablet-screen-button",
			()->{}
		);

		addCategory(
			"Phones",
			"mobile-retro",
			()->{}
		);
	}

	private void addCategory(String name, String type, Runnable target)
	{
		var panel = new JPanel();
		panel.setLayout(
			new MigLayout("debug")
		);

		panel.add(
			new Svg(
				type,
				100,
				100
			)
		);

		panel.add(
			new JLabel(
				name,
				JLabel.CENTER
			),
			"label, south"
		);

		add(panel);
	}
}

