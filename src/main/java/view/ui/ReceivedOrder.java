package view.ui;

import model.*;
import view.*;
import javax.swing.*;

public class ReceivedOrder extends Order
{
	private Runnable onRefresh;
	public ReceivedOrder(Delivery d, TrackerPage page)
	{
		super(d, page);
	}
	public void refresh()
	{
		onRefresh.run();
	}
}

