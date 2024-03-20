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

	public Product get(String id)
	{
		var product = super.get(id);

		return (product == null) ? new Product() : product;
	}

	private boolean isInvalid(String id, int quantity)
	{
		return quantity < 0 || !containsKey(id);
	}
}

