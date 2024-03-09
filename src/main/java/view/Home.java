package view;

import model.*;
import view.ui.*;
import net.miginfocom.swing.*;
import java.awt.*;
import javax.swing.*;
import java.util.concurrent.*;

public class Home extends JPanel
{
	private static MFrame frame;

	public Home()
	{
		super();

		setLayout(
			new MigLayout("fill")
		);

		var header = new NavMenu();
		add(header, "north, wrap");

		var searchBar = new SearchBar();
		add(searchBar, "north, wrap");

		var body = new ScrollPanel();
		body.setLayout(
			new MigLayout("fill")
		);
		add(
			new JScrollPane(body),
			"grow"
		);

		var banner = new Banner();
		body.add(banner, "growx, wrap");

		frame.setTitle("Home");
	}

	public static void queue(MFrame _frame)
	{
		frame = _frame;

		new SwingWorker<Home, Void>()
                {
                        public Home doInBackground()
                        {
                                return new Home();
                        }

                        public void done()
                        {
				try
				{
                        		var nextPage = get();
                        	        frame.setContent(nextPage);
				}
				catch (InterruptedException e)
				{
				}
				catch (ExecutionException e)
				{
				}
                        }
                }
		.execute();
	}
}

