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
			new SvgIcon("arrow-left")
		);
		backButton.addActionListener(
			e -> LoadingPage.queue(
				frame,
				HomePage.queue(frame)
			)
		);
		add(backButton, "push");

		var clearButton = new JButton(
			new SvgIcon("trash")
		);
		clearButton.addActionListener(
			e -> remover.run()
		);
		add(clearButton);
	}
}

