from os.path import pathsep

from django.template.context_processors import static
from django.urls import path

from restaurante import settings
from ristoranteramos.views import *

urlpatterns = [
    path('', go_home, name='inicio'),
    path('home/', go_home, name='home'),
    path('contacto/', go_contacto, name='contacto'),
    path('newResena/', new_resena, name='new_resena'),
    path('editResena/<int:id>', edit_resena, name='edit_resena'),
    path('eliminarResena/<int:id>', eliminar_resena, name='eliminar_resena'),

    path('eliminarEmpleado/<int:id>', eliminar_empleado, name='eliminar_empleado'),

    path('verEmpleados/', go_empleados, name='empleados'),
    path('newEmpleado/', new_empleado, name='new_empleado'),
    path('newEmpleado/<int:id>', editar_empleado, name='edit_empleado'),
    path('eliminarEmpleado/<int:id>', eliminar_empleado, name='eliminar_empleado'),
    path('verArticulos/', go_articulos, name='articulos'),
    path('newArticulo/<int:id>', editar_articulo, name='new_articulo'),
    path('eliminarArticulo/<int:id>', eliminar_articulo, name='eliminar_articulo'),
    path('newReserva', new_reserva, name='new_reserva'),
    path('newReserva/<int:id>', edit_reserva, name='edit_reserva'),
    path('eliminarReserva/<int:id>', eliminar_reserva, name='eliminar_reserva'),
    path('log-in/', log_in, name='log_in_page'),
    path('login/', go_login, name='login'),
    path('reporte/', go_reporte_ventas, name='reporte'),
    path('acerca_de/', go_acerca_de, name='acerca_de'),
    path('carta/', cargar_listado_articulos, name='carta'),
    path('logout/', logout_usuario, name='logout'),
    path('actualizar-foto/', actualizar_foto, name='actualizar_foto'),
    path('editar_perfil/', editar_perfil, name='editar_perfil'),
    path('anadir_carrito/<int:id>', anadir_carrito, name='anadir_carrito'),
    path('ver_carrito/', ver_carrito, name='carrito'),
    path('carrito/sumar/<int:producto_id>/', sumar_producto, name='sumar_producto'),
    path('carrito/restar/<int:producto_id>/', restar_producto, name='restar_producto'),
    path('completar_compra/', completar_compra, name='completar_compra'),
    path('cocinero/', go_cocinero, name='cocinero'),
    path('cocinero/linea/<int:id>/estado/', actualizar_estado_linea, name='actualizar_estado_linea'),
    path('editar_perfil/', editar_perfil, name='editar_perfil'),
    path('procedure/', ejecutar_procedure, name='procedure'),
    path('ver_historial', go_historial, name='historial'),
    path("404/", error_404),
    path('camarero/', go_camarero, name='camarero'),
    path('actualizar_estado_mesa/<int:id>/', actualizar_estado_mesa, name='actualizar_estado_mesa'),
    path('actualizar_estado_pedido/<int:id>', actualizar_estado_pedido, name='actualizar_estado_pedido'),
    path('pagar_pedido/<int:pedido_id>', pagar_pedido, name='pagar_pedido'),
]
