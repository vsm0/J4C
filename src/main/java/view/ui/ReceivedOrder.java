package view.ui;

import model.*;
import javax.swing.*;

public class ReceivedOrder extends Order
{
	private Runnable onRefresh;
	public ReceivedOrder(Delivery d)
	{
		super(d);
	}
	public void refresh()
	{
		onRefresh.run();
	}
}

