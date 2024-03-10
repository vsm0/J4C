package controller;

import model.*;
import view.*;
import java.awt.*;
import javax.swing.*;

public class PageLoader
{
	public static void invokeLater(Runnable runner)
	{
		new SwingWorker<Void, Void>()
		{
			public Void doInBackground()
			{
				runner.run();
				return null;
			}
		}
		.execute();
			
	}

	public static void start(Container container, MFrame frame, int layer)
	{
		ContainerRemote.disable(container);
		frame.setContent(container, layer);
		frame.refresh();
		Load.stop();
	}
}

