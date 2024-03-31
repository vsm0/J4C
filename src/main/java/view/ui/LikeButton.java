package view.ui;

import model.*;
import controller.*;
import javax.swing.*;

public class LikeButton extends JButton
{
	private Runnable onRefresh;

	public LikeButton(Product p)
	{
		super();

                addActionListener(
			e -> {
				p.setLikeStatus(
					p
					.getLikeStatus()
					.equals("yes") ? "no" : "yes"
				);
				refresh();
			}
		);

		onRefresh = () -> setIcon(
			getIcon(
				p.getLikeStatus()
			)
		);

		refresh();
	}

	public void refresh()
	{
		onRefresh.run();
	}

	private Icon getIcon(String status)
        {
                return new Svg(
                        switch (status)
                        {
                                case "yes" -> "heart";
                                default -> "heart-line";
                        }
                ).getIcon();
        }
}

