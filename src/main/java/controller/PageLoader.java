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

	public static void start(MFrame frame, Page page, int layer)
	{
		ContainerRemote.disable(page);
		frame.setContent(page, layer);
		frame.setTitle(
			page.getTitle()
		);
		frame.refresh();
	}
}

