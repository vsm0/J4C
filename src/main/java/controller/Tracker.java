package controller;

import model.*;
import java.util.*;

public class Tracker extends HashMap<String, Package>
{
	public Tracker(List<Tracker> list)
	{
		super();

		for (Package p : list)
			put(p.getId(), p);
	}

	public Package get(String id)
	{
		var p = super.get(id);

		return (p == null) ? new Package(id) : p;
	}
}
