package com.masai.Dao.model;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Getter
@Setter
public class CallInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

    private String From_Number;

    private Instant startedAt;

    private Instant endedAt;
    
    private Integer Duration;
    

   
	
	
}
