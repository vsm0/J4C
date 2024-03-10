package controller;

import model.*;
import java.util.*;

public class Database
{
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
		// debug
		List<String> list = new ArrayList<>();

		list.add("id");

		return list;
	}

	public static Product getProduct(String id)
	{
		var list = getProducts();

		Map<String, Product> db = new HashMap<>();

		db.put(
			"id",
			new Product(
				"Name",
				"id",
				"test.jpg",
				"good spec",
				"vendor",
				123.50, // old price
				89.72, // new price
				12, // sale
				2, // rate
				58, // sold
				100 // stock
			)
		);

		for (String s : list)
		{
			if (s.equals(id))
				return db.get(id);
		}

		return null;
	}
}

