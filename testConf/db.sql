CREATE TABLE `configuration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `value` varchar(100) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `application_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


INSERT INTO configuration
(id, name, `type`, value, is_active, application_name)
VALUES(1, 'SiteName', 'String', 'trendyol.com', 1, 'SERVICE-A');
INSERT INTO configuration
(id, name, `type`, value, is_active, application_name)
VALUES(2, 'IsBasketEnable

d', 'Boolean', '1', 1, 'SERVICE-B');
INSERT INTO configuration
(id, name, `type`, value, is_active, application_name)
VALUES(4, 'deneme', 'Boolean', '1', 0, 'SERVICE-B');
INSERT INTO configuration
(id, name, `type`, value, is_active, application_name)
VALUES(5, 'deneme', 'Boolean', '1', 1, 'SERVICE-B');
INSERT INTO configuration
(id, name, `type`, value, is_active, application_name)
VALUES(6, '3', 'Boolean', '1', 0, 'SERVICE-B');
INSERT INTO configuration
(id, name, `type`, value, is_active, application_name)
VALUES(3, 'MaxItemCount', 'Int', '56', 1, 'SERVICE-A');