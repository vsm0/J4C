package view.ui;

import model.*;
import view.*;
import javax.swing.*;

public class DeliveredOrder extends Order
{
	private Runnable onRefresh;
	public DeliveredOrder(Delivery d, TrackerPage page)
	{
		super(d);
	}

	public void refresh()
	{
		onRefresh.run();
	}
}

