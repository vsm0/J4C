package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Cart extends JPanel
{
	private Cart(MFrame frame)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame);
		add(header, "north, wrap");

		var subhead = new CartNav(frame);
		add(subhead, "north, wrap");

		frame.setTitle("Cart");
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = new Cart(frame);
			PageLoader.start(page, frame, 0);
		};
	}
}

