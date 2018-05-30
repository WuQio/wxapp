package com.wuqio.call;

import com.wuqio.DAO.verseDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class call {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        System.out.println(map.toString());
        Process process = Runtime.getRuntime().exec("python3 D:\\py.py "+map);
        process.waitFor();
    }
}
