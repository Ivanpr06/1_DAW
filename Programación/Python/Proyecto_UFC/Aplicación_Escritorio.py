import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from Almacenar_datos import *

class MiVentana(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("Proyecto_Prog.ui", self)  # Carga el archivo .ui directamente

        # CONECTAR LOS BOTONES DEL MENU
        self.boton_anadir.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.Anadir))
 #       self.boton_ver.clicked.connect(self.cargar_datos_tabla)
        self.boton_eliminar.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.Eliminar))
        self.boton_editar.clicked.connect(lambda: self.stackedWidget.setCurrentWidget(self.Editar))
#
# #         # CONECTAR BOTON GUARDAR
# #         self.boton_guardar.clicked.connect(self.crear_nueva_pala)
# #
#     def cargar_datos_tabla(self):
#         self.stackedWidget.setCurrentWidget(self.boton_ver)
#         peleadores, columnas = consultar_base_datos()
#         self.tabla_ver.setRowCount(len(peleadores))
#         for fila, peleador in enumerate(peleadores, start=0):
#             for columna, peleadores in enumerate(peleador.values(), start=0):
#                 self.tabla_ver.setItem(fila, columna, QTableWidgetItem(str(peleadores)))
#         self.tabla_ver.resizeColumnsToContents()

    # def crear_nueva_pala(self):
    #     nueva_pala = dict()
    #     nueva_pala["nombre"] = self.inputNombre.text()
    #     nueva_pala["foto"] = self.inputFoto.text()
    #     nueva_pala["forma"] = self.inputForma.text()
    #     nueva_pala["marca"] = self.InputMarca.text()
    #     nueva_pala["precio"] = float(self.inputPrecio.text())
    #     nueva_pala["temporada"] = int(self.inputTemporada.text())
    #     nueva_pala["tacto"] = self.inputTacto.text()
    #     crear_nueva(nueva_pala)
#
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = MiVentana()
    ventana.show()
    sys.exit(app.exec_())
