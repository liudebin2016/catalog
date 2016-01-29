1、使用oracle的sqldeveloper将mysql的表结构迁移到oracle中

2、表结构迁移完后，使用Navicat Premium先将mysql表的表的数据导出为csv，然后再将csv数据导入至oracle中即可。

3、由于mysql的主键id自增与oracle不同，故需要将设置oracle的seq和trigger
