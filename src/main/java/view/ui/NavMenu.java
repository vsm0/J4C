package view.ui;

import model.*;
import view.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class NavMenu extends JPanel
{
	private static JButton cartButton;

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
			cartButton = new JButton(
				new SvgIcon("cart-shopping")
			);
			updateCounter();
			cartButton.addActionListener(
				e -> LoadingPage.queue(
					frame,
					CartPage.queue(frame)
				)
			);
			add(cartButton, "wrap");
		}
	}

	public static void updateCounter()
	{
		cartButton.setText(
			String.valueOf(
				Database
				.getCart()
				.getSize()
			)
		);
		cartButton.revalidate();
		cartButton.repaint();
	}
}
