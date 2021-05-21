/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "entradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
    @NamedQuery(name = "Entradas.findByIdEnt", query = "SELECT e FROM Entradas e WHERE e.idEnt = :idEnt"),
    @NamedQuery(name = "Entradas.findByFechEnt", query = "SELECT e FROM Entradas e WHERE e.fechEnt = :fechEnt"),
    @NamedQuery(name = "Entradas.findByCantidad", query = "SELECT e FROM Entradas e WHERE e.cantidad = :cantidad")})
public class Entradas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ent")
    private Integer idEnt;
    @Column(name = "fech_ent")
    @Temporal(TemporalType.DATE)
    private Date fechEnt;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod")
    @ManyToOne
    private Productos idProd;

    public Entradas() {
    }

    public Entradas(Integer idEnt) {
        this.idEnt = idEnt;
    }

    public Integer getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(Integer idEnt) {
        this.idEnt = idEnt;
    }

    public Date getFechEnt() {
        return fechEnt;
    }

    public void setFechEnt(Date fechEnt) {
        this.fechEnt = fechEnt;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getIdProd() {
        return idProd;
    }

    public void setIdProd(Productos idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnt != null ? idEnt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradas)) {
            return false;
        }
        Entradas other = (Entradas) object;
        if ((this.idEnt == null && other.idEnt != null) || (this.idEnt != null && !this.idEnt.equals(other.idEnt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ittol.almacen.Entradas[ idEnt=" + idEnt + " ]";
    }
    
}
