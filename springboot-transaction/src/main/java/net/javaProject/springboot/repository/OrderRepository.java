package net.javaProject.springboot.repository;

import net.javaProject.springboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
