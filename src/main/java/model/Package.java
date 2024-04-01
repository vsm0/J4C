package model;

public class Package
{
	private String id;
	private String items;
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

	public Package(
		String id,
		String items,
		String address,
		String receiver,
		Status status,
		long timeCreated,
		long shipDuration
	)
	{
		this.id = id;
		this.items = items;
		this.address = address;
		this.receiver = reciever;
		this.status = status.getStatus();
		this.timeCreated = String.valueOf(timeCreated);
		this.shipDuration = String.valueOf(shipDuration);
	}

	public Package()
	{
		this(
			"Id",
			"item1\nitem2\nitem3",
			"1408 Dolphin Hotel",
			"John Cosmack",
			Status.TRANSIT,
			System.currentTimeMillis(),
			10000
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
		return Long.valueOf(timeCreated);
	}

	public long getShipDuration()
	{
		return Long.valueOf(shipDuration);
	}

	public double getCompletionRatio()
	{
		var cur = System.currentTimeMillis();
		var old = getTimeCreated();
		var dur = getShipDuration();
		var diff = cur - old;
		if (diff > dur)
		{
			status = Status.DELIVERED.getStatus();
			return 1.0;
		}
		return (double) diff / dur;
	}

	public boolean isDelivered()
	{
		return status == Status.DELIVERED.getStatus();
	}
}
