package com.ittol.almacen;

import com.ittol.almacen.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-28T14:59:07")
@StaticMetamodel(Salidas.class)
public class Salidas_ { 

    public static volatile SingularAttribute<Salidas, Date> fechaSal;
    public static volatile SingularAttribute<Salidas, Integer> idSal;
    public static volatile SingularAttribute<Salidas, Productos> idProd;
    public static volatile SingularAttribute<Salidas, Integer> cantidad;

}