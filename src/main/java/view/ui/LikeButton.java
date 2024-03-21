package view.ui;

import model.*;
import controller.*;
import javax.swing.*;

public class LikeButton extends JButton
{
	public LikeButton(Product p)
	{
		super();

		setIcon(
                        getSvgIcon(
                                p.getLikeStatus()
                        )
                );

                addActionListener(
                        e -> {
                                var status = p
                                        .getLikeStatus()
                                        .equals("yes") ? "no" : "yes";
                                p.setLikeStatus(status);

                                setIcon(
                                        getSvgIcon(status)
                                );
                        }
                );
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

