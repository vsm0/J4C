package controller;

import model.*;
import java.util.*;

public class Database
{
	private static Cart cart;
	private static Inventory inventory;

	public Database()
	{
		cart = new Cart(
			loadList("cart", CartItem.class)
		);

		inventory = new Inventory(
			loadList("inventory", Product.class)
		);
	}

	public <T> List<T> loadList(String filename, Class<T> type)
	{
		var content = FileIO.getString(filename + ".json");

		if (content == null)
		{
			content = "[]";
			FileIO.putString("cart.json", content);
		}

		var carr = FileIO.fromJson(content, type);

		if (carr == null)
			carr = new ArrayList<>();

		return carr;
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

