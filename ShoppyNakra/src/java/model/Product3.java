/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ItipatSongsampansakul
 */
@Entity
@Table(name = "PRODUCT3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product3.findAll", query = "SELECT p FROM Product3 p"),
    @NamedQuery(name = "Product3.findById", query = "SELECT p FROM Product3 p WHERE p.id = :id"),
    @NamedQuery(name = "Product3.findByMovie", query = "SELECT p FROM Product3 p WHERE p.movie = :movie"),
    @NamedQuery(name = "Product3.findByRating", query = "SELECT p FROM Product3 p WHERE p.rating = :rating"),
    @NamedQuery(name = "Product3.findByYearcreate", query = "SELECT p FROM Product3 p WHERE p.yearcreate = :yearcreate"),
    @NamedQuery(name = "Product3.findByPrice", query = "SELECT p FROM Product3 p WHERE p.price = :price")})
public class Product3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "MOVIE")
    private String movie;
    @Size(max = 20)
    @Column(name = "RATING")
    private String rating;
    @Size(max = 4)
    @Column(name = "YEARCREATE")
    private String yearcreate;
    @Column(name = "PRICE")
    private Integer price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product3")
    private Collection<Shoppingcart3> shoppingcart3Collection;

    public Product3() {
    }

    public Product3(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYearcreate() {
        return yearcreate;
    }

    public void setYearcreate(String yearcreate) {
        this.yearcreate = yearcreate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Shoppingcart3> getShoppingcart3Collection() {
        return shoppingcart3Collection;
    }

    public void setShoppingcart3Collection(Collection<Shoppingcart3> shoppingcart3Collection) {
        this.shoppingcart3Collection = shoppingcart3Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product3)) {
            return false;
        }
        Product3 other = (Product3) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product3[ id=" + id + " ]";
    }
    
}
