 package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ResponseSessioDia {

        @SerializedName("$id")
        @Expose
        private String $id;
        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("dia")
        @Expose
        private String dia;
        @SerializedName("hora")
        @Expose
        private String hora;
        @SerializedName("nom")
        @Expose
        private String nom;
        @SerializedName("treballador_Id")
        @Expose
        private long treballadorId;
        @SerializedName("sala_Id")
        @Expose
        private long salaId;

        /**
         * No args constructor for use in serialization
         *
         */
        public ResponseSessioDia() {
        }

        /**
         *
         * @param id
         * @param hora
         * @param salaId
         * @param treballadorId
         * @param dia
         * @param $id
         * @param nom
         */
        public ResponseSessioDia(String $id, long id, String dia, String hora, String nom, long treballadorId, long salaId) {
            super();
            this.$id = $id;
            this.id = id;
            this.dia = dia;
            this.hora = hora;
            this.nom = nom;
            this.treballadorId = treballadorId;
            this.salaId = salaId;
        }

        public String get$id() {
            return $id;
        }

        public void set$id(String $id) {
            this.$id = $id;
        }

        public ResponseSessioDia with$id(String $id) {
            this.$id = $id;
            return this;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public ResponseSessioDia withId(long id) {
            this.id = id;
            return this;
        }

        public String getDia() {
            return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public ResponseSessioDia withDia(String dia) {
            this.dia = dia;
            return this;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        public ResponseSessioDia withHora(String hora) {
            this.hora = hora;
            return this;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public ResponseSessioDia withNom(String nom) {
            this.nom = nom;
            return this;
        }

        public long getTreballadorId() {
            return treballadorId;
        }

        public void setTreballadorId(long treballadorId) {
            this.treballadorId = treballadorId;
        }

        public ResponseSessioDia withTreballadorId(long treballadorId) {
            this.treballadorId = treballadorId;
            return this;
        }

        public long getSalaId() {
            return salaId;
        }

        public void setSalaId(long salaId) {
            this.salaId = salaId;
        }

        public ResponseSessioDia withSalaId(long salaId) {
            this.salaId = salaId;
            return this;
        }

    }

