package view.ui;

import model.*;
import controller.*;
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

		var price = item.getPrice();

		add(
			new JLabel("Unit price: $" + price)
		);

		var trashButton = new JButton(
			new SvgIcon("trash")
		);
		trashButton.addActionListener(
			e -> {}
		);
		add(trashButton);
/*
		var stock = Database
			.getInventory()
			.get(item.getId())
			.getStock();*/
/*
		var spinner = new JSpinner(
			new SpinnerNumberModel(0, 0, stock, 1)
		);
		add(spinner);
		*/
	}
}

