package model;

import vendor.model.*;

// just a wrapper for now until i do an epic rewrite

public class ScrollPanel extends ScrollablePanel
{
	public ScrollPanel()
	{
		super();

		setScrollableWidth(
			ScrollablePanel
			.ScrollableSizeHint
			.FIT
		);

		setScrollableHeight(
			ScrollablePanel
			.ScrollableSizeHint
			.STRETCH
		);
	}
}

