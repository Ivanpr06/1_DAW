from django.urls import *
from djangoProjectApp.views import *
urlpatterns = [
    path('', go_home, name='inicio'),
    path('home/', go_home, name='home'),
    path('conocenos/', go_conocenos, name='conocenos'),
    path('registro/', go_registro, name='registro'),
    path('ejemplo/', cargar_datos, name='cargar_datos'),
]