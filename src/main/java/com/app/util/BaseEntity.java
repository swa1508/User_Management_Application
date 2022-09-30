package com.app.util;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.envers.Audited;

@MappedSuperclass
@Audited
public class BaseEntity {
  
  
  @Column(name="creator_id")
  private Long creatorId; 
  @Column(name="creator_name")
  private String creatorName; 
  @Column(name="created_time")
  private LocalDateTime createdTime;
  
  
  @Column(name="last_modifier_id")
  private Long lastModiferId; 
  @Column(name="last_modifier_name")
  private String lastModifierName; 
  @Column(name="last_modified_time")
  private LocalDateTime lastModifiedTime;
  
  
  @PrePersist
  public void prePersist() {
      this.creatorId = 1l;
      this.creatorName = "Admin";
      this.createdTime = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.creatorId = 1l;
    this.creatorName = "Admin";
    this.createdTime = LocalDateTime.now();
  }
}
