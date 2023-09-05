package com.utp.interfaces;

import java.util.List;


public interface ICRUD <T>{
    Boolean insert(T t);
    Boolean update(T t);
    T selectById(Integer id);
    List<T> selectAll(); 
    void delete(Integer id);
    
}
