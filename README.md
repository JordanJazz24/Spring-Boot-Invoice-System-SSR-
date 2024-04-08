En este proyecto se debe crear un sistema WEB en Java para la gestión de Facturas electrónicas, almacenando los datos en
una base de datos MySql.
El sistema permitirá tanto a personas físicas como jurídicas (empresas) registrarse como Proveedores de bienes o servicios
y hacer facturación electrónica de las ventas que hacen a sus Clientes. Tanto las Proveedores como los Clientes deben estar
previamente inscritos en los sistemas de Hacienda (revisar sección Notas).
Funcionalidad
El sistema debe incluir al menos las siguientes funcionalidades:
1. Registro de Proveedor: Un proveedor podrá registrase en el sistema y utilizarlo.
2. Configurar su perfil: Una vez que su registro haya sido aceptado, el proveedor podrá configurar sus datos,
incluyendo los que corresponden a su perfil ante Hacienda.
3. Registrar clientes: El proveedor podrá registrar sus clientes habituales
4. Registrar productos: El proveedor podrá registrar sus productos o servicios
5. Facturar: El proveedor podrá facturar sus ventas.
6. Ver facturas: El proveedor podrá ver sus facturas, también incluye la representación de ellas en PDF y en XML
7. Administrar: El administrador del sistema podrá aceptar solicitudes de registro de nuevos proveedores, listar los
proveedores registrados y eventualmente desactivar a un proveedor.
Notas
• Debido a la naturaleza educativa de este proyecto, se excluye la funcionalidad correspondiente a la conexión con el
sistema real del Ministerio de Hacienda de Costa Rica. Los estudiantes deben implementar alguna solución del lado
del servidor que les permita validar los datos suministrados a la hora de registrarse en el sistema. Se sugiere la
implementación de un STUB que consuma la fuente de datos de los usuarios registrados en el sistema de Hacienda.
• Se excluye el registro real ante el sistema ATV (Administración Tributaria Virtual)
• Se excluye el uso del Catálogo de bienes y servicios (Cabys).
• El sistema deberá usar exclusivamente la técnica de renderizado del lado del servidor (Server Side Rendering) y por
tanto NO SE PERMITE EL USO DE JAVASCRIPT.
• El sistema deberá estar implementado usando el framework MVC Web de Spring y usando como motor de plantillas
(template engine) Thymeleaf.
• El sistema deberá implementar el control de acceso por medio de sesión en el servidor, usando usuario y clave, y
solo habilitando las funcionalidades correspondientes al rol del usuario.
• Todas las páginas del sistema deberán estar basadas en una plantilla que mantenga siempre disponible el menú con
las opciones permitidas al usuario que ha ingresado y la identificación de éste.
Reglas
• El programa deberá seguir una arquitectura de tres capas (Presentación, Lógica y Datos), donde la capa de
Presentación deberá ajustarse al patrón Modelo-Vista-Controlador (MVC Web de Spring y plantillas de Thymeleaf).
• Si la propuesta de solución no cumple con los requerimientos no funcionales (implementación de 3 capas y MVC
en capa de presentación; utilización de MySQL para persistencia de datos; no utilización de Java Script), el proyecto
no será revisado.
