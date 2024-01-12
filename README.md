## OBO STADIUM WEBSITE
Trang thương mại điện tử bán giày

Link demo: http://103.237.147.34:8889

### Chạy app bằng maven
```shell
mvn spring-boot:run
```

### Triển khai ứng dụng
Sử dụng docker-compose để triển khai ứng dụng

```
docker-compose up -d
```

### Mockup dữ liệu ban đầu cho ứng dụng
Import file `data.sql` vào MySQL. Sử dụng 2 account sau để đăng nhập vào web:

- Admin account:
    - Username: admin@obostadium.com
    - Password: 123456
- Member account:
    - Username: monguyen@gmail.com
    - Password: 123456


Truy cập `/admin` để vào trang admin.

### Built with
- [Java Spring](https://spring.io/) - The web framework used
- [Maven](https://mvnrepository.com/) - Dependency Management