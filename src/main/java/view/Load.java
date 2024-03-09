package view;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Load extends JPanel
{
	public static void start(MFrame frame)
	{
		var content = new Load(frame);
		frame.setContent(content);
		frame.display();
	}

	public Load(MFrame frame)
	{
		super();

		setLayout(
			new MigLayout("al center center")
		);

		var icon = new ImageIcon(
			getClass()
			.getClassLoader()
			.getResource(
				"gfx/gif/ajax-loader.gif"
			)
		);

		var spinner = new JLabel(icon);
		icon.setImageObserver(spinner);
		add(spinner, "wrap");

		add(
			new JLabel(
				"Loading",
				SwingConstants.CENTER
			),
			"label"
		);

		frame.setTitle("Loading");
	}
}

