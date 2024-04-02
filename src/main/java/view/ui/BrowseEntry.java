package view.ui;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class BrowseEntry extends JPanel
{
	private Runnable onRefresh;

	public BrowseEntry(Product p, NavMenu nav)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var nameLabel = new JLabel(
			p.getName()
		);
		nameLabel.setFont(
			UIManager.getFont("h3.font")
		);
		add(
			nameLabel,
			"label, north"
		);

		var svg = switch (p.getCategory())
		{
			case "desktop" -> "desktop";
			case "laptop" -> "laptop";
			case "tablet" -> "tablet-screen-button";
			case "mobile" -> "mobile-retro";
			default -> "clipboard-question";
		};

		add(
			new Svg(
				svg,
				50,
				50
			),
			"west"
		);

		var priceLabel = new JLabel(
			"$" + p.getNewPrice(),
			JLabel.CENTER
		);
		priceLabel.setFont(
			UIManager.getFont("large.font")
		);
		add(
			priceLabel,
			"label, growx, pushx"
		);

		var likeButton = new LikeButton(p);
		add(likeButton);

		var addButton = new JButton(
			new Svg("cart-plus").getIcon()
		);
		addButton.addActionListener(
			e -> {
				Database.addCart(p, 1);

				nav.refresh();
			}
		);
		add(addButton);

		onRefresh = () -> {
			likeButton.refresh();
			nav.refresh();
		};
	}

	public void refresh()
	{
		onRefresh.run();
	}
}

