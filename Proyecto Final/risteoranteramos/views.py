from datetime import datetime
from decimal import Decimal
from functools import wraps

from django.contrib import messages
from django.contrib.auth.decorators import user_passes_test, login_required
from django.core.exceptions import PermissionDenied
from django.db import connection
from django.shortcuts import render, redirect, get_object_or_404
from unicodedata import decimal
from django.views.decorators.http import require_POST
from ristoranteramos.forms import *
from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login, logout
from .forms import RegistroFormulario, LoginFormulario
from ristoranteramos.models import *



# Create your views here.
def es_admin(user):
    if not user.is_authenticated or not user.rol == 'administrador':
        raise PermissionDenied
    return True

def es_cocinero(user):
    if not user.is_authenticated or not user.rol == 'cocinero':
        raise PermissionDenied
    return True

def es_camarero(user):
    if not user.is_authenticated or not user.rol == 'camarero':
        raise PermissionDenied
    return True

def restringido_a_roles(*roles_permitidos):
    def decorador(vista_func):
        @wraps(vista_func)
        def _wrapped_view(request, *args, **kwargs):
            user = request.user
            if not user.is_authenticated or user.rol not in roles_permitidos:
                raise PermissionDenied
            return vista_func(request, *args, **kwargs)
        return _wrapped_view
    return decorador

def go_home(request):
    articulos_destacados = ArticuloCarta.objects.filter(id__in=[3, 4, 6, 10])
    return render(request, 'home.html', {'articulos': articulos_destacados})

def go_contacto(request):
    return render(request, 'contacto.html')

def go_login(request):
    return render(request, 'log-in.html')

def go_acerca_de(request):
    return render(request, 'acerca_de.html')

def error_403(request, exception=None):
    return render(request, '403.html', status=403)


def error_404(request, exception=None):
    return render(request, '404.html', status=404)

@user_passes_test(es_admin)
def go_empleados(request):
    empleados = Usuario.objects.all()
    return render(request, 'verEmpleados.html', {"empleados": empleados})

@user_passes_test(es_admin)
def new_empleado(request):
    if request.method == 'POST':
        form = FormularioUsuario(request.POST)
        if form.is_valid():
            usuario = form.save(commit=False)
            usuario.set_password(form.cleaned_data['password'])
            usuario.save()
            return redirect('empleados')
    else:
        form = FormularioUsuario()

    return render(request, 'anadirEmpleado.html', {'form': form})

@user_passes_test(es_admin)
def editar_empleado(request, id):
    usuario = get_object_or_404(Usuario, id=id)

    if request.method == 'POST':
        form = FormularioUsuario(request.POST, instance=usuario)
        if form.is_valid():
            usuario = form.save(commit=False)
            if form.cleaned_data['password']:
                usuario.set_password(form.cleaned_data['password'])
            usuario.save()
            return redirect('empleados')
    else:
        form = FormularioUsuario(instance=usuario)

    return render(request, 'anadirEmpleado.html', {'form': form})


@user_passes_test(es_admin)
def eliminar_empleado(request, id):
    empleado_eliminar = Usuario.objects.filter(id=id)

    if len(empleado_eliminar) != 0:
        empleado_eliminar[0].delete()
        return redirect('empleados')

def cargar_listado_articulos(request):
    lista_articulos = ArticuloCarta.objects.all()
    return render(request,'carta.html',{'articulos':lista_articulos})

@user_passes_test(es_admin)
def go_articulos(request):
    articulos = ArticuloCarta.objects.all()
    return render(request, 'verArticulo.html', {"articulos": articulos})

@user_passes_test(es_admin)
def new_articulo(request, id):
    articulo = get_object_or_404(ArticuloCarta, id=id)

    if request.method == 'POST':
        form = FormularioArticulo(request.POST)
        if form.is_valid():
            form.save()
            return redirect('articulos')
    else:
            form = FormularioArticulo()

    return render(request, 'anadirArticulo.html',{'form':form}, {'articulo':articulo})

@user_passes_test(es_admin)
def editar_articulo(request, id):
    if id != 0:
        articulo = get_object_or_404(ArticuloCarta, id=id)
    else:
        articulo = None

    if request.method == 'POST':
        form = FormularioArticulo(request.POST, instance=articulo)
        if form.is_valid():
            form.save()
            return redirect('articulos')
        else:
            return render(request, 'anadirArticulo.html',{'form':form})
    else:
        form = FormularioArticulo(instance=articulo)

    return render(request, 'anadirArticulo.html',{'form':form})

@user_passes_test(es_admin)
def eliminar_articulo(request, id):
    articulo_eliminar = ArticuloCarta.objects.filter(id=id)

    if len(articulo_eliminar) != 0:
        articulo_eliminar[0].delete()
        return redirect('articulos')

