package com.itcr.demoscratos.db;

public class TestDB {

	public static void main(String[] args) {
		ConnectionDB c = new ConnectionDB("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/Demoscratos","root","root");
		c.connect();
	}

}
