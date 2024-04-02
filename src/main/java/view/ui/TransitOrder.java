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
		super(d);

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
		//	System.out.println(
	//	var str=		ms + " -> " + hrs + ":" + mins + ":" + secs;
		//	);
			var str = String.format("%02d:%02d:%02d", hrs, mins, secs);
			var prog = ms == 0 ?
				1.0 :
				(double) ms / order.getShipDuration();

			timeLabel.setText(str);
			progress.setValue(((int) (prog * 100)));
			if (order.isDelivered())
			{
				page.transitList.remove(this);
				page.deliveredList.add(
					new DeliveredOrder(d, page),
					"growx, wrap"
				);
			}
		};

		listen(
			() -> {
			}
		);
	}

	public void refresh()
	{
		onRefresh.run();
	}
}

