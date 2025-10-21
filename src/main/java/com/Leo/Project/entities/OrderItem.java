package com.Leo.Project.entities;

import com.Leo.Project.entities.pk.Orderitempk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersion = 1L;

    @EmbeddedId
    private Orderitempk id;

    private  int quatity;
    private  double price;

   public OrderItem(){
   }

    public OrderItem(Order order, Product product, int quatity, double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quatity = quatity;
        this.price = price;
    }

    public Order getOrder(){
       return id.getOrder();
    }

    public void setOrder(Order order){
       id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
