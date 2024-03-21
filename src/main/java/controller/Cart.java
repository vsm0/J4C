package controller;

import model.*;
import controller.*;
import java.util.*;

public class Cart extends HashMap<String, CartItem>
{
	private int realSize;
	private double totalPrice;

	public Cart(List<CartItem> items)
	{
		super();

		realSize = 0;
		totalPrice = 0.0;

		for (CartItem i : items)
		{
			put(i.getId(), i);
			var quantity = i.getQuantity();
			realSize += quantity;
			totalPrice += quantity * i.getPrice();
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

	public double getTotal()
	{
		return totalPrice;
	}

	public void clear()
	{
		super.clear();
		realSize = 0;
		totalPrice = 0.0;
	}

	public CartItem get(String id, Product p)
	{
		var item = super.get(id);

		return (item == null) ? new CartItem(p) : item;
	}

	public boolean addItem(Product p, int amount)
	{
		var id = p.getId();

		var item = get(id, p);

		item.setQuantity(item.getQuantity() + amount);

		if (item.getQuantity() == 0)
			remove(id);
		else
			put(id, item);

		realSize += amount;
		totalPrice += amount * item.getPrice();

		return true;
	}
}

