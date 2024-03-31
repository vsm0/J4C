package model;

import java.util.*;
import javax.swing.*;

public abstract class Page extends JPanel
{
	private String title;
	private static Map<String, Page> cache = new HashMap<>();
	private static Page oldPage, newPage;

	public Page(String title)
	{
		super();
		this.title = title;
		cache.put(title, this);
	}

	public String getTitle()
	{
		return title;
	}

	public static Page getOld()
	{
		return oldPage;
	}

	public static void setNew(Page page)
	{
		if (newPage == null)
			newPage = page;

		oldPage = newPage;
		newPage = page;
		System.out.println(oldPage.getTitle());
	}

	public static Page getPage(String title)
	{
		var page = cache.get(title);
		if (page != null)
		{
			page.refresh();
		}
		return page;
	}

	public abstract void refresh();
}

