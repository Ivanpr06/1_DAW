from datetime import datetime
import datetime
import time
from django.contrib.auth.base_user import BaseUserManager, AbstractBaseUser
from django.contrib.auth.models import PermissionsMixin
from django.db import models

# ----------------------
# MODELOS DE USUARIOS
# ----------------------
class UsuarioManager(BaseUserManager):
    def create_user(self, email, nombre, rol, password=None):
        if not email:
            raise ValueError("El usuario debe tener un email")
        email = self.normalize_email(email)
        usuario = self.model(email=email, nombre=nombre, rol=rol)
        usuario.set_password(password)
        usuario.save(using=self._db)
        return usuario
    def create_superuser(self, email, nombre, rol='admin', password=None):
        usuario = self.create_user(email, nombre, rol, password)
        usuario.is_superuser = True
        usuario.is_staff = True
        usuario.save(using=self._db)
        return usuario

ROLES = (
    ('administrador', 'Administrador'),
    ('camarero', 'Camarero/a'),
    ('cocinero', 'Cocinero/a'),
    ('cliente', 'Cliente'),
)

class Usuario(AbstractBaseUser, PermissionsMixin):
    nombre = models.CharField(max_length=100, null=True, blank=True)
    email = models.EmailField(unique=True)
    rol = models.CharField(max_length=20, choices=ROLES, default='cliente')
    is_active = models.BooleanField(default=True)
    is_staff = models.BooleanField(default=False)
    foto = models.ImageField(upload_to='perfiles/', blank=True, null=True)
    telefono = models.CharField(max_length=15, blank=True)
    direccion = models.CharField(max_length=255, blank=True)
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

    objects = UsuarioManager()

    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = ['nombre']

    def __str__(self):
        return self.email

class HistorialInicioSesion(models.Model):
    usuario = models.ForeignKey(Usuario, on_delete=models.CASCADE)
    fecha_hora = models.DateTimeField(auto_now_add=True)
    ip = models.GenericIPAddressField()
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

# ----------------------
# MODELOS DEL RESTAURANTE
# ----------------------
class EstadoMesa(models.TextChoices):
    LIBRE = 'LIBRE', 'Libre'
    OCUPADA = 'OCUPADA', 'Ocupada'

class CategoriaProducto(models.TextChoices):
    ENTRANTES = 'ENTRANTES', 'Entrantes'
    COMIDA = 'COMIDA', 'Comida'
    BEBIDA = 'BEBIDA', 'Bebida'
    POSTRES = 'POSTRES', 'Postres'


#MODELOS DEL RESTAURANTE

class ArticuloCarta(models.Model):
    nombre = models.CharField(max_length=150)
    descripcion = models.TextField()
    precio = models.DecimalField(null=True, max_digits=8, decimal_places=2)
    categoria = models.CharField(
        max_length=150,
        choices=CategoriaProducto.choices,
    )
    receta = models.TextField(default='Sin receta')
    imagen_url = models.CharField(max_length=255, default='Sin foto')
    tiempo_preparacion = models.IntegerField(default=0, null=True)
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

    def __str__(self):
        return self.nombre

# ----------------------
# MODELOS DE PEDIDOS
# ----------------------

ESTADO_PEDIDO = (
    ('pendiente', 'Pendiente'),
    ('preparado', 'Preparado'),
    ('servido', 'Servido'),
    ('pagado', 'Pagado'),
)


class Mesa(models.Model):
    estado = models.CharField(max_length=100, choices=EstadoMesa.choices, default=EstadoMesa.LIBRE)
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

    def __str__(self):
        return str(self.id)


class Pedido(models.Model):
    cliente = models.ForeignKey(Usuario, on_delete=models.DO_NOTHING, related_name='pedidos', null=True, blank=True, limit_choices_to={'rol': 'cliente'})
    mesa = models.ForeignKey(Mesa, on_delete=models.SET_NULL, null=True, blank=True)
    estado = models.CharField(max_length=20, choices=ESTADO_PEDIDO, default='pendiente')
    fecha_hora = models.DateTimeField(auto_now_add=True)
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

    def total(self):
        return sum(linea.cantidad * linea.articulo.precio for linea in self.lineas.all())

class LineaPedido(models.Model):
    pedido = models.ForeignKey(Pedido, on_delete=models.CASCADE, related_name='lineas')
    articulo = models.ForeignKey(ArticuloCarta, on_delete=models.CASCADE)
    cantidad = models.PositiveIntegerField()
    estado = models.CharField(max_length=20, choices=[('pendiente', 'Pendiente'), ('preparado', 'Preparado')], default='pendiente')
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

# ----------------------
# MODELOS DE FACTURACIÓN
# ----------------------

class Factura(models.Model):
    pedido = models.OneToOneField(Pedido, on_delete=models.CASCADE)
    total = models.DecimalField(max_digits=8, decimal_places=2)
    fecha = models.DateTimeField(auto_now_add=True)
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

class Resena(models.Model):
    usuario = models.ForeignKey(Usuario, on_delete=models.CASCADE)
    puntuacion = models.IntegerField(default=5, null=True)
    comentario = models.TextField()
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)
    fecha_modificacion = models.DateTimeField(auto_now=True, null=True, blank=True)

def get_current_time():
    now = datetime.datetime.now()
    return now.replace(second=0, microsecond=0).time()

class Reserva(models.Model):
    usuario = models.ForeignKey(Usuario, on_delete=models.CASCADE)
    fecha_reserva = models.DateField(editable=True, default=datetime.date.today)
    hora_reserva = models.TimeField(editable=True, default=get_current_time)
    numero_personas = models.IntegerField(default=1)
    fecha_creacion = models.DateTimeField(auto_now_add=True, null=True, blank=True)

