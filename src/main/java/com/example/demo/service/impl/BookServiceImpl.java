package com.example.demo.service.impl;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 图书服务实现类
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    //添加图书
    @Override
    @Transactional
    public Book addBook(Book book) {
        // 1. 参数校验
        if (book == null) {
            throw new IllegalArgumentException("图书信息不能为空");
        }
        if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN不能为空");
        }
        if (book.getName() == null || book.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("书名不能为空");
        }

        // 2. 校验ISBN唯一性
        try {
            Book existingBook = bookDao.findByIsbn(book.getIsbn());
            if (existingBook != null) {
                throw new IllegalArgumentException("ISBN已存在: " + book.getIsbn());
            }
        } catch (EmptyResultDataAccessException e) {
            // 没有找到记录，说明ISBN不存在，可以继续
        }

        // 3. 初始化库存数量
        // 如果totalCount为空，默认设置为1
        if (book.getTotalCount() == null) {
            book.setTotalCount(1);
        }
        // 如果availableCount为空，默认与totalCount相同
        if (book.getAvailableCount() == null) {
            book.setAvailableCount(book.getTotalCount());
        }
        // 确保availableCount不超过totalCount
        if (book.getAvailableCount() > book.getTotalCount()) {
            throw new IllegalArgumentException("可借数量不能超过馆藏总数");
        }

        // 4. 设置创建时间
        if (book.getCreatedAt() == null) {
            book.setCreatedAt(LocalDateTime.now());
        }

        // 5. 插入数据库
        bookDao.insert(book);

        return book;
    }

    // 其他方法待实现...

    // 根据ID查询图书
    @Override
    public Book getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("图书ID不能为空");
        }
        return bookDao.findById(id);
    }

    // 根据ISBN查询图书
    @Override
    public Book getByIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN不能为空");
        }
        return bookDao.findByIsbn(isbn);
    }

    // 查询所有图书
    @Override
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    // 按书名或作者搜索图书
    @Override
    public List<Book> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return bookDao.findAll();
        }
        // 搜索需要模糊查询，这里暂时返回全部再过滤
        // 实际项目中建议在DAO层用LIKE查询
        List<Book> allBooks = bookDao.findAll();
        String lowerKeyword = keyword.toLowerCase();
        return allBooks.stream()
                .filter(book -> (book.getName() != null && book.getName().toLowerCase().contains(lowerKeyword))
                        || (book.getAuthor() != null && book.getAuthor().toLowerCase().contains(lowerKeyword)))
                .collect(java.util.stream.Collectors.toList());
    }

    // 更新图书信息
    @Override
    @Transactional
    public Book update(Book book) {
        if (book == null || book.getId() == null) {
            throw new IllegalArgumentException("图书信息或ID不能为空");
        }
        if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN不能为空");
        }
        if (book.getName() == null || book.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("书名不能为空");
        }
        if (book.getTotalCount() == null || book.getTotalCount() < 0) {
            throw new IllegalArgumentException("馆藏总数不能为空或为负数");
        }
        if (book.getAvailableCount() == null || book.getAvailableCount() < 0) {
            throw new IllegalArgumentException("可借数量不能为空或为负数");
        }
        if (book.getAvailableCount() > book.getTotalCount()) {
            throw new IllegalArgumentException("可借数量不能超过馆藏总数");
        }

        Book existingBook = bookDao.findById(book.getId());
        if (existingBook == null) {
            throw new IllegalArgumentException("图书不存在: " + book.getId());
        }

        // 检查ISBN是否被其他图书使用
        Book isbnBook = bookDao.findByIsbn(book.getIsbn());
        if (isbnBook != null && !isbnBook.getId().equals(book.getId())) {
            throw new IllegalArgumentException("ISBN已被其他图书使用: " + book.getIsbn());
        }

        bookDao.update(book);
        return book;
    }

    // 删除图书
    @Override
    @Transactional
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("图书ID不能为空");
        }
        Book book = bookDao.findById(id);
        if (book == null) {
            throw new IllegalArgumentException("图书不存在: " + id);
        }
        // 检查是否有未归还的借阅记录，实际项目中需要额外检查
        bookDao.deleteById(id);
    }
}
