package org.example.demo4;
import java.time.LocalDate;

public class Servicio {
        private String matricula;
        private String marca;
        private int precio;
        private LocalDate fechaAlquiler;
        private LocalDate fechaEntrega;
        private int total;

        public Servicio(String matricula, String marca, int precio, LocalDate fechaAlquiler, LocalDate fechaEntrega, int total) {
            this.matricula = matricula;
            this.marca = marca;
            this.precio = precio;
            this.fechaAlquiler = fechaAlquiler;
            this.fechaEntrega = fechaEntrega;
            this.total = total;
        }

        public String getMatricula() {
            return matricula;
        }

        public String getMarca() {
            return marca;
        }

        public int getPrecio() {
            return precio;
        }

        public LocalDate getFechaAlquiler() {
            return fechaAlquiler;
        }

        public LocalDate getFechaEntrega() {
            return fechaEntrega;
        }

        public int getTotal() {
            return total;
        }
    }


