package view.ui;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartEntry extends JPanel
{
	private JButton trashButton;

	public CartEntry(CartItem item, boolean hasNextEntry)
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
		var quantity = item.getQuantity();

		add(
			new JLabel("Quantity: " + quantity),
			"wrap"
		);

		add(
			new JLabel("Unit price: $" + price),
			"wrap"
		);

		add(
			new JLabel("Subtotal: $" + quantity * price),
			"wrap"
		);

		trashButton = new JButton(
			new SvgIcon("trash")
		);

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

		if (hasNextEntry)
			add(
				new JSeparator(JSeparator.HORIZONTAL),
				"growx"
			);
	}

	public void listen(Runnable remover)
	{
		trashButton.addActionListener(
			e -> remover.run()
		);
	}
}

