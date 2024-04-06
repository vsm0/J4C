package controller;

import model.*;
import java.util.*;

public class Database
{
	private static Cart cart;
	private static Inventory inventory;
	private static Tracker tracker;

	public Database()
	{
		cart = new Cart(
			loadList("cart", CartItem.class)
		);

		inventory = new Inventory(
			loadList("inventory", Product.class)
		);

		tracker = new Tracker(
			loadList("tracker", Delivery.class)
		);
	}

	private static <T> List<T> loadList(String filename, Class<T> type)
	{
		var content = FileIO.getString(filename + ".json");

		if (content == null)
		{
			content = "[]";
			FileIO.putString(filename + ".json", content);
		}

		var carr = FileIO.fromJson(content, type);

		if (carr == null)
			carr = new ArrayList<>();

		return carr;
	}
	
	public static <T> boolean saveList(String filename, Map<String, T> map, Class<T> type)
	{
		List<T> list = new ArrayList<>();

		map.forEach(
			(id, item) -> list.add(item)
		);

		var content = FileIO.toJson(list, type);

		return FileIO.putString(filename + ".json", content);
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

	public static Tracker getTracker()
	{
		return tracker;
	}

	public static Product getProduct(String id)
	{
		return inventory.get(id);
	}

	public static void addCart(String id, int amount)
	{
		var p = inventory.get(id);

		addCart(p, amount);
	}

	public static void delCart(String id, int amount)
	{
		var p = inventory.get(id);

		addCart(p, -amount);
	}

	public static void addCart(Product p, int amount)
	{
		if (!cart.addItem(p, amount))
			return;

		p.updateStock(-amount);
	}

	public static void clearCart()
	{
		cart.forEach(
			(id, item) -> inventory.get(id).updateStock(
				item.getQuantity()
			)
		);

		cart.clear();
	}

	public static void save()
	{
		saveList("cart", cart, CartItem.class);
		saveList("inventory", inventory, Product.class);
		saveList("tracker", tracker, Delivery.class);
	}
}

