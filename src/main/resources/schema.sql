--
-- 由SQLiteStudio v3.1.1 产生的文件 周四 11月 23 10:40:37 2017
--
-- 文本编码：UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- 表：attach
DROP TABLE IF EXISTS [attach];

CREATE TABLE [attach] (
    fid         INTEGER    PRIMARY KEY AUTOINCREMENT,
    fname       CHAR (64),
    fkey        CHAR (128),
    ftype       CHAR (16),
    fsize       INTEGER,
    upload_time DATETIME
);


-- 表：comment
DROP TABLE IF EXISTS comment;

CREATE TABLE comment (
    coid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    cid           INTEGER,
    visitor_name  CHAR (32),
    visitor_email VARCHAR (128),
    visitor_url   VARCHAR (255),
    visitor_ip    CHAR (16),
    user_agent    VARCHAR (255),
    comment       VARCHAR (512),
    reply_to      INTEGER,
    root          INTEGER,
    create_time   DATETIME,
    update_time   DATETIME,
    status        CHAR (8) 
);


-- 表：content
DROP TABLE IF EXISTS content;

CREATE TABLE content (
    cid         INTEGER       PRIMARY KEY AUTOINCREMENT,
    ckey        VARCHAR (128),
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


-- 表：meta
DROP TABLE IF EXISTS meta;

CREATE TABLE meta (
    mid         INTEGER       PRIMARY KEY AUTOINCREMENT,
    meta_type   CHAR (16),
    meta_name   CHAR (32),
    create_time DATETIME,
    remark      VARCHAR (255) 
);


-- 表：option
DROP TABLE IF EXISTS option;

CREATE TABLE option (
    oid          INTEGER       PRIMARY KEY AUTOINCREMENT,
    option_key   CHAR (32),
    option_value VARCHAR (255),
    create_time  DATETIME,
    expire_time  DATETIME,
    remark       VARCHAR (255) 
);


-- 表：relation
DROP TABLE IF EXISTS relation;

CREATE TABLE relation (
    cid INTEGER NOT NULL,
    mid INTEGER NOT NULL,
    PRIMARY KEY (
        cid,
        mid
    )
);


-- 表：user
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    uid             INTEGER       PRIMARY KEY AUTOINCREMENT,
    username        CHAR (64),
    password        CHAR (128),
    nickname        CHAR (32),
    user_email      VARCHAR (128),
    user_url        VARCHAR (255),
    user_role       CHAR (16),
    create_time     DATETIME,
    update_password DATETIME,
    last_login      DATETIME
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
