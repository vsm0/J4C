package controller;

import model.*;
import java.util.*;

public class Database
{
	private static Cart cart;
	private static Inventory inventory;

	public Database()
	{
		CartItem[] carr = {};

		cart = new Cart(carr);

		ArrayList<Product> list = new ArrayList<>();

		for (int i = 0; i < 20; i++)
			list.add(new Product());

		Product[] parr = new Product[list.size()];

		for (int i = 0; i < list.size(); i++)
			parr[i] = list.get(i);

		inventory = new Inventory(parr);
	}

	public static boolean getConnection(
		String url,
		String usr,
		String pwd
	)
	{
		return true;
	}

	public static Cart getCart()
	{
		return cart;
	}

	public static Inventory getInventory()
	{
		return inventory;
	}

	public static void addCart(String id, int amount)
	{
		var p = inventory.get(id);

		addCart(p, amount);
	}

	public static void addCart(Product p, int amount)
	{
		if (!p.hasStock())
			return;

		if (cart.addItem(p, amount))
			p.updateStock(-amount);
	}
}

