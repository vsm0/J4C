package controller;

import model.*;
import controller.*;
import java.util.*;

public class Cart extends HashMap<String, CartItem>
{
	private int realSize = 0;

	public Cart(CartItem[] items)
	{
		super();

		for (CartItem i : items)
		{
			put(i.getId(), i);
			realSize += i.getQuantity();
		}
	}

	public Cart()
	{
		super();
	}

	public int getSize()
	{
		return realSize;
	}

	public void diff(String id, int diff)
	{
		var p = Database
			.getInventory()
			.get(id);

		if (p == null)
		{
			remove(id);
			return;
		}

		var i = get(id);

		if (i == null)
		{
			if (diff < 1)
				return;

			put(
				id,
				new CartItem(p, diff)
			);
		}
		else
		{
			var quantity = i.getQuantity();

			if (Math.abs(diff) > quantity)
				return;

			i.setQuantity(quantity + diff);
		}

		realSize += diff;
	}
}

