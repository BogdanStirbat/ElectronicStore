A project for integrating Apache Ignite as a Hibernate L2 cache.

Before you run the project, you can either comment the set for 'hibernate.javax.cache.uri' (HibernateConfig.java), either run Apache Ignite locally.

Script for DB creation is in file create_db.sql.

How to build the project:
```shell
  mvn clean install
```

How to run the project:
```shell.
  java -jar target/ElectronicStore.jar port:8081
```

The port part is optional. If not used, 8080 will be taken


