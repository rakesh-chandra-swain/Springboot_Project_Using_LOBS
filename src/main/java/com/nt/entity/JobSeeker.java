package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="JobSeeker_DATABASE")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class JobSeeker implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer jsId;
	@Column(length=50)
	@NonNull
		private String jsName;
	@NonNull
	@Column(length=50)
		private String jsAddrs;
	@Lob
	@NonNull
		private byte[] photo;
	@Lob
	@NonNull
		private char[] resume;
	@NonNull
		private Boolean indian;
}
