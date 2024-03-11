package model;

public class CartItem
{
	private String name;
	private String id;
	private String url;
	private String quantity;
	private String price;

	public CartItem(
		String name,
		String id,
		String url,
		int quantity,
		double price
	)
	{
		this.name = name;
		this.id = id;
		this.url = url;
		this.quantity = String.valueOf(quantity);
		this.price = String.valueOf(price);
	}

	public CartItem(Product p)
	{
		this(p, 0);
	}

	public CartItem(Product p, int quantity)
	{
		this(
			p.getName(),
			p.getId(),
			p.getUrl(),
			quantity,
			p.getNewPrice()
		);
	}

	public CartItem() // for testing
	{
		this(
			"Name",
			"Id",
			"url://",
			1,
			10.0
		);
	}

	public String getName()
	{
		return name;
	}

	public String getId()
	{
		return id;
	}

	public String getUrl()
	{
		return url;
	}

	public double getQuantity()
	{
		return Double.valueOf(quantity);
	}

	public int getPrice()
	{
		return Integer.valueOf(price);
	}

	public void setQuantity(int quantity)
	{
		this.quantity = String.valueOf(quantity);
	}
}

