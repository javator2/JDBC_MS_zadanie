package com.sda.resolved;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class AbstractResolver <T> {

   public abstract T get(int id);
   public abstract List<T> get();
   public abstract boolean delete(int id) throws SQLException;
   public abstract boolean insert(Map<String, String> params) throws SQLException;
   public abstract boolean update(int id, Map<String,String> params) throws SQLException;
}
/*
+get(int id):T;
        +get():List<T>;
+delete(int id):boolean
        +insert(params:Map<String, String>):boolean
        +update(id:int, params:Map<String, String>):boolean*/
