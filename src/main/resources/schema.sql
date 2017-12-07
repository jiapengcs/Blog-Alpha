--
-- 由SQLiteStudio v3.1.1 产生的文件 周四 11月 23 20:09:19 2017
--
-- 文本编码：UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- 表：attachment
CREATE TABLE IF NOT EXISTS attachment (
    fid         INTEGER        PRIMARY KEY AUTOINCREMENT,
    file_name   VARCHAR (64),
    file_type   VARCHAR (16),
    file_path   VARCHAR (255),
    cdn_path    VARCHAR (255),
    file_size   INTEGER,
    upload_time DATETIME
);


-- 表：comment
CREATE TABLE IF NOT EXISTS comment (
    coid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    cid           INTEGER,
    visitor_name  VARCHAR (16),
    visitor_email VARCHAR (128),
    visitor_url   VARCHAR (128),
    visitor_ip    VARCHAR (48),
    user_agent    VARCHAR (128),
    comment       VARCHAR (255),
    root          INTEGER,
    create_time   DATETIME,
    update_time   DATETIME
);


-- 表：content
CREATE TABLE IF NOT EXISTS content (
    cid         INTEGER       PRIMARY KEY AUTOINCREMENT,
    content_key VARCHAR (32),
    title       VARCHAR (64),
    thumb_image VARCHAR (128),
    content     TEXT,
    edit_type   VARCHAR (16),
    format      VARCHAR (16),
    create_time DATETIME,
    update_time DATETIME,
    status      VARCHAR (16),
    hits        INTEGER
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
    meta_type   VARCHAR (16),
    meta_name   VARCHAR (32),
    create_time DATETIME,
    remark      VARCHAR (255) 
);


-- 表：option
CREATE TABLE IF NOT EXISTS option (
    oid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    option_key   VARCHAR (32),
    option_value VARCHAR (128),
    create_time  DATETIME,
    expire_time  DATETIME,
    remark       VARCHAR (255)
);


-- 表：picture
CREATE TABLE IF NOT EXISTS picture (
    pid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    subject      VARCHAR (16),
    location     VARCHAR (16),
    description  VARCHAR (128),
    file_path    VARCHAR (255),
    cdn_path     VARCHAR (255),
    film_time    DATETIME,
    upload_time  DATETIME
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
    username        VARCHAR (16),
    password        VARCHAR (128),
    nickname        VARCHAR (16),
    user_email      VARCHAR (128),
    user_url        VARCHAR (128),
    user_role       VARCHAR (16),
    create_time     DATETIME,
    update_time     DATETIME,
    last_login      DATETIME
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
