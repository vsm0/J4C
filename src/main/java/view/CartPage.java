package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class CartPage extends JPanel
{
	private JLabel priceLabel;
	private int itemIndex;
	private ScrollPanel body;

	private CartPage(MFrame frame)
	{
		super();

		frame.setPreferredTitle("Cart");

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame);
		add(header, "north, wrap");

		var subhead = new CartNav(
			frame,
			() -> {
				Database.clearCart();
				body.removeAll();
				refresh();
			}
		);
		add(subhead, "north, wrap");

		body = new ScrollPanel();
		body.setLayout(
			new MigLayout("fill")
		);
		add(
			new JScrollPane(body),
			"grow"
		);

		var cart = Database.getCart();

		itemIndex = 1;

		cart.forEach(
			(id, item) -> {
				var entry = new CartEntry(
					item,
					itemIndex++ < cart.size()
				);
				entry.listen(
					() -> {
						Database.delCart(
							id,
							item.getQuantity()
						);

						body.remove(entry);
						refresh();
					}
				);

				body.add(
					entry,
					"growx, wrap"
				);
			}
		);

		var side = new ScrollPanel();
		side.setLayout(
			new MigLayout("fill")
		);
		add(
			new JScrollPane(side),
			"grow"
		);

		priceLabel = new JLabel();
		refreshPrice();
		side.add(priceLabel, "wrap");

		side.add(
			new JButton("Checkout")
		);
	}

	private void refresh()
	{
		refreshPrice();

		revalidate();
		repaint();
	}

	private void refreshPrice()
	{
		priceLabel.setText(
			"Total Price: $" + Database.getCart().getTotal()
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

