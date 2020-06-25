package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Cart")
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cart_id")
    private Integer id;
    @Column(name = "total")
    private Integer total;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "cart_item",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private Set<Item> items;

    public Cart() {
    }

    public Cart(Integer total, String name) {
        this.total = total;
        this.name = name;
        this.items = new HashSet<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(total, cart.total) &&
                Objects.equals(name, cart.name) &&
                Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, name, items);
    }

    @Override
    public String toString() {
        return "org.example.Cart{" +
                "id=" + id +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
