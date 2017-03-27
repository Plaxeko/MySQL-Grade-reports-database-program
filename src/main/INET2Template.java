/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 * The purpose of this class is to provide simple functions for downloading web
 * pages from the Internet and saving them to disk.
 * 
 *  @version : - * 14.13 - 12/02/2014 09:00
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

public interface INET2Template {

	/**
	 * The purpose of this method is to accept a full file pathname as as
	 * parameter and determine if it exists on disk. If it does, return true,
	 * otherwise return false.
	 * 
	 * 
	 * @param strFileName
	 *            - full file pathname
	 * 
	 * @return true if file exists, otherwise false
	 */
	public boolean fileExists(String strFileName);

	/**
	 * The purpose of this method is to accept a full file pathname as a
	 * parameter, then check to see if the file exists. If it does, return the
	 * file contents as a string. This function should use the fileExists
	 * method. If the file does not exist, return a null.
	 * 
	 * 
	 * @param strFileName
	 *            - full file pathname
	 * 
	 * @return contents of file or null
	 */
	public String getFromFile(String strFileName);

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
	 * @param strTableName
	 *            - name of the table like grades or roster *NEW* strType - a
	 *            string of "schema" or "data"
	 * 
	 * @return the filename where the file was saved
	 */
	public String getNetFile(String strTableName, String strType);

	/**
	 * TThe purpose of this method is to accept a URL as a parameter and go to
	 * the Internet to download it. If there is no content to return, return a
	 * null
	 * 
	 * 
	 * @param strURL
	 *            - URL to travel to on the Internet *
	 * @return the web page contents or a null
	 */
	public String getURLRaw(String strURL);

	/**
	 * TThe purpose of this method is to accept a full file pathname along with
	 * the content to be saved as parameters and save it to the local drive
	 * 
	 * 
	 * @param strFileName
	 *            - - full file pathname strContent - - any string content
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean saveToFile(String strFileName, String strContent);
}
