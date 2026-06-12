package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//图书数据访问层
//book类：
//    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '图书ID',
//    isbn VARCHAR(50) NOT NULL UNIQUE COMMENT 'ISBN编号',
//    name VARCHAR(200) NOT NULL COMMENT '书名',
//    author VARCHAR(100) COMMENT '作者',
//    total_count INT NOT NULL DEFAULT 1 COMMENT '馆藏总数',
//    available_count INT NOT NULL DEFAULT 1 COMMENT '可借数量',
//    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
//    INDEX idx_isbn (isbn),
//    INDEX idx_name (name)

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //插入图书
    public int insert(Book book) {
        String sql= "INSERT INTO book(isbn, name, author, total_count, available_count, created_at) VALUES(?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                book.getIsbn(),
                book.getName(),
                book.getAuthor(),
                book.getTotalCount(),
                book.getAvailableCount(),
                book.getCreatedAt()
        );
    }

    //据ID查询
    public Book findById(Long id) {
        String sql= "SELECT id, isbn, name, author, total_count AS totalCount, available_count AS availableCount, created_at AS createdAt FROM book WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    //查询全部
    public List<Book> findAll(){
        String sql= "SELECT id, isbn, name, author, total_count AS totalCount, available_count AS availableCount, created_at AS createdAt FROM book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    //更新书
    public int update(Book book) {
        String sql = "UPDATE book SET isbn=?, name=?, author=?, total_count=?, available_count=? WHERE id=?";
        return jdbcTemplate.update(sql,
                book.getIsbn(),
                book.getName(),
                book.getAuthor(),
                book.getTotalCount(),
                book.getAvailableCount(),
                book.getId()
        );
    }

    //删除书
    public int deleteById(Long id){
        String sql= "DELETE FROM book WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    //通过ISBN诏书
    public Book findByIsbn(String isbn){
        String sql= "SELECT id, isbn, name, author, total_count AS totalCount, available_count AS availableCount, created_at AS createdAt FROM book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), isbn);
    }

    //更新可借书数目，delta: 借书-1, 还书+1
    public int updateAvailableCount(Long id, int delta){
        String sql= "UPDATE book SET available_count = available_count+? WHERE id=?";
        return jdbcTemplate.update(sql, delta, id);
    }
}