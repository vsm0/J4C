package controller;

import com.google.gson.*;
import com.google.gson.reflect.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class FileIO
{
	private static Gson gson = new GsonBuilder()
		.setPrettyPrinting()
		.create();

	private static String getDataPath(String path)
	{
		var root = System.getProperty("user.dir");

		if (root.endsWith("/bin"))
			root = root.substring(
				0, root.length() - 4
			);

		return root + "/data/" + path;
	}

	public static String getString(String path)
	{
		var dataPath = getDataPath(path);

		try
		{
			var file = new File(dataPath);

			if (!file.exists())
				file.createNewFile();

			var filePath = Paths.get(dataPath);

			return Files.readString(filePath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static boolean putString(String path, String s)
	{
		var dataPath = getDataPath(path);

		try
		{
			var filePath = Paths.get(dataPath);

			Files.writeString(filePath, s);

			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

	private static <T> Type getType(Class<T> type)
	{
		return TypeToken.getParameterized(List.class, type).getType();
	}

	public static <T> List<T> fromJson(String content, Class<T> type)
	{
		return gson.fromJson(content, getType(type));
	}

	public static <T> String toJson(List<T> container, Class<T> type)
	{
		return gson.toJson(container, getType(type));
	}
}

