package view.ui;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class NavMenu extends JPanel
{
	public NavMenu()
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

		var loginButton = new JButton(
			new SvgIcon("user")
		);
		add(loginButton);

		// TODO: dynamic cart item count
		var cartButton = new JButton(
			new SvgIcon("cart-shopping")
		);
		cartButton.setText("0");
		add(cartButton, "wrap");
	}
}
