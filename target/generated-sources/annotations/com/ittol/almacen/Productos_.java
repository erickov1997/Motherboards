package com.ittol.almacen;

import com.ittol.almacen.Almacenes;
import com.ittol.almacen.Entradas;
import com.ittol.almacen.Pedidos;
import com.ittol.almacen.Salidas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-28T14:59:07")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> tipo;
    public static volatile SingularAttribute<Productos, String> idProd;
    public static volatile SingularAttribute<Productos, Integer> cantVent;
    public static volatile SingularAttribute<Productos, String> nombre;
    public static volatile SingularAttribute<Productos, String> famProc;
    public static volatile SingularAttribute<Productos, String> precUni;
    public static volatile CollectionAttribute<Productos, Pedidos> pedidosCollection;
    public static volatile CollectionAttribute<Productos, Salidas> salidasCollection;
    public static volatile SingularAttribute<Productos, String> memInt;
    public static volatile SingularAttribute<Productos, Almacenes> almacen;
    public static volatile SingularAttribute<Productos, Integer> stock;
    public static volatile CollectionAttribute<Productos, Entradas> entradasCollection;
    public static volatile SingularAttribute<Productos, String> tipoMeoria;
    public static volatile SingularAttribute<Productos, String> status;

}