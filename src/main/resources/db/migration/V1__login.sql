CREATE TABLE `blog`.`login`
(
    `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `account`    VARCHAR(320) NOT NULL,
    `password`   VARCHAR(45)  NULL,
    `created_at` DATETIME     NOT NULL DEFAULT NOW(),
    `updated_at` DATETIME     NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (`id`),
    UNIQUE INDEX `account_UNIQUE` (`account` ASC) VISIBLE
);
