## Sample Application for Coffee ordering

* Creates an order

-- POST /orders
---
```
curl --location --request POST 'http://localhost:8081/orders' --header 'Content-Type: application/json' 
--data-raw '{
    "description": "Coffee with Mocha",
    "customerId": "136",
    "status": "CREATED",
    "createdDate": null
}'
```
--

* Adds an Item to Order

-- POST /orders/{orderId}/items
---
```
curl --location --request POST 'http://localhost:8081/orders/18/items' \
--header 'Content-Type: application/json' \
--data-raw '{
    "description": "Mocha Item",
    "code": "Mocha-001",
    "price": 72.20
}'
```
--

* Retrieve order

-- GET /orders/{orderId}
---
```
curl --location --request GET 'http://localhost:8081/orders/18'
```
