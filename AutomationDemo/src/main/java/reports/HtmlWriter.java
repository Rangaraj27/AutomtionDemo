package reports;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;

public class HtmlWriter {
	
	public static void deletefile(String path)
	{
		try
		{
			File file=new File(path);
			String[] myfiles;
			
			if(file.isDirectory())
			{
				myfiles=file.list();
				for(int i=0;i<myfiles.length;i++)
				{
					File myfile=new File(file,myfiles[i]);
					if(myfile.isDirectory())
					{
						FileUtils.deleteDirectory(myfile);
					}
					else
					{
						myfile.delete();
					}
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to find the path " + path);
			e.printStackTrace();
		}
	}

}
