package util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;


public class HtmlWriter extends BaseTest {

		public static void deletefile(String path) {
			try {
				File file = new File(path);
				String[] myfiles;

				if (file.isDirectory()) {
					myfiles = file.list();
					for (int i = 0; i < myfiles.length; i++) {
						File myfile = new File(file, myfiles[i]);
						if (myfile.isDirectory()) {
							FileUtils.deleteDirectory(myfile);
						} else {
							myfile.delete();
						}
					}
				}

			} catch (Exception e) {
				System.out.println("Unable to find the path " + path);
				e.printStackTrace();
			}
		}

		public static void readfile(String path) throws IOException {
			
			File folder =new File(path);
			File []listofFiles=folder.listFiles();
			StringBuilder content=new StringBuilder();
			for(int i=0;i<listofFiles.length;i++)
			{
				File file=listofFiles[i];
				if(file.isFile()&&file.getName().endsWith(".Html")) 
				{
					String Htmlcontent=readFile(file,StandardCharsets.UTF_8);
					content.append(Htmlcontent);
				}
			}

		}

		public static String readFile(File file, Charset charset) throws IOException {
			// TODO Auto-generated method stub
			return new String(Files.readAllBytes(file.toPath()),charset);
		}

}

