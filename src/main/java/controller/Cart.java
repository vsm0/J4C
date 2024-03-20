package controller;

import model.*;
import controller.*;
import java.util.*;

public class Cart extends HashMap<String, CartItem>
{
	private int realSize = 0;

	public Cart(List<CartItem> items)
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

	public CartItem get(String id, Product p)
	{
		var item = super.get(id);

		return (item == null) ? new CartItem(p) : item;
	}

	public boolean addItem(Product p, int amount)
	{
		var stock = p.getStock();

		var id = p.getId();

		var item = get(id, p);

		var quantity = item.getQuantity();

		item.setQuantity(quantity + amount);

		put(id, item);

		realSize += amount;

		return true;
	}
}

