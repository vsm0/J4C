package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Cart extends JPanel
{
	private static MFrame frame;

	private Cart()
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu();
		add(header, "north, wrap");

		frame.setTitle("Cart");
	}

	public static void queue(MFrame _frame)
	{
		_frame = frame;

		PageLoader.invokeLater(
			() -> {
				var page = new Cart();
				PageLoader.start(page, frame, 0);
			}
		);
	}
}

