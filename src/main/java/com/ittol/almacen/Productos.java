/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "Productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    //@NamedQuery(name = "Productos.findAll", query = "SELECT p FROM public.\"Productos\" p"),
    @NamedQuery(name = "Productos.findByIdProd", query = "SELECT p FROM Productos p WHERE p.idProd = :idProd"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByTipo", query = "SELECT p FROM Productos p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Productos.findByFamProc", query = "SELECT p FROM Productos p WHERE p.famProc = :famProc"),
    @NamedQuery(name = "Productos.findByMemInt", query = "SELECT p FROM Productos p WHERE p.memInt = :memInt"),
    @NamedQuery(name = "Productos.findByTipoMeoria", query = "SELECT p FROM Productos p WHERE p.tipoMeoria = :tipoMeoria"),
    @NamedQuery(name = "Productos.findByStock", query = "SELECT p FROM Productos p WHERE p.stock = :stock"),
    @NamedQuery(name = "Productos.findByCantVent", query = "SELECT p FROM Productos p WHERE p.cantVent = :cantVent"),
    @NamedQuery(name = "Productos.findByStatus", query = "SELECT p FROM Productos p WHERE p.status = :status"),
    @NamedQuery(name = "Productos.findByPrecUni", query = "SELECT p FROM Productos p WHERE p.precUni = :precUni")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_prod")
    private String idProd;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 25)
    @Column(name = "fam_proc")
    private String famProc;
    @Size(max = 25)
    @Column(name = "mem_int")
    private String memInt;
    @Size(max = 25)
    @Column(name = "tipo_meoria")
    private String tipoMeoria;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "cant_vent")
    private Integer cantVent;
    @Size(max = 2147483647)
    @Column(name = "status")
    private String status;
    @Size(max = 15)
    @Column(name = "prec_uni")
    private String precUni;
    @JoinColumn(name = "almacen", referencedColumnName = "id_alc")
    @ManyToOne
    private Almacenes almacen;
    @OneToMany(mappedBy = "idProd")
    private Collection<Entradas> entradasCollection;
    @OneToMany(mappedBy = "idProd")
    private Collection<Pedidos> pedidosCollection;
    @OneToMany(mappedBy = "idProd")
    private Collection<Salidas> salidasCollection;

    public Productos() {
    }

    public Productos(String idProd) {
        this.idProd = idProd;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFamProc() {
        return famProc;
    }

    public void setFamProc(String famProc) {
        this.famProc = famProc;
    }

    public String getMemInt() {
        return memInt;
    }

    public void setMemInt(String memInt) {
        this.memInt = memInt;
    }

    public String getTipoMeoria() {
        return tipoMeoria;
    }

    public void setTipoMeoria(String tipoMeoria) {
        this.tipoMeoria = tipoMeoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCantVent() {
        return cantVent;
    }

    public void setCantVent(Integer cantVent) {
        this.cantVent = cantVent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrecUni() {
        return precUni;
    }

    public void setPrecUni(String precUni) {
        this.precUni = precUni;
    }

    public Almacenes getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacenes almacen) {
        this.almacen = almacen;
    }

    @XmlTransient
    public Collection<Entradas> getEntradasCollection() {
        return entradasCollection;
    }

    public void setEntradasCollection(Collection<Entradas> entradasCollection) {
        this.entradasCollection = entradasCollection;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @XmlTransient
    public Collection<Salidas> getSalidasCollection() {
        return salidasCollection;
    }

    public void setSalidasCollection(Collection<Salidas> salidasCollection) {
        this.salidasCollection = salidasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ittol.almacen.Productos[ idProd=" + idProd + " ]";
    }
    
}
