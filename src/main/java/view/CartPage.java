package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import java.awt.*;
import javax.swing.*;

public class CartPage extends Page
{
	private static String title = "Cart";
	private static Runnable onRefresh;
	private int itemIndex;
	private JPanel body;

	private CartPage(MFrame frame)
	{
		super(title);

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu(frame, title);
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

		var priceLabel = new JLabel();
		side.add(priceLabel, "wrap");

		side.add(
			new JButton("Checkout")
		);

		onRefresh = () -> {
			priceLabel.setText(
				"Total Price: $"
				+ Database
				.getCart()
				.getTotal()
			);

			for (Component c : body.getComponents())
				if (c instanceof CartEntry)
					((CartEntry) c).refresh();

			body.revalidate();
			body.repaint();
		};
	}

	public void refresh()
	{
		onRefresh.run();
	}

	public static Runnable queue(MFrame frame)
	{
		return () -> {
			var page = getPage(title);
			if (page == null)
				page = new CartPage(frame);
			setNew(page);
			PageLoader.start(frame, page, 0);
		};
	}
}

