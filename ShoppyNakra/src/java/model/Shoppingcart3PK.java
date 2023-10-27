/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ItipatSongsampansakul
 */
@Embeddable
public class Shoppingcart3PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CART_ID")
    private int cartId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIE_ID")
    private int movieId;

    public Shoppingcart3PK() {
    }

    public Shoppingcart3PK(int cartId, int movieId) {
        this.cartId = cartId;
        this.movieId = movieId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cartId;
        hash += (int) movieId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart3PK)) {
            return false;
        }
        Shoppingcart3PK other = (Shoppingcart3PK) object;
        if (this.cartId != other.cartId) {
            return false;
        }
        if (this.movieId != other.movieId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoppingcart3PK[ cartId=" + cartId + ", movieId=" + movieId + " ]";
    }
    
}
