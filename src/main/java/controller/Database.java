package controller;

import model.*;
import java.util.*;

public class Database
{
	private static List<String> products = new ArrayList<>();
	private static List<String> cartIds = new ArrayList<>();
	private static Map<String, CartItem> cart = Map.of(
		"Id",
		new CartItem()
	);
	private static Map<String, Product> inventory = Map.of(
		"Id", 
		new Product()
	);

	public Database()
	{
	}

	public static boolean getConnection(
		String url,
		String usr,
		String pwd
	)
	{
		return true;
	}

	public static List<String> getProducts()
	{
		return products;
	}

	public static Product getProduct(String id)
	{
		return inventory.get(id);
	}

	//TODO: Account specific check
	public static Map<String, CartItem> getCart()
	{
		return cart;
	}

	public static void removeFromCart(String id)
	{
		removeFromCart(id, -1);
	}

	public static void removeFromCart(String id, int quantity)
	{
		var i = getCart().get(id);

		if (i == null)
			return;
/*
		if (quantity < 0)
			quantity = i.getQuantity();

		cart.remove(id);
*/
		// save db
	}

	public static void addToCart(String id, int quantity)
	{
		var p = inventory.get(id);

		if (p == null)
			return;

		var item = new CartItem(p);

		item.setQuantity(quantity);

		cart.put(id, item);

		//save db
	}
}

