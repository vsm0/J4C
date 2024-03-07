package view;

import javax.swing.*;

public class Main
{
	public Main()
	{
	}

	public static void main(String... args)
	{
		SwingUtilities.invokeLater(
			() -> new Main()
		);
	}
}

