package controller;

import model.*;
import view.*;
import java.awt.*;
import javax.swing.*;

public class PageLoader
{
	public static void invokeLater(Runnable during)
	{
		invokeLater(
			during,
			() -> {}
		);
	}

	public static void invokeLater(Runnable during, Runnable after)
	{
/*		new SwingWorker<Void, Void>()
		{
			public Void doInBackground()
			{
				during.run();
				return null;
			}

			public void done()
			{
				after.run();
			}
		}
		.execute();
		*/
		during.run();
		after.run();
	}

	public static void start(Container container, MFrame frame, int layer)
	{
		ContainerRemote.disable(container);
		frame.setContent(container, layer);
		frame.setTitle(
			frame.getPreferredTitle()
		);
		frame.refresh();
	}
}

