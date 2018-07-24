
由于执法规范化平台更新周期短，表结构变动快，需要管理的环境极多，所以需要对sql进行版本管理，在接入之前做一份调研确认flyway会对项目造成的影响。


1.完全初始化的情况。flyway会如预期的按序执行sql。

2.数据库中已有表的情况。需要设置flyway.baselineOnMigrate=true 和配置目前sql从哪个版本开始执行flyway.setBaselineVersion(MigrationVersion.fromVersion("1.1"))。

3.如果其中一条执行错误，flyway会终止执行其他的sql执行并报错，需要人工介入改正数据库。

4.如果success为0，flyway会终止程序并报错。

5.测试发现flyway对checksum有一些奇怪的现象，改变表结构会造成checksum无法验证通过，但是删除最后一条记录，checksum又通过了，这个需要进一步研究，建议不要依赖这个值，如果执行错误需要把schema_version表删除并设置baseVersion。

6.可以通过设置不同的location来设置不同的sql版本（比如海外版）。
