from django.db import models

# Create your models here.

class Comida(models.Model):
    nombre = models.CharField(max_length=250)
    descripcion = models.TextField()
    imagem = models.CharField(max_length=1000)

    def __str__(self):
        return self.nombre
