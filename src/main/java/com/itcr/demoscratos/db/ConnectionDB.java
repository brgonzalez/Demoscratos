package com.itcr.demoscratos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

final class ConnectionDB {
	
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	private ResultSetMetaData data;
	private String driver; 
	private String url;
	private String username;
	private String password;
	private final ArrayList<String> list = new ArrayList<String>();
	
	protected ConnectionDB(String driver, String url, String username, String password) {
		setDriver(driver);
		setUrl(url);
		setUsername(username);
		setPassword(password); }
	
	protected void connect() {
		try {
			Class.forName(driver); }
		catch (ClassNotFoundException e) {
			e.printStackTrace();	}
		try { 
			setConnection(DriverManager.getConnection(url, username, password));
			setStatement(connection.createStatement()); }
		catch (SQLException e) {
			e.printStackTrace(); } }
	
	protected void disconnect() {
		try { connection.close(); }
		catch (SQLException e) { e.printStackTrace(); } }
		
	private void setConnection(Connection connection) {
		this.connection = connection; }
		
	private void setStatement(Statement statement) {
		this.statement = statement; }
		
	private void setResult(ResultSet result) {
		this.result = result; }
		
	private void setData(ResultSetMetaData data) {
		this.data = data; }
	
	private void setDriver(String driver) {
		this.driver = driver; }
		
	private void setUrl(String url) {
		this.url = url; }
		
	private void setUsername(String username) {
		this.username = username; }
		
	private void setPassword(String password) {
		this.password = password; }

	protected ResultSet executeQuery(String query) {
		try { setResult(statement.executeQuery(query)); result.next(); }
		catch (SQLException e) { e.printStackTrace(); }
		return result; }
	
	protected void executeUpdate(String query) {
		try { statement.executeUpdate(query); }
		catch (SQLException e) { e.printStackTrace(); } }
	
	protected void setList(){
		list.clear();
		try {
			setData(result.getMetaData());
			while(result.next()) { 
				for(short i = 1; i <= data.getColumnCount(); i ++) {
					list.add(result.getString(i)); } } }
		catch (SQLException e) {
			e.printStackTrace(); } } }