package com.codingwitharif.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.sql.Update;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "Project Name is required")
    private  String projectName;
    @NotBlank(message = "project Identifier  is required")
    @Size(min = 4,max = 5,message = "Please use 4-5 characters")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;

    private  String description;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date start_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date end_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private  Date created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private  Date updated_At;
    @PrePersist
    protected  void onCreate(){
        this.created_At=new Date();
    }
    protected  void onUpdate(){
        this.created_At=new Date();
    }
}
