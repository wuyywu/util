package com.hundsun.jdbc;

import java.io.*;
import java.sql.*;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/5/3 20:51
 */
public class SpileFile {

    private Connection connection;

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        SpileFile spileFile = new SpileFile();
        System.out.println("--------------begin");
        spileFile.spilt();
        System.out.println("--------------OK");
    }

    public void spilt() throws IOException, SQLException, ClassNotFoundException {
        InputStream ins = null;
        BufferedReader reader = null;
        BufferedWriter out = null;
        String filePath = "C:\\Users\\wuyun11584\\Desktop\\Confirm(1)\\OFD_64_264_20190423_05.TXT";
        String newFilePath = "C:\\Users\\wuyun11584\\Desktop\\Confirm(1)\\new\\OFD_64_264_20190423_05.TXT";

        ins = new FileInputStream(new File(filePath));
        reader = new BufferedReader(new InputStreamReader(ins, "GBK"));

        File writename = new File(newFilePath);
        writename.createNewFile();
        out = new BufferedWriter(new FileWriter(writename));

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@10.20.35.217:1521:orcl";

        if (connection == null) {
            connection = DriverManager.getConnection(url, "liquidate", "liquidate");
        }

        String sql = "select c_cust_type from lc_taccoinfo where vc_trade_acco = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);



        String line;
        int dataLine=0;
        while ((line = reader.readLine()) != null){
            dataLine ++;
            //数据行开始
            if (dataLine > 31){
                String tradeAcco = line.substring(47,53);
                String custType = "";
                stmt.setString(1, tradeAcco);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    custType = rs.getString("c_cust_type");
                }

                if ("1".equals(custType)){
                    continue;
                }
            }

            out.write(line+"\r\n");
            out.flush();
        }

        reader.close();
        ins.close();
        out.close();
    }


}
