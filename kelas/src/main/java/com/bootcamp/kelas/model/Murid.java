package com.bootcamp.kelas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "murid")
public class Murid {

	private long id;
	private String nama;
	private String alamat;
	public Murid() {
		
	}
	
	public Murid(String nama, String alamat) {
		this.nama = nama;
		this.alamat = alamat;
		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nama", nullable = false)
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Column(name = "alamat", nullable = false)
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	@Override
	public String toString() {
		return "Murid [id=" + id + ", nama=" + nama + ", alamat=" + alamat +"]";
	}
	
}
