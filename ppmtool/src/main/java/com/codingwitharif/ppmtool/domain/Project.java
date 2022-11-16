package com.codingwitharif.ppmtool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private  String projectName;
    private String projectIdentifier;
    private  String description;
    private Date start_date;
    private Date end_date;
    private  Date created_At;
    private  Date updated_At;
    @PrePersist
    protected  void onCreate(){
        this.created_At=new Date();
    }
    protected  void onUpdate(){
        this.created_At=new Date();
    }
}
