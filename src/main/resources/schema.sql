//学生
CREATE TABLE IF NOT EXISTS student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '学生ID',
    name VARCHAR(100) NOT NULL COMMENT '学生姓名',
    student_no VARCHAR(50) NOT NULL UNIQUE COMMENT '学号',
    class_name VARCHAR(100) COMMENT '班级',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    INDEX idx_student_no (student_no)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';


CREATE TABLE IF NOT EXISTS book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '图书ID',
    isbn VARCHAR(50) NOT NULL UNIQUE COMMENT 'ISBN编号',
    name VARCHAR(200) NOT NULL COMMENT '书名',
    author VARCHAR(100) COMMENT '作者',
    total_count INT NOT NULL DEFAULT 1 COMMENT '馆藏总数',
    available_count INT NOT NULL DEFAULT 1 COMMENT '可借数量',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
    INDEX idx_isbn (isbn),
    INDEX idx_name (name)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图书表';


CREATE TABLE IF NOT EXISTS borrow_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '记录ID',
    student_id BIGINT NOT NULL COMMENT '学生ID',
    book_id BIGINT NOT NULL COMMENT '图书ID',
    borrow_date DATETIME NOT NULL COMMENT '借书日期',
    due_date DATETIME NOT NULL COMMENT '应还日期',
    return_date DATETIME COMMENT '实际归还日期',
    status VARCHAR(20) NOT NULL DEFAULT 'BORROWED' COMMENT '状态: BORROWED借出/RETURNED已归还/OVERDUE逾期',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    INDEX idx_student_id (student_id),
    INDEX idx_book_id (book_id),
    INDEX idx_status (status),
    INDEX idx_due_date (due_date),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='借阅记录表';


//常用
INSERT INTO student (name, student_no, class_name) VALUES ('张三', '2024001', '计算机1班');
INSERT INTO book (isbn, name, author, total_count, available_count) VALUES ('111-1-111-11111-1', 'Java编程思想', 'Bruce Eckel', 5, 5);
SELECT * FROM student;
SELECT * FROM book;
UPDATE student SET class_name = '计算机2班' WHERE id = 1;
DELETE FROM student WHERE id = 1;