package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.List;


/**
 * 图书服务层接口
 */
public interface BookService {

    /**
     * 添加图书
     * - 校验ISBN唯一性
     * - 初始化可借数量和总数量
     */
    Book addBook(Book book);

    /**
     * 根据ID查询图书
     */
    Book getById(Long id);

    /**
     * 根据ISBN查询图书
     */
    Book getByIsbn(String isbn);

    /**
     * 查询所有图书
     */
    List<Book> getAll();

    /**
     * 按书名或作者搜索图书
     */
    List<Book> search(String keyword);

    /**
     * 更新图书信息
     */
    Book update(Book book);

    /**
     * 删除图书
     * - 检查是否有未归还借阅记录
     */
    void delete(Long id);
}