def log_in(request):
    registro_form = RegistroFormulario()
    login_form = LoginFormulario()

    if request.method == 'POST':
        # Registro
        if 'email' in request.POST and 'password' in request.POST:
            registro_form = RegistroFormulario(request.POST)
            if registro_form.is_valid():
                usuario = registro_form.save(commit=False)
                usuario.set_password(registro_form.cleaned_data['password'])

                # Si no se envió rol, se pone por defecto "cliente"
                if not usuario.rol:
                    usuario.rol = 'cliente'

                usuario.save()
                return redirect('log_in_page')
        else:
            # Login
            login_form = LoginFormulario(request, data=request.POST)
            if login_form.is_valid():
                email = login_form.cleaned_data.get('username')
                password = login_form.cleaned_data.get('password')
                usuario = authenticate(request, username=email, password=password)
                if usuario is not None:
                    login(request, usuario)
                    if usuario.rol == 'administrador':
                        return redirect('empleados') 
                    else:
                        return redirect('inicio') 

    return render(request, 'log-in.html', {'registro_form': registro_form,'login_form': login_form})

def logout_usuario(request):
    logout(request)
    return redirect('inicio')

def cargar_listado_articulos(request):
    articulos = ArticuloCarta.objects.all()
    carrito_session = request.session.get('carrito', {})
    total = Decimal('0.0')
    carrito_items = []

    for producto_id, cantidad in carrito_session.items():
        producto = ArticuloCarta.objects.get(id=int(producto_id))
        total += producto.precio * Decimal(cantidad)
        carrito_items.append({
            'nombre': producto.nombre,
            'precio': producto.precio,
            'cantidad': cantidad,
        })

    return render(request, 'carta.html', {'articulos': articulos, 'total': total, 'carrito_items': carrito_items})

@user_passes_test(es_admin)
def go_reporte_ventas(request):
    return render(request, 'reporteVentas.html')

@login_required
def actualizar_foto(request):
    if request.method == 'POST' and 'foto' in request.FILES:
        usuario = request.user
        usuario.foto = request.FILES['foto']
        usuario.save()
        return redirect('inicio')
    return redirect('inicio')



@login_required
def editar_perfil(request):
    if request.method == 'POST':
        form = FormularioEditarPerfil(request.POST, instance=request.user)
        if form.is_valid():
            form.save() 
            return redirect('home')
    else:
        form = FormularioEditarPerfil(instance=request.user)

    return render(request, 'home.html', {'form': form})


def anadir_carrito(request, id):
    carrito = request.session.get('carrito', {})
    producto_en_carrito = carrito.get(str(id), 0)

    if producto_en_carrito == 0:
        carrito[str(id)] = 1
    else:
        carrito[str(id)] += 1

    request.session['carrito'] = carrito

    return redirect('carta')

def ver_carrito(request):
    if not request.user.is_authenticated:
        messages.warning(request, "Debes registrarte e iniciar sesión para ver el carrito.")
        return redirect('log_in_page')

    carrito = {}
    total = Decimal('0.0')

    carrito_session = request.session.get('carrito', {})

    for k, v in carrito_session.items():
        producto = ArticuloCarta.objects.get(id=k)
        cantidad = v
        carrito[producto] = cantidad
        total += producto.precio * Decimal(cantidad)

    return render(request, 'carrito.html', {'carrito': carrito,'total': total})

def sumar_producto(request, producto_id):
    carrito = request.session.get('carrito', {})
    carrito[str(producto_id)] = carrito.get(str(producto_id), 0) + 1
    request.session['carrito'] = carrito
    return redirect('carrito')

def restar_producto(request, producto_id):
    carrito = request.session.get('carrito', {})
    if str(producto_id) in carrito:
        if carrito[str(producto_id)] > 1:
            carrito[str(producto_id)] -= 1
        else:
            carrito.pop(str(producto_id))
        request.session['carrito'] = carrito
    return redirect('carrito')

def completar_compra(request):
    mesa_libre = Mesa.objects.filter(estado=EstadoMesa.LIBRE).first()

    if not mesa_libre:
        return render(request, 'carta.html', {'error': 'No hay mesas disponibles'})

    nuevo_pedido = Pedido()
    nuevo_pedido.fecha_hora = datetime.now()
    nuevo_pedido.cliente = request.user
    nuevo_pedido.mesa = mesa_libre
    nuevo_pedido.save()

    if mesa_libre:
        mesa_libre.estado = EstadoMesa.OCUPADA
        mesa_libre.save()
    else:
        print("No se puede cambiar")

    carrito_session = request.session.get('carrito', {})

    for k, v in carrito_session.items():
        producto = ArticuloCarta.objects.get(id=k)

        linea_pedido = LineaPedido()
        linea_pedido.articulo = producto
        linea_pedido.cantidad = v
        linea_pedido.pedido = nuevo_pedido
        linea_pedido.save()

    del request.session['carrito']
    request.session.modified = True

    return render(request, 'carrito.html',{
        'carrito': {},
        'total': 0,
        'mostrar_popout': True,
    })

