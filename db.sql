-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Мар 15 2012 г., 07:42
-- Версия сервера: 5.5.8
-- Версия PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `hibernate_basics`
--

-- --------------------------------------------------------

--
-- Структура таблицы `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `article`
--

INSERT INTO `article` (`id`, `title`, `message`, `user_id`) VALUES
(1, 'advert title', 'advert message', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `title`) VALUES
(1, 'mycat');

-- --------------------------------------------------------

--
-- Структура таблицы `category_article`
--

CREATE TABLE IF NOT EXISTS `category_article` (
  `categories_id` bigint(20) NOT NULL,
  `articles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`categories_id`,`articles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Дамп данных таблицы `category_article`
--

INSERT INTO `category_article` (`categories_id`, `articles_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `hb_user`
--

CREATE TABLE IF NOT EXISTS `hb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `hb_user`
--

INSERT INTO `hb_user` (`id`, `name`, `password`) VALUES
(3, 'oleg', '1');
