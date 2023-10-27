/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ItipatSongsampansakul
 */
@Entity
@Table(name = "SHOPPINGCART3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart3.findAll", query = "SELECT s FROM Shoppingcart3 s"),
    @NamedQuery(name = "Shoppingcart3.findByCartId", query = "SELECT s FROM Shoppingcart3 s WHERE s.shoppingcart3PK.cartId = :cartId"),
    @NamedQuery(name = "Shoppingcart3.findByMovieId", query = "SELECT s FROM Shoppingcart3 s WHERE s.shoppingcart3PK.movieId = :movieId"),
    @NamedQuery(name = "Shoppingcart3.findByQuantity", query = "SELECT s FROM Shoppingcart3 s WHERE s.quantity = :quantity")})
public class Shoppingcart3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Shoppingcart3PK shoppingcart3PK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product3 product3;

    public Shoppingcart3() {
    }

    public Shoppingcart3(Shoppingcart3PK shoppingcart3PK) {
        this.shoppingcart3PK = shoppingcart3PK;
    }

    public Shoppingcart3(int cartId, int movieId) {
        this.shoppingcart3PK = new Shoppingcart3PK(cartId, movieId);
    }

    public Shoppingcart3PK getShoppingcart3PK() {
        return shoppingcart3PK;
    }

    public void setShoppingcart3PK(Shoppingcart3PK shoppingcart3PK) {
        this.shoppingcart3PK = shoppingcart3PK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product3 getProduct3() {
        return product3;
    }

    public void setProduct3(Product3 product3) {
        this.product3 = product3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingcart3PK != null ? shoppingcart3PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart3)) {
            return false;
        }
        Shoppingcart3 other = (Shoppingcart3) object;
        if ((this.shoppingcart3PK == null && other.shoppingcart3PK != null) || (this.shoppingcart3PK != null && !this.shoppingcart3PK.equals(other.shoppingcart3PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoppingcart3[ shoppingcart3PK=" + shoppingcart3PK + " ]";
    }
    
}
