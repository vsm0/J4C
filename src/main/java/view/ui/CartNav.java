package view.ui;

import model.*;
import view.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartNav extends JPanel
{
	public CartNav(MFrame frame)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var backButton = new JButton(
			new SvgIcon("arrow-left")
		);
		backButton.addActionListener(
			e -> Load.queue(
				frame,
				Home.queue(frame)
			)
		);
		add(backButton, "push");
	}
}

