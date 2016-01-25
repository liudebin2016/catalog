## Jusfoun-Government Resources Catalog Platform
九次方-政府资源目录平台

### Project Introduction
Project info in the doc directory. 
### Technological Framework

Tech | Name | Version
-----|------|----
JDK    | Oracle JDK    | 1.8
Web Container    | Tomcat    | 8.0
MVC Framework   | Spring MVC    | 4.2.4
View TempLate    | Beetl    | 2.2.5
Authority Framework    | Shiro    | 1.2.3
DB    | MySQL    | 5.7.10
DB Connection Pool    | Druid    | 1.0.13
ORM    | MyBatis    | 3.1.8
Cache    | Redis    | 3.0.6
Cache Client    | Jedis    | 2.7.0
Building Tools    | Gradle    | 2.10
Code Manage Tools    | Git    | 2.5.4
IDE    | IDEA or Eclipse    | Latest edition

### Install Gradle

* The project used gradle to manage dependencies,source code compiled and so on.
* Download [gradle](http://gradle.org) to install and configs the path.
* On terminal,you can execute gradle command at anywhere.

### Quick Start
* `git clone http://gitlab.app/jusfoun/catalog.git`
* In your MySQL to create `catalog` database.
* Execute `catalog/db/init.sql` to create tables and initial datas.
* In the root of project directory execute `gradle idea` or `gradle eclipse` to generate IDE config file.
* execute `gradle apprun` to launch project. 




