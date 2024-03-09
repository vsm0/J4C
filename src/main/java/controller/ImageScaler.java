package controller;

import java.awt.*;

public class ImageScaler
{
	public enum ScaleMode
	{
		FIT, // scale, letterbox, no cutoff
		GROW, // scale, no letterbox, cutoff
		STRETCH // scale, no letterbox, no cutoff
	}

	public static Dimension scale(
		int srcW,
		int srcH,
		int viewW,
		int viewH,
		ScaleMode mode
	)
	{
		assert srcW > 0
			&& srcH > 0
			&& viewW > 0
			&& viewH > 0
			: "Dimensions cannot be < 0!";

		var width = (double) srcW;
		var height = (double) srcH;
		var wr = (double) viewW / width;
		var hr = (double) viewH / height;

		switch (mode) {
			case FIT -> {
				wr = Math.min(wr, hr);
				hr = wr;
			}
			case GROW -> {
				wr = Math.max(wr, hr);
				hr = wr;
			}
		};		      

		return new Dimension(
			(int) (width * wr),
			(int) (height * hr)
		);
	}
}

