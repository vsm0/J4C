package view;

import model.*;
import com.formdev.flatlaf.*;
import javax.swing.*;

public class Main extends MFrame
{
	public Main()
	{
		super("Main");

		setContent(
			new Home(this)
		);

		setSize(640, 480);

		display();
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

