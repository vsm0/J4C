package view;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class Load extends JPanel
{
	private Load(MFrame frame)
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

	public static void queue(MFrame frame, Runnable runner)
	{
		PageLoader.invokeLater(
			() -> {
				var page = new Load(frame);
				frame.setContent(page, 2);
				frame.refresh();
				frame.display();
			},
			() -> {
				PageLoader.invokeLater(
					runner,
					() -> stop(frame)
				);
			}
		);
	}

	private static void stop(MFrame frame)
	{
		frame.removeContent(2);
		
		var c0 = frame.getContent(0);
		if (c0 != null)
			ContainerRemote.enable(c0);

		var c1 = frame.getContent(1);
		if (c1 != null)
			ContainerRemote.enable(c1);

		frame.refresh();
	}
}

