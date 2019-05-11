package com.hundsun.jdbc;


import com.hundsun.thread.BizThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Date;

public class PressTest1 {
	private Logger logger = LoggerFactory.getLogger(BizThread.class);

	private Connection connection1;
	private Connection connection2;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		PressTest1 test1 = new PressTest1();
		test1.oracle1();

		test1.test();

	}

	private void oracle1() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.76.172:1521:ora11g";
		connection1 = DriverManager.getConnection(url, "fintcs", "Caifu123");

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url1 = "jdbc:oracle:thin:@192.168.76.173:1521:db";
		connection2 = DriverManager.getConnection(url1, "jy", "Caifu123");

	}


	private void test(){
		long current = System.currentTimeMillis();
		Statement st;
		Statement st1;
		try {

			int i=0;
			int a=0, b=0,c=0;
			while(i<2000){
				st = connection1.createStatement();
				st1 = connection2.createStatement();
				ResultSet rs = st.executeQuery("SELECT count(1) as total FROM TC_TCUSTRISKINFO");
				ResultSet rs1 = st1.executeQuery("SELECT count(1) as total FROM TC_TCUSTRISKINFO");

				while(rs.next() && rs1.next()){
					a = rs.getInt(1);
					b = rs1.getInt(1);
					logger.info("源库TC_TACCOREUQEST表记录数" + a +" " + "目标库TC_TACCOREUQEST表记录数" + b +" " + "差数" + (a-b)  );
					logger.info(i + " 目标库同步速度每秒" + (b-c));
					c = b;
					Thread.sleep(1000);
				}
				i++;
				st.close();
				st1.close();

			}
			connection1.close();
			connection2.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("cost is " + (System.currentTimeMillis()-current));
		System.out.println(new Date());
	}
	

	

}



