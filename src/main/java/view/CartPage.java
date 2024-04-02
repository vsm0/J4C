package view;

import model.*;
import view.ui.*;
import controller.*;
import net.miginfocom.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class CartPage extends Page
{
	private static String title = "Cart";
	private static Runnable onRefresh;
	private int itemIndex;
	private JPanel body;
	private String items;
	public static Page backPage;

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

		var checkBtn = new JButton("Checkout");
		checkBtn.addActionListener(
			e -> {
				if (cart.getSize() == 0)
					return;
				var uid = UUID.randomUUID().toString().substring(0, 10);
				items = "\n";
				cart.forEach(
					(id, item) -> {
						items += item.getName() + "\n";
					}
				);
				var price = cart.getTotal();
				var address = "Dolphin Hotel #1408";
				var user = "Guest #" + UUID.randomUUID().toString().substring(0, 10);
				var status = Delivery.Status.TRANSIT;
				var time = System.currentTimeMillis();
				var duration = 60 * 1000;
				var tracker = Database.getTracker();
				tracker.put(
					uid,
					new Delivery(
						uid,
						items,
						price,
						address,
						user,
						status,
						time,
						duration
					)
				);
				var tp = LoadingPage.getPage("Tracker");
				if (tp != null)
				{
					var t = TrackerPage.ctx;
					t.transitList.add(
						new TransitOrder(
							tracker.get(uid),
							t
						),
						"growx, wrap"
					);
				}

				Database.clearCart();
				body.removeAll();
				refresh();
				LoadingPage.queue(
					frame,
					HomePage.queue(frame)
				);
			}
		);
		side.add(checkBtn, "growx");

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
			side.revalidate();
			side.repaint();
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
			backPage = getOld();
			setOld(page);
			PageLoader.start(frame, page, 0);
		};
	}
}

