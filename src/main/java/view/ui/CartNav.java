package view.ui;

import model.*;
import view.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartNav extends JPanel
{
	public CartNav(MFrame frame, Runnable remover)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var backButton = new JButton(
			new Svg("arrow-left").getIcon()
		);
		backButton.addActionListener(
			e -> LoadingPage.queue(
				frame,
				() -> PageLoader.start(frame, CartPage.backPage, 0)
			)
		);
		add(backButton, "push");

		var clearButton = new JButton(
			new Svg("trash").getIcon()
		);
		clearButton.addActionListener(
			e -> remover.run()
		);
		add(clearButton);
	}
}

