package com.example.ecom.entities;

// importing JPA annotations like @Id, @Column used for mapping class to a db structure
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Instant class from Java Time API > represents the timestamp in UTC format
import java.time.Instant;


/*
 @MappedSuperclass -> JPA annotation used to define the base class that contains the common fields
 which will be inherited and mapped into child entity tables.
*/

// Difference between Entity and MappedSuperclass ?
/*
 answer : unlike @Entity > it does not get its own table for BaseEntity
 this file is used for removing duplication when  entities share common attributes.
*/
@MappedSuperclass

// Registering the auditing listeners so that springboot can populate these  values of attributes below.
// This EntityListeners will only work when in main application we have enabled this annotation @EnableJpaAuditing
// **(refer to BaseEntity) but THIS part tells which entity specifically to what!
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
public class BaseEntity {

    @Id
// autogenerate the value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


// spring will automatically populate the value of this field with the current timestamp, when the 1st record will be saved.
//  Created at is going to get populated when u give a entry for the very 1st time
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

//  After that this column gets updated.
    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;


/*   When u put PrePersist on something,then this method is automatically called
    before the entity is saved for the 1st time. */
    @PrePersist
    public void onCreate(){
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = Instant.now();
    }
}
