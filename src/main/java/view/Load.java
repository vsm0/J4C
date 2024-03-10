package view;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Load extends JPanel
{
	private static MFrame frame;

	private Load()
	{
		super();

		setLayout(
			new MigLayout("al center center")
		);

		add(
			new Gif(
				"gfx/gif/preloader.gif",
				"Loading..."
			),
			"wrap"
		);
		

		frame.setTitle("Loading");
	}

	public static void queue(MFrame _frame)
	{
		frame = _frame;

		PageLoader.invokeLater(
			() -> {
				var page = new Load();
				frame.setContent(page, 2);
				frame.refresh();
				frame.display();
			}
		);
	}

	public static void stop()
	{
		var timer = new Timer(
			512,
			e -> {
				frame.removeContent(2);
		
				var c0 = frame.getContent(0);
				if (c0 != null)
					ContainerRemote.enable(c0);

				var c1 = frame.getContent(1);
				if (c1 != null)
					ContainerRemote.enable(c1);

				frame.refresh();
			}
		);
		timer.setRepeats(false);
		timer.start();
	}
}

