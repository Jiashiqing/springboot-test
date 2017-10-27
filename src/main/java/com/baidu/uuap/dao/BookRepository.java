package com.baidu.uuap.dao;

import com.baidu.uuap.pojo.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}