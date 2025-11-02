package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.UserBehavior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserBehaviorRepository extends JpaRepository<UserBehavior, Long> {
    Optional<UserBehavior> findByClientId(long id);
}
