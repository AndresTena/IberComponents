# IberComponents
Repositorio creado para realizar el trabajo de DAD 2023.

https://www.youtube.com/watch?v=2k4kokXPQxc&ab_channel=MewtwoPerfectionist

## Fase 1 ✔️
### Temática 

La temática de este proyecto va a ser una tienda de compra-venta de componentes de PC 💻, donde los usuarios podrán registrarse y comprar componentes de PC, añadirlos al carrito 🛒.

### Funcionalidades públicas
Navegar por la web observando los distintos productos disponibles.

### Funcionalidades privadas
Poder realizar compras 🛍️.

Añadir al carrito 🛒 .

### Entidades principales

Usuario 👨🏽‍💻: cliente que compra productos

Producto 📲: elementos que el cliente compra

Carrito 🛒 : lista de productos a comprar

Pedido 📦: compra de los productos por parte del usuario

Review ✨: puntuación de los usuarios sobre un producto

### Funcionalidades del servicio interno 

Envío de correo electrónico al crear cuenta para confirmar

Envio de correo electrónico con el pedido realizado 

## Fase 2
### Capturas de pantalla de la aplicación
![alt imagen 1](https://github.com/AndresTena/IberComponents/blob/main/Imagen1.png)


Página principal, en la cual se exponen los productos disponibles para adquirir.


![alt imgagen 2](https://github.com/AndresTena/IberComponents/blob/main/Imagen2.png)


Página desde la cual se puede “logear” el usuario, es decir, dicha página se utilizará cuando el usuario ya esté previamente registrado. Se necesitará un usuario y una contraseña.


![alt imgagen 3](https://github.com/AndresTena/IberComponents/blob/main/Imagen3.png)


Si es la primera vez que el usuario entra en la página, este utilizará esta página para registrarse. Para ello será necesario un nombre, una dirección de correo y una contraseña.


![alt imgagen 4](https://github.com/AndresTena/IberComponents/blob/main/Imagen4.png)


 Página diseñada para añadir un nuevo producto a la página para el cual habrá que definir su nombre, descripción, características, precio e imagen si es que la tiene.


![alt imgagen 5](https://github.com/AndresTena/IberComponents/blob/main/Imagen5.png)


Página que muestra los detalles del producto seleccionado en la página principal, en dicha página se podrá añadir el producto al carrito.


![alt imgagen 6](https://github.com/AndresTena/IberComponents/blob/main/Imagen6.png)


Página que muestra los productos añadidos al carrito.


![alt imgagen 7](https://github.com/AndresTena/IberComponents/blob/main/imagen7.PNG)


 Página que muestra todos los pedidos que se ha realizado en la página web
 
 
 ### Diagrama de navegración
 
 
![alt diagrama de navegacion](https://github.com/AndresTena/IberComponents/blob/main/DiagramaNavegacion.png)


### Diagrama de UML


![alt diagrama UML](https://github.com/AndresTena/IberComponents/blob/main/IberComponents.png)

### Modelo Entidad-Relacion

![alt entidad-relacion](https://github.com/AndresTena/IberComponents/blob/main/Entidad-Relacion-DAW.png)

## Fase 3
### Instrucciones para desplegar la aplicación en la máquina virtual.
#### En primer lugar se deberán generar un par de claves, una pública y una privada.

#### En segundo lugar se deberá generar una instancia en openstack e intalarle el sistema operativo ubuntu, además de adjuntar la clave pública del par de claves creado a dicha máquina. 

#### Para subir ficheros a dicha máquina lo podremos hacer con el comando: 

scp -i ibercomponents-urjc.pem <fichero_adjunto> ubuntu@10.100.139.247:/home/ubuntu

#### En nuestro caso hemos tenido que subir los siguientes ficheros .jar: 

scp -i ibercomponents-urjc.pem IberComponents-0.0.1-SNAPSHOT.jar ubuntu@10.100.139.247:/home/ubuntu

scp -i ibercomponents-urjc.pem ServicioInterno-0.0.1-SNAPSHOT.jar ubuntu@10.100.139.247:/home/ubuntu

scp -i ibercomponents-urjc.pem 7.png ubuntu@10.100.139.247:/home/ubuntu/src/main/resources/static/images

scp -i ibercomponents-urjc.pem 8.png ubuntu@10.100.139.247:/home/ubuntu/src/main/resources/static/images

scp -i ibercomponents-urjc.pem 9.png ubuntu@10.100.139.247:/home/ubuntu/src/main/resources/static/images

scp -i ibercomponents-urjc.pem 10.png ubuntu@10.100.139.247:/home/ubuntu/src/main/resources/static/images

#### A continuación para conectarnos a dicha máquina se utilizará el comando: 

ssh -i ibercomponents-urjc.pem ubuntu@10.100.139.247

#### Estas imagenes serán necesarias para cargar los primeros productos que se encuentran por defecto en la página principal. Una vez subidos los ficheros .jar y todas las imagenes necesarias. 

#### Antes de ejecutar los ficheros jar se deberá instalar java mediante el comando:

sudo apt install openjdk-17-jre-headless

#### También se deberá instalar rabbitmq en la máquina, ya que este será utilizado por nuestro servicio interno: 

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management


#### También se deberá crear la base de datos, usada por nuestra aplicación, para ello será necesario instalar mysql en la máquina y realizar la siguiente configuración: 


Instalar MySQL: sudo apt install mysql-server

Iniciar MySQL: sudo service mysql start

Acceder a la consola de MySQL: sudo mysql

#### Dentro de la consola mysql se deberán ejecutar los siguientes comandos para permitir el acceso a la base de datos de nuestra aplicación:

mysql > create database sql_db; --base de datos que utilizará nuestra aplicación

mysql > ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';


#### De esta manera la aplicación podrá acceder a la base de datos con el usuario root.


#### Después de esto nuestra aplicación estará lista para ejecutarse y para ello se utilizarán los siguientes comandos: 

java -jar IberComponents-0.0.1-SNAPSHOT.jar

java -jar ServicioInterno-0.0.1-SNAPSHOT.jar

#### Finalmente, se deberá abrir el puerto 8443 en la máquina virtual, para poder conectarnos a ella mediante la ruta: 

https://10.100.139.247:8443

### Nuevo diagrama UML


![alt nuevo UML](https://github.com/AndresTena/IberComponents/blob/main/UMLFase3.jpeg)


### Servicio interno.

Se ha utilizado rabbitmq con un esquema de productor consumidor, en el que el productor es la aplicación principal y el consumidor la aplicación de servicio interno, que se encarga de enviar correos a los nuevos usuarios que se registren.


## Fase 4

### Diagrama OpenStack.

![alt diagrama OpenStack](https://github.com/AndresTena/IberComponents/blob/main/DiagramaOpenStack.png)
