package com.xyzstore.billingservice.repository;

import com.xyzstore.billingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
