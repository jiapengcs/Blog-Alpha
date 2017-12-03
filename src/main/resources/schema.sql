--
-- 由SQLiteStudio v3.1.1 产生的文件 周四 11月 23 20:09:19 2017
--
-- 文本编码：UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- 表：comment
CREATE TABLE IF NOT EXISTS comment (
    coid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    cid           INTEGER,
    visitor_name  CHAR (16),
    visitor_email VARCHAR (128),
    visitor_url   VARCHAR (128),
    visitor_ip    VARCHAR (48),
    user_agent    VARCHAR (128),
    comment       VARCHAR (255),
    root          INTEGER,
    create_time   DATETIME,
    update_time   DATETIME,
    status        CHAR (8) 
);


-- 表：content
CREATE TABLE IF NOT EXISTS content (
    cid         INTEGER       PRIMARY KEY AUTOINCREMENT,
    content_key VARCHAR (128),
    title       VARCHAR (128),
    thumb_image VARCHAR (128),
    content     TEXT,
    edit_type   CHAR (16),
    format      CHAR (16),
    create_time DATETIME,
    update_time DATETIME,
    status      CHAR (8),
    hits        INTEGER
);


-- 表：file
CREATE TABLE IF NOT EXISTS file (
    fid         INTEGER    PRIMARY KEY AUTOINCREMENT,
    file_name   CHAR (64),
    file_type   CHAR (16),
    file_path   CHAR (128),
    file_size   INTEGER,
    upload_time DATETIME
);


-- 表：log
CREATE TABLE IF NOT EXISTS log (
    lid         INTEGER       PRIMARY KEY AUTOINCREMENT,
    uri         VARCHAR(128),
    method      VARCHAR(255),
    args        VARCHAR(255),
    ip          VARCHAR(48),
    exception   VARCHAR(255),
    message     VARCHAR(255),
    cost        INTEGER,
    log_time    DATETIME
);


-- 表：meta
CREATE TABLE IF NOT EXISTS meta (
    mid         INTEGER       PRIMARY KEY AUTOINCREMENT,
    meta_type   CHAR (16),
    meta_name   CHAR (32),
    create_time DATETIME,
    remark      VARCHAR (255) 
);


-- 表：option
CREATE TABLE IF NOT EXISTS option (
    oid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    option_key   CHAR (32),
    option_value VARCHAR (128),
    create_time  DATETIME,
    expire_time  DATETIME,
    remark       VARCHAR (255)
);


-- 表：relation
CREATE TABLE IF NOT EXISTS relation (
    rid INTEGER PRIMARY KEY AUTOINCREMENT,
    cid INTEGER NOT NULL,
    mid INTEGER NOT NULL
);


-- 表：user
CREATE TABLE IF NOT EXISTS user (
    uid             INTEGER       PRIMARY KEY AUTOINCREMENT,
    username        CHAR (16),
    password        CHAR (128),
    nickname        CHAR (16),
    user_email      VARCHAR (128),
    user_url        VARCHAR (128),
    user_role       CHAR (16),
    create_time     DATETIME,
    update_time     DATETIME,
    last_login      DATETIME
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
