
package com.wracce.onlinedairy.repository;

import com.wracce.onlinedairy.enity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
}