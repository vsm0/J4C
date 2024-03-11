package controller;

import model.*;
import java.util.*;

public class Cart extends HashMap<String, CartItem>
{
	private int realSize = 0;

	public Cart(CartItem[] items)
	{
		super();

		for (CartItem i : items)
			put(i.getId(), i);
	}

	public Cart()
	{
		super();
	}

	public void set(String id, int quantity)
	{
		if (quantity < 1)
			return;

		var i = get(id);

		if (i == null)
		{
			i = new CartItem(
				Database
				.getInventory()
				.get(id),
				quantity
			);
			realSize += quantity;
		}
		else
		{
			var oldQuantity = i.getQuantity();
			i.setQuantity(quantity);
			realSize += quantity - oldQuantity;
		}

		put(id, i);
	}
}

