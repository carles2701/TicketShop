TicketShop

**Spring Boot Java CRUD Application with Thymeleaf and H2 Database**

#Properties

spring.h2.console.enabled=true

spring.datasource.url=jdbc:h2:file:./db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

server.port=8080

#Page Templates

    localhost:8080/admin
    Admin Page
    localhost:8080/admin/artists
    List of Artists Page
    localhost:8080/admin/artists/add
    Artist Add Page
    localhost:8080/admin/artists/delete/{id}
    Delete selected Artist
    localhost:8080/admin/artists/update/{id}
    Edit selected Artist
    localhost:8080/admin/tickets
    List of Tickets Page
    localhost:8080/admin/tickets/add
    Ticket Add Page
    localhost:8080/admin/tickets/update/{id}
    Edit selected Ticket
    localhost:8080/admin/tickets/delete/{id}
    Delete selected Ticket
    
    localhost:8080{"/","/home","/index"}
    Home Page
    localhost:8080/shop/artist/{id}
    Filter Artist on Shop Page
    localhost:8080/shop
    Shop Page

    localhost:8080/addToCart/{id}
    Adding Ticket to Shopping Cart
    localhost:8080/cart
    Shopping cart page
    localhost:8080/cart/removeItem/{index}
    Delete Ticket from shopping cart
    localhost:8080/summary
    Summary Page