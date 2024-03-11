package controller;

import java.nio.file.*;

public class FileIO
{
	public String getString(String path)
	{
		var stream = FileIO
			.class
			.getClassLoader()
			.getResourceAsStream(path);

		if (stream == null)
			return null;

		try
		{
			return new String(stream.readAllBytes());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public boolean putString(String s, String path)
	{
		try
		{
			var res = Paths.get("rwdata");

			Files.writeString(res, s);

			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}
}

