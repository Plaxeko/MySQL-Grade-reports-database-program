/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of this class is to provide some generic text file input / output
 * routines and routines for accessing content on the Internet.
 * 
 * @version : - * 14.13 - 12/02/2014 09:00
 * @author : - Amir Torabi
 * 
 *         <dt><span class="strong">See Also:</span></dt>
 *         <dd>: - Serialized Form</dd>
 * 
 *         <dt><span class="strong">Studentid:</span></dt>
 *         <dd>: - 5293010</dd>
 * 
 *         <dt><span class="strong">Email:</span></dt>
 *         <dd>: - torabi10@gmail.com</dd>
 * 
 *         <dt><span class="strong">Assignment.number:</span></dt>
 *         <dd>: - A19015-02</dd>
 * 
 * 
 */
public class INET2 implements INET2Template {

	/*
	 * @Parameters
	 * 
	 * @see main.INET2Template#fileExists(java.lang.String)
	 */
	/**
	 * The purpose of this method is to accept a full file pathname as as
	 * parameter and determine if it exists on disk. If it does, return true,
	 * otherwise return false.
	 * 
	 * @specified fileExists in interface INET2Template
	 * 
	 * @param strFileName
	 *            - full file pathname
	 * 
	 * @return true if file exists, otherwise false
	 */
	public boolean fileExists(String strFileName) {
		File file = new File(strFileName);
		if (file.exists() && !file.isDirectory()) {
			return true;
		}
		return false;
	}

	/**
	 * The purpose of this method is to accept a full file pathname as a parameter, then check to see if the file exists. If it does, return the file contents as a string. This function should use the fileExists method. If the file does not exist, return a null.
	 * 
	 * @specified getFromFile in interface INET2Template
	 * 
	 * @param strFileName - full file pathname
	 * 
	 * @return contents of file or null
	 */
	public String getFromFile(String strFileName) {
		try {
			if (fileExists(strFileName)) {
				FileReader fr;

				fr = new FileReader(strFileName);

				BufferedReader br = new BufferedReader(fr);
				String strContent = "";
				String line;

				while ((line = br.readLine()) != null) {
					strContent += line + "\n";
				}
				br.close();
				fr.close();
				return strContent;
			}
		} catch (IOException ex) {
			Logger.getLogger(INET2.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	/**
	 * The purpose of this method is to check to see if the file exists locally
	 * and if not, download it then save it to disk. It does this by creating
	 * the file name from the table name by attaching the file type to the
	 * beginning of the table name
	 * 
	 * (i.e. data_roster.txt)
	 * 
	 * and then checking to see if the file exists. If it does not, the method
	 * will create the URL from the table name
	 * 
	 * (i.e. http://jcouture.net/data/data_roster.txt )
	 * 
	 * and download it from the Internet using getURLRaw(). Then it will save it
	 * to disk using saveToFile()
	 * 
	 * @specified getNetFile in interface INET2Template
	 * 
	 * @param strTableName
	 *            - name of the table like grades or roster *NEW* strType - a
	 *            string of "schema" or "data"
	 * 
	 * @return the filename where the file was saved
	 */
	public String getNetFile(String strTableName, String strType) {
		/*
		 * The purpose of this method is to check to see if the file exists
		 * locally and if not, download it then save it to disk. It does this by
		 * creating the file name from the table name by attaching the file type
		 * to the beginning of the table name
		 * 
		 * (i.e. data_roster.txt)
		 * 
		 * and then checking to see if the file exists. If it does not, the
		 * method will create the URL from the table name
		 * 
		 * (i.e. http://jcouture.net/data/data_roster.txt )
		 * 
		 * and download it from the Internet using getURLRaw(). Then it will
		 * save it to disk using saveToFile()
		 */
		String fileName = strType + "_" + strTableName + ".txt";
		if (!fileExists(fileName)) {
			System.out.println("Not Found");
			return getURLRaw(fileName);

		}

		return fileName;
	}

	/**
	 * TThe purpose of this method is to accept a URL as a parameter and go to
	 * the Internet to download it. If there is no content to return, return a
	 * null
	 * 
	 * 
	 * @specified getURLRaw in interface INET2Template
	 * 
	 * @param strURL
	 *            - URL to travel to on the Internet *
	 * @return the web page contents or a null
	 */
	public String getURLRaw(String strURL) {
		StringBuilder strContent = new StringBuilder("");
		try {
			URL myWebAddress = new URL("http://jcouture.net/data/" + strURL);

			System.out.println(myWebAddress.toString());
			URLConnection myConn = myWebAddress.openConnection();
			myConn.setConnectTimeout(0); // to prevent timeout errors
			InputStream myStrIn = myConn.getInputStream();
			BufferedReader inputFile = new BufferedReader(new InputStreamReader(myStrIn));
			while (inputFile.ready()) {
				// read a line and append it to strContent
				String strRecord = inputFile.readLine() + "\r\n";
				strContent.append(strRecord);
				System.out.println(strRecord);
			}
			inputFile.close();
			myStrIn.close();
			System.out.println(strContent);
			saveToFile(strURL, strContent.toString());
		} catch (MalformedURLException errnum) {
			// display error if URL is messed up
			System.out.println(errnum.getMessage());
			return null;
		} catch (IOException errnum) {
			// display error if Internet connection is flaky
			System.out.println(errnum.getMessage());
			return null;
		}
		// At this point strContent contains the
		// raw HTML code of your web page
		// or just a blank
		// System.out.println("here");
		return strContent.toString(); // return string builder as a str
	}

	/**
	 * TThe purpose of this method is to accept a full file pathname along with
	 * the content to be saved as parameters and save it to the local drive
	 * 
	 * @specified saveToFile in interface INET2Template
	 * 
	 * @param strFileName
	 *            - - full file pathname strContent - - any string content
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean saveToFile(String strFileName, String strContent) {
		boolean success = false;
		System.out.println(strFileName);
		try {
			File file = new File(strFileName);
			if (!file.exists()) {
				System.out.println("creating a file");
				file.createNewFile();
				System.out.println("ok");
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(strContent);
			bw.close();
			success = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}
}
