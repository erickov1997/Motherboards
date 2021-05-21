/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.almacen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erick
 */
@Entity
@Table(name = "pedido_ws")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoWs.findAll", query = "SELECT p FROM PedidoWs p"),
    @NamedQuery(name = "PedidoWs.findByIdPedido", query = "SELECT p FROM PedidoWs p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "PedidoWs.findByIdProd", query = "SELECT p FROM PedidoWs p WHERE p.producto = :producto"),
    @NamedQuery(name = "PedidoWs.findByCantidad", query = "SELECT p FROM PedidoWs p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PedidoWs.findByTotal", query = "SELECT p FROM PedidoWs p WHERE p.total = :total"),
    @NamedQuery(name = "PedidoWs.findByFecha", query = "SELECT p FROM PedidoWs p WHERE p.fecha = :fecha")})
public class PedidoWs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Size(max = 10)
    @Column(name = "producto")
    private String producto;
    @Size(max = 10)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 10)
    @Column(name = "total")
    private String total;
    @Size(max = 15)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 30)
    @Column(name = "status")
    private String status;

    public PedidoWs() {
    }

    public PedidoWs(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoWs)) {
            return false;
        }
        PedidoWs other = (PedidoWs) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ittol.almacen.PedidoWs[ idPedido=" + idPedido + " ]";
    }
    
}
