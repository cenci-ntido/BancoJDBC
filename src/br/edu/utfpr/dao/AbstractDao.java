package br.edu.utfpr.dao;

public interface AbstractDao<T> {
   public T insert(T obj);
}
