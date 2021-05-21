package com.ittol.almacen;

import com.ittol.almacen.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-28T14:59:07")
@StaticMetamodel(Almacenes.class)
public class Almacenes_ { 

    public static volatile SingularAttribute<Almacenes, String> descripcion;
    public static volatile SingularAttribute<Almacenes, String> direccion;
    public static volatile CollectionAttribute<Almacenes, Productos> productosCollection;
    public static volatile SingularAttribute<Almacenes, Integer> idAlc;
    public static volatile SingularAttribute<Almacenes, String> nombre;

}