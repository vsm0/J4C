package model;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Paragraph extends JTextPane
{
	public static final int CENTER = StyleConstants.ALIGN_CENTER;
	public static final int LEFT = StyleConstants.ALIGN_LEFT;
	public static final int RIGHT = StyleConstants.ALIGN_RIGHT;

	public Paragraph(Container parent, String s)
	{
		super();

		setup(parent, LEFT, s);
	}

	public Paragraph(Container parent, int align, String s)
	{
		super();

		setup(parent, align, s);
	}

	private void setup(Container parent, int align, String s)
	{
		setText(s);
		setEditable(false);
		setBackground(
			parent.getBackground()
		);

		setPreferredSize(
			new Dimension(
				parent.getPreferredSize().width,
				1
			)
		);

		var attributes = new SimpleAttributeSet();
		
		StyleConstants.setAlignment(attributes, align);
		getStyledDocument().setParagraphAttributes(
			0,
			s.length(),
			attributes,
			false
		);
	}
}

