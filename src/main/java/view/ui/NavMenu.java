package view.ui;

import model.*;
import view.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class NavMenu extends JPanel
{
	private static int counter = 0;

	public NavMenu(MFrame frame)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);
		
		var menuButton = new JButton(
			new SvgIcon("bars")
		);
		add(menuButton);

		var logoLabel = new JLabel("Tech4C");
		logoLabel.setFont(
			UIManager.getFont("h2.font")
		);
		add(logoLabel, "push");

		var isCart = frame
			.getPreferredTitle()
			.equals("Cart");

		var loginButton = new JButton(
			new SvgIcon("user")
		);
		add(loginButton, isCart ? "wrap" : "");

		if (!isCart)
		{
			// TODO: dynamic cart item count
			var cartButton = new JButton(
				new SvgIcon("cart-shopping")
			);
			cartButton.setText(
				String.valueOf(counter)
			);
			cartButton.addActionListener(
				e -> Load.queue(
					frame,
					Cart.queue(frame)
				)
			);
			add(cartButton, "wrap");
		}
	}
}
