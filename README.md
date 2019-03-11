# [Docker Compose with Spring Boot, MySQL, NGINX](https://hellokoding.com/docker-compose-with-spring-boot-mysql-nginx/)

## About project
- This project is based on Java Spring and VueJS and MySQL. The people who want to take
survey can use and admin will create surveys and cen see results.

## What you'll build
- A simple Spring Boot application with MySQL and NGINX running inside Docker containers

## What you'll need
- Docker CE , container for mysql : some-mysql, image for mysql : mysql/mysql-server:5.7
- Then need to create database : tdb_survey
- Then, Execute following command to access mysql : docker exec -it some-mysql bash
- Then, we need to create admin user : First access mysql : mysql -u root -p : pass: root
- Then, execute following query: insert into admin (user_name, email, password, created_date)
values ('duk', 'duk@gmail.com', 'root', '2019-03-11');

In our system, we have only one admin who can log in and create serveys. And everyone can take surveys
So they do not need to log in.

## Stack
- Docker - 2.0.0
- Java - 8
- Spring Boot - 2.1.3
- MySQL - 5.7
- NGINX
- Maven

## Run
- Run command `docker-compose up`
- Access to http://localhost/
