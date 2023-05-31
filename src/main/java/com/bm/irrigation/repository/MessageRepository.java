package com.bm.irrigation.repository;

import com.bm.irrigation.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
