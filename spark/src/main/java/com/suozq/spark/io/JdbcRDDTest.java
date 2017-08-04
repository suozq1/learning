package com.suozq.spark.io;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.rdd.JdbcRDD;

import scala.reflect.ClassManifestFactory;
import scala.runtime.AbstractFunction0;
import scala.runtime.AbstractFunction1;

public class JdbcRDDTest {
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static class User{
		private Integer id;
		private String name;
		private Integer age;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return name;
		}
	}
	public static class ConnectionFactory extends AbstractFunction0<Connection> implements Serializable {

		private static final long serialVersionUID = 2939541090701511444L;

		@Override
		public Connection apply() {
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
	}
	
	public static class MapRow extends AbstractFunction1<ResultSet,User> implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Override
		public User apply(ResultSet set) {
			User u=new User();
			try {
				u.setId(set.getInt(1));
				u.setName(set.getString(2));
				u.setAge(set.getInt(3));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return u;
		}
	}
	
	public static void main(String[] args) {
		SparkConf conf=new SparkConf().setMaster("local").setAppName("Jdbc");
		SparkContext sc = new SparkContext(conf);
		String sql="select * from user";
		JdbcRDD<User> jdbcRdd=new JdbcRDD<User>(sc,new ConnectionFactory(), sql, 1, 3, 2, new MapRow(), ClassManifestFactory.fromClass(User.class));
		System.out.println(jdbcRdd.collect().toString());
		
	}
}
