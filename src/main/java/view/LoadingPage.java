package view;

import model.*;
import controller.*;
import net.miginfocom.swing.*;
import javax.swing.*;

public class LoadingPage extends Page
{
	private static String title = "Loading";

	private LoadingPage(MFrame frame)
	{
		super(title);

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
	}

	public static void queue(MFrame frame, Runnable runner)
	{
		PageLoader.invokeLater(
			() -> {
				var page = getPage(title);
				if (page == null)
					page = new LoadingPage(frame);
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

	public void refresh()
	{
	}

	private static void stop(MFrame frame)
	{
		var c0 = frame.getContent(0);
		if (c0 != null)
			ContainerRemote.enable(c0);

		var c1 = frame.getContent(1);
		if (c1 != null)
			ContainerRemote.enable(c1);

		frame.removeContent(2);
		frame.refresh();
	}
}

