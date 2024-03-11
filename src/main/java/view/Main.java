package view;

import model.*;
import controller.*;
import com.formdev.flatlaf.*;
import javax.swing.*;

public class Main extends MFrame
{
	public Main()
	{
		super("Main", 480, 512);

		new Database();

		LoadingPage.queue(
			this,
			HomePage.queue(this)
		);
	}

	public static void main(String... args)
	{
		SwingUtilities.invokeLater(
			() -> {
				FlatLightLaf.setup();

				new Main();
			}
		);
	}
}

