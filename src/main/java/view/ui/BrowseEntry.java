package view.ui;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class BrowseEntry extends JPanel
{
	public BrowseEntry(Product p)
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

		var likeButton = new JButton(
			getSvgIcon(
				p.getLikeStatus()
			)
		);
		likeButton.addActionListener(
			e -> {
				var status = p
					.getLikeStatus()
					.equals("yes") ? "no" : "yes";
				p.setLikeStatus(status);

				likeButton.setIcon(
					getSvgIcon(status)
				);
			}
		);
		add(likeButton);

		var addButton = new JButton(
			new SvgIcon("cart-plus")
		);
		addButton.addActionListener(
			e -> {
				Database.addCart(p, 1);

				NavMenu.updateCounter();
			}
		);
		add(addButton);
	}

	private SvgIcon getSvgIcon(String status)
	{
		return new SvgIcon(
			switch (status)
			{
				case "yes" -> "heart";
				default -> "heart-line";
			}
		);
	}
}

