create database agumon;
use agumon;

CREATE TABLE `dict_item`
(
    `id`               bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典项id',
    `dict_type_code`   varchar(32)         NOT NULL DEFAULT '' COMMENT '字典项类型编码',
    `dict_code`        varchar(64)         NOT NULL DEFAULT '' COMMENT '字典项编码',
    `dict_value`       varchar(4096)       NOT NULL DEFAULT '' COMMENT '字典项值',
    `dict_parent_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '字典项父编码',
    `dict_value_extra` varchar(4096)       NOT NULL DEFAULT '' COMMENT '字典项扩展值',
    `create_by`        bigint(20) unsigned          DEFAULT NULL COMMENT '创建者',
    `create_time`      bigint(20)                   DEFAULT NULL COMMENT '创建时间',
    `update_by`        bigint(20) unsigned          DEFAULT NULL COMMENT '更新者',
    `update_time`      bigint(20)                   DEFAULT NULL COMMENT '更新时间',
    `delete_flag`      tinyint(1) unsigned          DEFAULT NULL COMMENT '删除标识',
    PRIMARY KEY (`id`),
    KEY `IDX_CODE_TYPE` (`dict_code`, `dict_type_code`),
    KEY `IDX_TYPE` (`dict_type_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='字典项表';


CREATE TABLE `dict_type`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '字典类型id',
    `dict_type_code` varchar(32)         NOT NULL DEFAULT '' COMMENT '字典类型编码',
    `dict_type_name` varchar(64)         NOT NULL DEFAULT '' COMMENT '字典类型名称',
    `create_by`      bigint(20) unsigned          DEFAULT NULL COMMENT '创建者',
    `create_time`    bigint(20)                   DEFAULT NULL COMMENT '创建时间',
    `update_by`      bigint(20) unsigned          DEFAULT NULL COMMENT '更新者',
    `update_time`    bigint(20)                   DEFAULT NULL COMMENT '更新时间',
    `delete_flag`    tinyint(1) unsigned          DEFAULT NULL COMMENT '删除标识',
    PRIMARY KEY (`id`),
    KEY `IDX_TYPE_CODE` (`dict_type_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='字典类型表';