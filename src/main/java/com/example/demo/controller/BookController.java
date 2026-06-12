package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 图书控制器 - MVC
 *
 * TODO: 实现以下REST API
 *
 * 【MVC】处理HTTP请求，返回JSON
 *
 * GET    /books             - 查询所有图书
 * GET    /books/{id}        - 根据ID查询图书
 * GET    /books/isbn/{isbn} - 根据ISBN查询
 * GET    /books/search      - 搜索图书(keyword参数)
 * POST   /books             - 添加图书
 * PUT    /books/{id}        - 更新图书信息
 * DELETE /books/{id}        - 删除图书
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // TODO: 自行实现各个接口
}