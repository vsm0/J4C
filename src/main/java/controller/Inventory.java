package controller;

import model.*;
import java.util.*;

public class Inventory extends HashMap<String, Product>
{
	public Inventory(Product[] list)
	{
		super();

		for (Product p : list)
			put(p.getId(), p);
	}

	private boolean isInvalid(String id, int quantity)
	{
		return !containsKey(id)
			|| quantity < 0;
	}

	public boolean updateStock(String id, int quantity)
	{
		if (isInvalid(id, quantity))
			return false;

		var p = get(id);

		return true;
	}
}

