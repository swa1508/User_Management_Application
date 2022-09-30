package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.util.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;


@Entity
@Table(name="user")
@Data
@Audited
public class User extends BaseEntity {

  @Id
  @Column(name="user_id_pk")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="f_name")
  private String firstName;
  
  @Column(name="l_name")
  private String lastName;
 
  @Column(name="user_name")
  private String userName;
 
  @Column(name="user_password")
  private String userPassword;
  
}
