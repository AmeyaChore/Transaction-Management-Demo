package net.javaProject.springboot.repository;

import net.javaProject.springboot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
