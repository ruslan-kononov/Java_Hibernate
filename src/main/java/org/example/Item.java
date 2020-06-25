package org.example;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    Integer id;
    @Column(name = "total")
    Integer total;
    @ManyToMany(mappedBy = "items")
    private Set<Cart> cartSet;

    public Item() {
    }

    public Item(Integer total) {
        this.total = total;
        this.cartSet = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Set<Cart> getCartSet() {
        return cartSet;
    }

    public void setCartSet(Set<Cart> cartSet) {
        this.cartSet = cartSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(total, item.total) &&
                Objects.equals(cartSet, item.cartSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, cartSet);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", total=" + total +
                ", cartSet=" + cartSet +
                '}';
    }
}
