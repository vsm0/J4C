package controller;

import model.*;
import java.util.*;

public class Tracker extends HashMap<String, Delivery>
{
	public Tracker(List<Delivery> list)
	{
		super();

		for (Delivery d : list)
			put(d.getId(), d);
	}

	public Delivery get(String id)
	{
		var d = super.get(id);

		return (d == null) ? new Delivery() : d;
	}
}
