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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "almacenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacenes.findAll", query = "SELECT a FROM Almacenes a"),
    @NamedQuery(name = "Almacenes.findByIdAlc", query = "SELECT a FROM Almacenes a WHERE a.idAlc = :idAlc"),
    @NamedQuery(name = "Almacenes.findByNombre", query = "SELECT a FROM Almacenes a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Almacenes.findByDescripcion", query = "SELECT a FROM Almacenes a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Almacenes.findByDireccion", query = "SELECT a FROM Almacenes a WHERE a.direccion = :direccion")})
public class Almacenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alc")
    private Integer idAlc;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(mappedBy = "almacen")
    private Collection<Productos> productosCollection;

    public Almacenes() {
    }

    public Almacenes(Integer idAlc) {
        this.idAlc = idAlc;
    }

    public Integer getIdAlc() {
        return idAlc;
    }

    public void setIdAlc(Integer idAlc) {
        this.idAlc = idAlc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlc != null ? idAlc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacenes)) {
            return false;
        }
        Almacenes other = (Almacenes) object;
        if ((this.idAlc == null && other.idAlc != null) || (this.idAlc != null && !this.idAlc.equals(other.idAlc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ittol.almacen.Almacenes[ idAlc=" + idAlc + " ]";
    }
    
}
