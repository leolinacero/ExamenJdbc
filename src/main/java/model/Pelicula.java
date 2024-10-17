package model;

import lombok.AllArgsConstructor;
import lombok.Data;



    @Data
    @AllArgsConstructor

    public class Pelicula {
        private Integer Id;
        private String titulo;
        private String genero;
        private Integer anho;

        public Pelicula(String titulo,String genero, Integer anho) {
            this.titulo = titulo;
            this.genero = genero;
            this.anho = anho;

        }
        @Override
        public String toString() {
            return "Pelicula{" +
                    "id=" + Id +
                    ", titulo='" + titulo + '\'' +
                    ", genero='" + genero + '\'' +
                    ", ano='" + anho + '\'' +
                    '}';
        }
    }


