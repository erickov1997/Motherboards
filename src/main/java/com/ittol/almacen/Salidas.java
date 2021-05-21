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
@Table(name = "salidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidas.findAll", query = "SELECT s FROM Salidas s"),
    @NamedQuery(name = "Salidas.findByIdSal", query = "SELECT s FROM Salidas s WHERE s.idSal = :idSal"),
    @NamedQuery(name = "Salidas.findByFechaSal", query = "SELECT s FROM Salidas s WHERE s.fechaSal = :fechaSal"),
    @NamedQuery(name = "Salidas.findByCantidad", query = "SELECT s FROM Salidas s WHERE s.cantidad = :cantidad")})
public class Salidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sal")
    private Integer idSal;
    @Column(name = "fecha_sal")
    @Temporal(TemporalType.DATE)
    private Date fechaSal;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod")
    @ManyToOne
    private Productos idProd;

    public Salidas() {
    }

    public Salidas(Integer idSal) {
        this.idSal = idSal;
    }

    public Integer getIdSal() {
        return idSal;
    }

    public void setIdSal(Integer idSal) {
        this.idSal = idSal;
    }

    public Date getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(Date fechaSal) {
        this.fechaSal = fechaSal;
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
        hash += (idSal != null ? idSal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidas)) {
            return false;
        }
        Salidas other = (Salidas) object;
        if ((this.idSal == null && other.idSal != null) || (this.idSal != null && !this.idSal.equals(other.idSal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ittol.almacen.Salidas[ idSal=" + idSal + " ]";
    }
    
}
