package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Product3;
import model.Shoppingcart3PK;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-27T20:21:56")
@StaticMetamodel(Shoppingcart3.class)
public class Shoppingcart3_ { 

    public static volatile SingularAttribute<Shoppingcart3, Integer> quantity;
    public static volatile SingularAttribute<Shoppingcart3, Shoppingcart3PK> shoppingcart3PK;
    public static volatile SingularAttribute<Shoppingcart3, Product3> product3;

}