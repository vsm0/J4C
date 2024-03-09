package view;

import model.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Load extends JPanel
{
	private static MFrame frame;

	public static void start(MFrame _frame)
	{
		frame = _frame;
		var content = new Load(frame);
		frame.setContent(content, 2);
		frame.refresh();
		frame.display();
	}

	public static void stop()
	{
		var timer = new Timer(
			512,
			e -> {
				frame.removeContent(2);
				frame.refresh();
			}
		);
		timer.setRepeats(false);
		timer.start();
	}

	private Load(MFrame frame)
	{
		super();

		setLayout(
			new MigLayout("al center center")
		);

		add(
			new Img(
			//	"gfx/gif/preloader.gif",
				"gfx/gif/ajax-loader.gif",
				"...",
				80,
				80
			),
			"wrap"
		);

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

