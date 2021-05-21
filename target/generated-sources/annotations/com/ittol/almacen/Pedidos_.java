package com.ittol.almacen;

import com.ittol.almacen.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-28T14:59:07")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, Date> fecha;
    public static volatile SingularAttribute<Pedidos, String> total;
    public static volatile SingularAttribute<Pedidos, Productos> idProd;
    public static volatile SingularAttribute<Pedidos, String> cantidad;
    public static volatile SingularAttribute<Pedidos, Integer> idPedido;
    public static volatile SingularAttribute<Pedidos, String> status;

}