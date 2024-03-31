package view.ui;

import model.*;
import view.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class NavMenu extends JPanel
{
	private Runnable onRefresh;
	private static JButton cartButton;

	public NavMenu(MFrame frame, String title)
	{
		super();

		setLayout(
			new MigLayout("fill")
		);
		
		var isNav = title.equals("Nav");
		var runner = queue(frame, isNav);
		var menuButton = new JButton(
			new Svg(
				isNav ? "xmark" : "bars"
			).getIcon()
		);
		menuButton.addActionListener(
			e -> LoadingPage.queue(frame, runner)
		);
		add(menuButton);

		var logoLabel = new JLabel("Tech4C");
		logoLabel.setFont(
			UIManager.getFont("h2.font")
		);
		add(logoLabel, "push");

		var isCart = title.equals("Cart");

		if (isCart || isNav)
		{
			onRefresh = () -> {};
		}
		else
		{
			var loginButton = new JButton(
				new Svg("user").getIcon()
			);
			add(loginButton, isCart ? "wrap" : "");

			// TODO: dynamic cart item count
			cartButton = new JButton(
				new Svg("cart-shopping").getIcon()
			);
			updateCounter();
			cartButton.addActionListener(
				e -> LoadingPage.queue(
					frame,
					CartPage.queue(frame)
				)
			);
			add(cartButton, "wrap");
			onRefresh = () -> updateCounter();
		}
	}

	public void refresh()
	{
		onRefresh.run();
	}

	private void updateCounter()
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

	private Runnable queue(MFrame frame, boolean isNav)
	{
		return isNav ?
			() -> {
				var page = LoadingPage.getOld();
				PageLoader.start(frame, page, 0);
			}
			: NavPage.queue(frame);
	}
}
