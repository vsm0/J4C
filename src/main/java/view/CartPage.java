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

		var body = new ScrollPanel();
		body.setLayout(
			new MigLayout("fill")
		);
		add(
			new JScrollPane(body),
			"grow"
		);

		Database
		.getCart()
		.forEach(
			(id, item) -> body.add(
				new CartEntry(item),
				"growx, wrap"
			)
		);
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = new CartPage(frame);
			PageLoader.start(page, frame, 0);
		};
	}
}
