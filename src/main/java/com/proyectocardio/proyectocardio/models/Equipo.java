package com.proyectocardio.proyectocardio.models;


import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numSerie")
    private String numSerie;

    @Column(name="marca")
    private String marca;

    @Column(name="modelo")
    private String modelo;

    @Column(name="fabricante")
    private String fabricante;

    //@DateTimeFormat(iso=ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Nonnull
    @Column(name="fechaFabricacion")
    private LocalDate fechaFabricacion;

    //@DateTimeFormat(iso=ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Nonnull
    @Column(name="fechaCaducidad")
    private LocalDate fechaCaducidad;

    //@DateTimeFormat(iso=ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Nonnull
    @Column(name="fechaEntrega")
    private LocalDate fechaEntrega;

    @Column(name="codAiviago")
    private String codAiviago;

    @Column(name="pin")
    private String pin;

    @Column(name="puk")
    private String puk;

    @Column(name="operador")
    private String operador;

    @Column(name="numtlfnoAiviago")
    private String numtlfnoAiviago;

    @Column(name="numSerieCabina")
    private String numSerieCabina;

    @Column(name="refCabina")
    private String refCabina;

    @Column(name="condicionUsado")
    private Boolean condicionUsado;

    @Column(name="docUsoCreada")
    private Boolean docUsoCreada;

    @Column(name="senaletica")
    private Boolean senaletica;

   

  
    
    /* 
    public Equipo() {
    }


    public String getNumSerie() {
        return numSerie;
    }


    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getFabricante() {
        return fabricante;
    }


    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }


    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }


    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }


    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }


    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }


    public Date getFechaEntrega() {
        return fechaEntrega;
    }


    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    public String getNumSerieAiviago() {
        return numSerieAiviago;
    }


    public void setNumSerieAiviago(String numSerieAiviago) {
        this.numSerieAiviago = numSerieAiviago;
    }


    public String getCodAiviago() {
        return codAiviago;
    }


    public void setCodAiviago(String codAiviago) {
        this.codAiviago = codAiviago;
    }


    public String getPin() {
        return pin;
    }


    public void setPin(String pin) {
        this.pin = pin;
    }


    public String getPuk() {
        return puk;
    }


    public void setPuk(String puk) {
        this.puk = puk;
    }


    public String getOperador() {
        return operador;
    }


    public void setOperador(String operador) {
        this.operador = operador;
    }


    public String getNumtlfnoAiviago() {
        return numtlfnoAiviago;
    }


    public void setNumtlfnoAiviago(String numtlfnoAiviago) {
        this.numtlfnoAiviago = numtlfnoAiviago;
    }


    public String getNumSerieCabina() {
        return numSerieCabina;
    }


    public void setNumSerieCabina(String numSerieCabina) {
        this.numSerieCabina = numSerieCabina;
    }


    public String getRefCabina() {
        return refCabina;
    }


    public void setRefCabina(String refCabina) {
        this.refCabina = refCabina;
    }


    public Boolean getCondicionUsado() {
        return condicionUsado;
    }


    public void setCondicionUsado(Boolean condicionUsado) {
        this.condicionUsado = condicionUsado;
    }


    public Boolean getDocUsoCreada() {
        return docUsoCreada;
    }


    public void setDocUsoCreada(Boolean docUsoCreada) {
        this.docUsoCreada = docUsoCreada;
    }


    public Boolean getSenaletica() {
        return senaletica;
    }


    public void setSenaletica(Boolean senaletica) {
        this.senaletica = senaletica;
    }

    */

}


