-- 配置場所が分からないけど、ddl.sqlは/static/dbフォルダに配置する予定


--mariadbに入る（実際のところ、ポート番号は異なる可能性大）
mysql -P 3308 -u root

-- データベースを作成し使用する
CREATE DATABASE transportation;
USE transportation;


-- ユーザーを作成し、権限を付与する
-- CREATE USER [ユーザ名]@[ホスト名] IDENTIFIED BY ['パスワード'];
-- GRANT [権限] ON [データベース名].[テーブル名] TO [ユーザ名]@[ホスト名];
CREATE USER admin@localhost IDENTIFIED BY 'password';
GRANT ALL ON transportation.* TO admin@localhost;


-- テーブルを作成する
-- CREATE TABLE post_cord(
--     カラム名 データ型 オプション,
--     PRIMARY KEY (カラム名),
--     FOREIGN KEY (カラム名) REFERENCES 参照先テーブル名(カラム名)
-- );

-- 静岡県郵便番号データ
CREATE TABLE post_cord(
    post_cord       varchar(8),
    prefecture      varchar(8) NOT NULL,
    city            varchar(32) NOT NULL,
    town            varchar(32) NOT NULL,
    y_coordinate    int NOT NULL,
    x_coordinate    int NOT NULL,
    PRIMARY KEY (post_cord)
);

-- ロジデータ
CREATE TABLE logi(
    id              varchar(8),
    name            varchar(8) NOT NULL,
    post_cord       varchar(8) NOT NULL,
    y_coordinate    int NOT NULL,
    x_coordinate    int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (post_cord) REFERENCES post_cord(post_cord)
);

-- 営業所データ
CREATE TABLE branch(
    id              varchar(8),
    name            varchar(8) NOT NULL,
    post_cord       varchar(8) NOT NULL,
    y_coordinate    int NOT NULL,
    x_coordinate    int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (post_cord) REFERENCES post_cord(post_cord)
);

-- 配達員データ
CREATE TABLE delivery_person(
    id              varchar(8),
    name            varchar(32) NOT NULL,
    kana_name       varchar(64) NOT NULL,
    tel             varchar(16) NOT NULL,
    belonging_to    varchar(8) NOT NULL,
    PRIMARY KEY (id)
);

-- トラックデータ
CREATE TABLE truck(
    id              varchar(8),
    belonging_to    varchar(8) NOT NULL,
    type            varchar(8) NOT NULL,
    capacity        int NOT NULL,
    fuel            int NOT NULL,
    PRIMARY KEY (id)
);

-- 配送情報 (timestamp型のデータの定義でエラーが起こるため苦肉の策です)
SET sql_mode = ALLOW_INVALID_DATES; 

CREATE TABLE delivery_info(
    id                      varchar(16),
    sender_name             varchar(32) NOT NULL,
    sender_kana_name        varchar(64) NOT NULL,
    sender_birth            date NOT NULL,
    sender_post_cord        varchar(8) NOT NULL,
    sender_address          varchar(64) NOT NULL,
    pickup_at               timestamp NOT NULL,
    receiver_name           varchar(32) NOT NULL,
    receiver_kana_name      varchar(64) NOT NULL,
    receiver_post_cord      varchar(8) NOT NULL,
    receiver_address        varchar(64) NOT NULL,
    delivery_at				timestamp NOT NULL,
    quantity                int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sender_post_cord) REFERENCES post_cord(post_cord),
    FOREIGN KEY (receiver_post_cord) REFERENCES post_cord(post_cord)
);


-- 配送状況
CREATE TABLE delivery_status(
    id                  varchar(8),
    delivery_info_id    varchar(16) NOT NULL,
    date_and_time       timestamp NOT NULL,
    delivery_status     varchar(8) NOT NULL,
    branch_or_logi      varchar(8) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (delivery_info_id) REFERENCES delivery_info(id)
);
