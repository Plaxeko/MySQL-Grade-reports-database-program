/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The DB2 class implements the DB2Template. Its purpose is to provide a generic
 * database interface for Microsoft Access databases. Other databases can be
 * implemented by just changing the openConnection method.
 * 
 * @version : - * 14.13 - 12/02/2014 09:00
 * @author : - John J. Couture S
 * 
 *         <dt><span class="strong">See Also:</span></dt>
 *         <dd>: - Serialized Form</dd>
 * 
 *         <dt><span class="strong">Studentid:</span></dt>
 *         <dd>: - 0795464</dd>
 * 
 *         <dt><span class="strong">Email:</span></dt>
 *         <dd>: - jcouture@sdccd.edu</dd>
 * 
 *         <dt><span class="strong">Assignment.number:</span></dt>
 *         <dd>: - A19015-02</dd>
 * 
 * 
 */
public interface DB2Template {

	/**
	 * The purpose of this method is to accept the filename of the Microsoft
	 * Access database and open a connection to it.
	 * 
	 * 
	 * 
	 * @param strDatabaseName
	 *            - the name of the database being used
	 * 
	 * @return true if open was successful, otherwise false
	 */
	public boolean openConnection(String strDatabaseName);

	/**
	 * The purpose of this method is to accept an SQL statement and query (view
	 * only) the dataset using the executeReader method
	 * 
	 * 
	 * 
	 * @param strSQL
	 *            - a fully formed SQL statement
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean query(String strSQL);

	/**
	 * The purpose of this method is to accept an SQL statement and update the
	 * dataset using the executeNonQuery method
	 * 
	 * 
	 * 
	 * @param strSQL
	 *            - a fully formed SQL statement
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean execute(String strSQL);

	/**
	 * The purpose of this method is to execute a read() method on the dataset
	 * and return a Boolean which indicates whether or not there are any more
	 * records in the dataset. Otherwise it is to return false
	 * 
	 * 
	 * 
	 * 
	 * @return true if there are more records in dataset, otherwise false
	 */
	public boolean moreRecords();

	/**
	 * The purpose of this method is to accept the name of the filed and return
	 * the contents of the field from the dataset for the current record
	 * 
	 * 
	 * 
	 * @param strFieldName
	 *            - the name of a field within the table
	 * 
	 * @return the contents of the field
	 */
	public String getField(String strFieldName);

	/**
	 * The purpose of this method is to accept an integer number indicating the
	 * position of the field within the dataset and return the field name of the
	 * field *
	 * 
	 * @param intFieldNum
	 *            - the position number of the field
	 * 
	 * @return the contents of the field
	 */
	public String getField(int intFieldNum);

	/**
	 * The purpose of this method is to terminate the connection to the
	 * database.
	 * 
	 * 
	 * 
	 */
	public void close();

	/**
	 * The purpose of this method is to delete all of the records that meed a
	 * specific condition. If no condition is specified than all records are
	 * deleted
	 * 
	 * @param strTableName
	 *            - the TableName followed by conditions
	 * 
	 */
	public void deleteAll(String strTable);

	/**
	 * The purpose of this method is to build and execute an SQL command that
	 * will look up a specific record in the database. If the record does not
	 * exist, it will create a blank record and update the key field. If the
	 * record already exists in the database, the method just returns to the
	 * calling program without updating the database.
	 * 
	 * @param strTableName
	 *            - name of the table like grades or roster strKeyName - name of
	 *            the field the db is index on, like stuid strKeyContents - this
	 *            is likely the studentID
	 * 
	 * @return true if record added, false if record not added
	 */
	public boolean checkRecord(String strTable, String strKeyName, String strKeyContents);

	/**
	 * The purpose of this method is to update a specific field within a
	 * specific record in the database
	 * 
	 * 
	 * @param strTableName
	 *            - name of the table like grades or roster strKeyName - name of
	 *            the field the db is index on, like stuid strKeyContents - this
	 *            is likely the studentID strFieldName - field to be updated
	 *            strFieldContents - contents of the field
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setField(String strTable, String strKeyName, String strKeyContents, String strFieldName,
			String strFieldContents);

	/**
	 * This method return the number of records in the active dataset
	 * 
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return number of records in the dataset as an integer
	 */
	public int getDBRecordCount(String strTableName);

	/**
	 * The purpose of this method is to display a message on the system console
	 * for debugging purposes
	 * 
	 * 
	 * @param strStudentID
	 *            - used to look up the record in database
	 * 
	 * @return strMsg - whatever you want displayed
	 */
	public void status(String strVar);
}