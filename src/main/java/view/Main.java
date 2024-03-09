package view;

import model.*;
import com.formdev.flatlaf.*;
import java.awt.*;
import javax.swing.*;

public class Main extends MFrame
{
	public Main()
	{
		super("Main", 480, 512);

		Load.start(this);

		Home.queue(this);
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

