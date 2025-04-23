from django.shortcuts import render
from djangoProjectApp.models import *

# Create your views here.

def go_home(request):
    return render(request, 'home.html')

def go_conocenos(request):
    return render(request, 'conocenos.html')

def go_registro(request):
    return render(request, 'registro.html')

def cargar_datos(request):
    lista_comida = Comida.objects.all()

    return render(request, 'ejemplo.html', {'lista_comida': lista_comida})
