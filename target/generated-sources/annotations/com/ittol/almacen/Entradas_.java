package com.ittol.almacen;

import com.ittol.almacen.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-28T14:59:07")
@StaticMetamodel(Entradas.class)
public class Entradas_ { 

    public static volatile SingularAttribute<Entradas, Integer> idEnt;
    public static volatile SingularAttribute<Entradas, Productos> idProd;
    public static volatile SingularAttribute<Entradas, Integer> cantidad;
    public static volatile SingularAttribute<Entradas, Date> fechEnt;

}