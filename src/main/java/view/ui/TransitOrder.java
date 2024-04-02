package view.ui;

import model.*;
import view.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;

public class TransitOrder extends Order
{
	private static Runnable onRefresh;
	public TransitOrder(Delivery d, TrackerPage page)
	{
		super(d, page);

		var timeLabel = new JLabel("--:--:--", JLabel.RIGHT);
		add(timeLabel, "growx, label");

		var progress = new JProgressBar();
		progress.setStringPainted(true);
		progress.setValue(0);
		add(progress, "growx, south");

		onRefresh = () -> {
			var ms = order.getTimeLeft();
			var secs = ms / 1000;
			var mins = secs / 60;
			var hrs = mins / 60;
			secs %= 60;
			mins %= 60;
			var str = String.format("%02d:%02d:%02d", hrs, mins, secs);
			var dur = order.getShipDuration();
			var prog = ms == 0 ?
				1.0 :
				1 - ((double) ms / dur);

			timeLabel.setText(str);
			progress.setValue(((int) (prog * 100)));
			if (ms == 0)
			{
				page.transitList.remove(this);
				page.deliveredList.add(
					new DeliveredOrder(d, page),
					"growx, wrap"
				);
			}
		};
	}

	public void refresh()
	{
		onRefresh.run();
	}
}

