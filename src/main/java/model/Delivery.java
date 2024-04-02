package model;

public class Delivery
{
	private String id;
	private String items;
	private String price;
	private String address;
	private String receiver;
	private String status;
	private String timeCreated;
	private String shipDuration;

	public enum Status {
		TRANSIT("in transit"),
		DELIVERED("delivered"),
		RECEIVED("received");

		private final String status;

		Status(String status)
		{
			this.status = status;
		}

		public String getStatus()
		{
			return status;
		}
	}

	public Delivery(
		String id,
		String items,
		double price,
		String address,
		String receiver,
		Status status,
		long timeCreated,
		long shipDuration
	)
	{
		this.id = id;
		this.items = items;
		this.price = String.valueOf(price);
		this.address = address;
		this.receiver = receiver;
		this.status = status.getStatus();
		this.timeCreated = String.valueOf(timeCreated);
		this.shipDuration = String.valueOf(shipDuration);
	}

	public Delivery()
	{
		this(
			"Id",
			"item1\nitem2\nitem3",
			1200.45,
			"1408 Dolphin Hotel",
			"John Cosmack",
			Status.TRANSIT,
			System.currentTimeMillis(),
			1000 * 60 * 60
		);
	}

	public String getId()
	{
		return id;
	}

	public String getItems()
	{
		return items;
	}

	public Double getPrice()
	{
		return Double.valueOf(price);
	}

	public String getAddress()
	{
		return address;
	}

	public String getReceiver()
	{
		return receiver;
	}

	public String getStatus()
	{
		return status;
	}

	public long getTimeCreated()
	{
		return Long.parseLong(timeCreated);
	}

	public long getShipDuration()
	{
		return Long.parseLong(shipDuration);
	}

	public long getTimeLeft()
	{
		var cur = System.currentTimeMillis();
		var old = getTimeCreated();
		var dur = getShipDuration();
		return cur > old + dur ?
			0 :
			old + dur - cur;
	}

	public boolean isInTransit()
	{
		return status.equals(Status.TRANSIT.getStatus());
	}

	public boolean isDelivered()
	{
		return status.equals(Status.DELIVERED.getStatus());
	}
	
	public boolean isReceived()
	{
		return status.equals(Status.RECEIVED.getStatus());
	}
}
