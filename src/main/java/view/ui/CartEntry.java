package view.ui;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartEntry extends JPanel
{
	private Runnable onRefresh;
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

		var likeButton = new LikeButton(
			Database.getProduct(
				item.getId()
			)
		);
		add(likeButton, "growx, pushx");

		trashButton = new JButton(
			new Svg("trash").getIcon()
		);
		add(trashButton, "wrap");

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

		onRefresh = () -> {
			likeButton.refresh();
		};
	}

	public void refresh()
	{
		onRefresh.run();
	}

	public void listen(Runnable remover)
	{
		trashButton.addActionListener(
			e -> remover.run()
		);
	}
}

