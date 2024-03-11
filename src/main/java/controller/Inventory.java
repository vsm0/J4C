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
		return quantity < 0 || !containsKey(id);
	}

	public boolean sell(String id, int quantity)
	{
		if (isInvalid(id, quantity))
			return false;

		return true;
	}

	public boolean stock(String id, int quantity)
	{
		if (isInvalid(id, quantity))
			return false;

		return true;
	}
}

