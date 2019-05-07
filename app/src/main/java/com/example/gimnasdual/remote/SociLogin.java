package com.example.gimnasdual.remote;

public class SociLogin {
    public String email;
    public String dni;

    public SociLogin() {
    }

    public SociLogin(String email, String dni) {
        this.email = email;
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
