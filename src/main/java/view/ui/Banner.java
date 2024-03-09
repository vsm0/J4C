package view.ui;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Banner extends JPanel
{
	public Banner()
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var quote = new Paragraph(
			this,
			Paragraph.CENTER,
			"Shop here. Now."
		);
		quote.setFont(
			UIManager.getFont("h1.font")
		);
		add(quote, "growx, wrap");

		var subquote = new Paragraph(
			this,
			Paragraph.CENTER,
			"Tech4C is the world's #1 gadget retail service, bringing you the best value for the best price since 2024."
		);
		subquote.setFont(
			UIManager.getFont("large.font")
		);
		add(subquote, "growx, wrap, gapy 30");

		var tip = new Paragraph(
			this,
			Paragraph.CENTER,
			"Please sign-in for the best experience."
		);
		tip.setFont(
			UIManager.getFont("small.font")
		);
		add(tip, "growx, wrap, gapy 40");

		var loginButton2 = new JButton("Login");
		add(loginButton2, "al center, split 2");

		var registerButton = new JButton("Register");
		add(registerButton);
	}
}

