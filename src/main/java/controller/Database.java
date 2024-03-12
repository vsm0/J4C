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

		Product[] parr = { new Product() };

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
}

