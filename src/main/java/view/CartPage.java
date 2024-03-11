package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartPage extends JPanel
{
	private CartPage(MFrame frame)
	{
		super();

		frame.setPreferredTitle("Cart");

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame);
		add(header, "north, wrap");

		var subhead = new CartNav(frame);
		add(subhead, "north, wrap");
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = new CartPage(frame);
			PageLoader.start(page, frame, 0);
		};
	}
}

