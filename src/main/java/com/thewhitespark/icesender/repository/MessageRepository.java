package com.thewhitespark.icesender.repository;

import com.thewhitespark.icesender.model.MessageEntity;
import com.thewhitespark.icesender.model.MessageTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {

    @Query("SELECT m FROM MessageEntity m INNER JOIN m.messageType mt WHERE mt.type = :messageType")
    public List<MessageEntity> findByMessageType(@Param("messageType") String messageType);
}
