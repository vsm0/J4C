package view.ui;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartEntry extends JPanel
{
	public CartEntry(CartItem item)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var nameLabel = new JLabel(
			item.getName()
		);
		nameLabel.setFont(
			UIManager.getFont("h3.font")
		);
		add(nameLabel, "north");
	}
}