@require_POST
@login_required
def actualizar_estado_pedido(request, id):
    pedido = get_object_or_404(Pedido, id=id)
    nuevo_estado_pedido = request.POST.get('estado')
    if nuevo_estado_pedido in dict(Pedido._meta.get_field('estado').choices):
        pedido.estado = nuevo_estado_pedido
        pedido.save()

        if nuevo_estado_pedido == 'preparado':
            pedido.lineas.all().update(estado='preparado')

        if nuevo_estado_pedido == 'servido':
            pedido.lineas.all().update(estado='preparado')

        if nuevo_estado_pedido == 'pagado':
            if pedido.mesa:
                mesa=pedido.mesa
                mesa.estado = 'LIBRE'
                mesa.save()
                pedido.mesa = None

                pedido.lineas.all().update(estado='preparado')

        pedido.save()

    return redirect('camarero')

@restringido_a_roles('cocinero', 'administrador')
def go_cocinero(request):
    pedidos = Pedido.objects.filter(lineas__estado='pendiente').distinct().order_by('id')
    return render(request, 'cocinero.html', {'pedidos': pedidos})

@require_POST
@login_required
def actualizar_estado_mesa(request, id):
    mesa = get_object_or_404(Mesa, id=id)
    nuevo_estado = request.POST.get('estado')
    if nuevo_estado in dict(Mesa._meta.get_field('estado').choices):
        mesa.estado = nuevo_estado
        mesa.save()

        if nuevo_estado == 'LIBRE':
            Pedido.objects.filter(mesa=mesa).update(
                mesa=None,
            )

    return redirect('camarero')

@require_POST
@login_required
@restringido_a_roles('cocinero', 'administrador')
def actualizar_estado_linea(request, id):
    linea = get_object_or_404(LineaPedido, id=id)
    nuevo_estado = request.POST.get('estado')

    if nuevo_estado in ['pendiente', 'preparado']:
        linea.estado = nuevo_estado
        linea.save()

        # Verificamos si todas las líneas del pedido están en estado "preparado"
        pedido = linea.pedido
        todas_preparadas = pedido.lineas.filter(estado='pendiente').count() == 0

        if todas_preparadas and pedido.estado == 'pendiente':
            pedido.estado = 'preparado'
            pedido.save()

    return redirect('cocinero')

@restringido_a_roles('camarero', 'administrador')
def go_camarero(request):
    mesas = Mesa.objects.all().order_by('id')

    mesas_y_pedidos = []
    for mesa in mesas:
        pedido = Pedido.objects.filter(
            mesa=mesa
        ).exclude(
            estado = 'pagado'
        ).first()

        mesas_y_pedidos.append({
            'mesa': mesa,
            'pedido': pedido,
        })

    estados_mesa = Mesa._meta.get_field('estado').choices
    return render(request, 'camarero.html', {'mesas_y_pedidos': mesas_y_pedidos, 'estados_mesa': estados_mesa})


def pagar_pedido(request, pedido_id):
    pedido = get_object_or_404(Pedido, id=pedido_id)

    if pedido.estado == 'servido':
        pedido.estado = 'pagado'

    if pedido.mesa:
        mesa = pedido.mesa
        mesa.estado = 'LIBRE'
        mesa.save()
        pedido.mesa = None

    pedido.save()

    return redirect('camarero')


#PROCEDURE BBDD
@user_passes_test(es_admin)
def ejecutar_procedure(request):
    resultados = []
    if request.method == 'POST':
        with connection.cursor() as cursor:
            try:
                cursor.callproc('top_5_articulos_mas_vendidos')
                cursor.execute('SELECT * FROM TOP_ARTICULOS_RESULTADO')
                resultados = cursor.fetchall()
            except Exception as e:
                print(f"Error ejecutando procedure: {e}")
        return render(request, 'navbarAdministrador.html', {'resultados': resultados, 'mostrar_modal': True})

@user_passes_test(es_admin)
def go_historial(request):
    pedidos = Pedido.objects.all() \
        .select_related('cliente', 'mesa') \
        .prefetch_related('lineas__articulo')

    return render(request, 'historial_pedidos.html', {'pedidos': pedidos})
