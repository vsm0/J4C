package model;

public class Product
{
	private String name;
	private String id;
	private String url;
	private String specs;
	private String vendor;
	private String oldPrice;
	private String newPrice;
	private String sale;
	private String rating;
	private String sold;
	private String stock;

	public Product(
		String name,
		String id,
		String url,
		String specs,
		String vendor,
		double oldPrice,
		double newPrice,
		int sale,
		int rating,
		int sold,
		int stock
	)
	{
		this.name = name;
		this.id = id;
		this.url = url;
		this.specs = specs;
		this.vendor = vendor;
		this.oldPrice = String.valueOf(oldPrice);
		this.newPrice = String.valueOf(newPrice);
		this.sale = String.valueOf(sale);
		this.rating = String.valueOf(rating);
		this.sold = String.valueOf(sold);
		this.stock = String.valueOf(stock);
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

	public String getSpecs()
	{
		return specs;
	}

	public String getVendor()
	{
		return vendor;
	}

	public double getOldPrice()
	{
		return Double.valueOf(oldPrice);
	}

	public double getNewPrice()
	{
		return Double.valueOf(newPrice);
	}

	public int getSale()
	{
		return Integer.valueOf(sale);
	}

	public int getRating()
	{
		return Integer.valueOf(rating);
	}

	public int getSold()
	{
		return Integer.valueOf(sold);
	}

	public int getStock()
	{
		return Integer.valueOf(stock);
	}
}

