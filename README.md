## Ürün - Yorum uygulamamda kullandığım temel yapılar 
- Java 17
- Spring Boot
- Spring MVC
- Spring Data
- Spring Rest (http status)
- H2Database
- Postman
- Lombok

---

## Özet 
> Oluşturduğum 3 Entity (User, Product, ProductComment) ile Controller üzerinden verileri
> Dto' lar ile alarak Post ve Get metotları ile işledim. Controller' da ResponseEntity<>
> yapısından da faylandım. Verileri @RequestBody ve @Pathparam 'lar ile aldım.
> Service kısmında öncelikle Service interfacelerini oluşturarak onların implemantasyonları 
> ile işlemleri gerçekleştirdim. 
> Repository kısmında CrudRepository' i extend ederek gerekli query yapılarını ekledim. 

---
```sh 
1. User kaydı (POST)
http://localhost:8080/user/save-user
{
  "name": "ali",
  "lastName": "veli",
  "email": "a@deneme.com",
  "phoneNumber": 532555666312433
}
2. Product kaydı (POST)
http://localhost:8080/products/save-product
{
  "productName": "urun",
  "productPrice": 32.45,
  "expireDate": 2022-11-11
}
3. ProductComment kaydı (POST)
http://localhost:8080/comments/save-comment
{
  "comment": "yeni yorum ",
  "userId": 1,
  "productId": 1
}
```
```sh 
4. Verilen tarihte son kullanması geçen product'lar (GET)
http://localhost:8080/products/check-expired/15.11.2022 17:50:00
5. Verilen tarihte son kullanması geçmeyen ve tarih verisi olmayan product'lar (GET)
http://localhost:8080/products/check-not-expired/15.11.2022 15:15:15
6. UserId si verilen user' ın yaptığı tüm yorumlar  (GET)
http://localhost:8080/comments/user-id/1
7. UserId si verilen user ' ın belli bir tarih aralığındaki tüm yorumları (GET)
http://localhost:8080/comments/user-id/1/09.09.2022  20:15:00/09.09.2022  20:16:00
8. ProductId' si verilen bir ürüne ait tüm yorumlar  (GET)
http://localhost:8080/comments/product-id/1
9. ProductId' si verilen ürün için belli tarih aralığındaki tüm yorumlar (GET) 
http://localhost:8080/comments/product-id/1/09.09.2022  20:15:00/09.09.2022  20:16:00

```
---


