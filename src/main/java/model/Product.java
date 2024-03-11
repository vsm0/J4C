package model;

public class Product
{
	private String name;
	private String id;
	private String url;
	private String specs;
	private String vendor;
	private String category;
	private String likeStatus;
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
		String category,
		String likeStatus,
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
		this.category = category;
		this.likeStatus = likeStatus;
		this.oldPrice = String.valueOf(oldPrice);
		this.newPrice = String.valueOf(newPrice);
		this.sale = String.valueOf(sale);
		this.rating = String.valueOf(rating);
		this.sold = String.valueOf(sold);
		this.stock = String.valueOf(stock);
	}

	public Product() //for testing
	{
		this(
			"Name",
			"Id",
			"url://",
			"specs",
			"vendor",
			"laptop",
			"no",
			200.0,
			150.0,
			15,
			3,
			67,
			100
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

	public String getSpecs()
	{
		return specs;
	}

	public String getVendor()
	{
		return vendor;
	}

	public String getCategory()
	{
		return category;
	}

	public String getLikeStatus()
	{
		return likeStatus;
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

	public void setLikeStatus(String likeStatus)
	{
		this.likeStatus = likeStatus;
	}

	public void setStock(int stock)
	{
		this.stock = String.valueOf(stock);
	}
}

