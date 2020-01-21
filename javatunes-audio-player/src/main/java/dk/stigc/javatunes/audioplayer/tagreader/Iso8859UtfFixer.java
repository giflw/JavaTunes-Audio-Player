package dk.stigc.javatunes.audioplayer.tagreader;

import dk.stigc.javatunes.audioplayer.other.Log;

public class Iso8859UtfFixer 
{
	private static String[] iso8859 = {"�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�","�"};
	private static String[] iso8859_wrong = null;
	
	private static void calculate()
	{
		iso8859_wrong = new String[iso8859.length];
			
		try
		{
			for (int i=0; i<iso8859.length; i++)
			{
				byte[] bytes = iso8859[i].getBytes("UTF-8");
				iso8859_wrong[i] = new String(bytes, "ISO-8859-1");
			}
		}
		catch (Exception ex)
		{
			Log.write ("ex:" + ex);
		}
	}
	
	public static String fix(String v)
	{
		if (iso8859_wrong==null)
			calculate();
			
		for (int i=0; i<iso8859.length; i++)
			v = v.replaceAll(iso8859_wrong[i], iso8859[i]);
		
		return v;
		
	}

}


