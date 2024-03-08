package view;

import model.*;
import com.formdev.flatlaf.*;
import javax.swing.*;

public class Main extends MFrame
{
	public Main()
	{
		super("Main", 480, 512);

		setContent(
			new Home(this)
		);

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

