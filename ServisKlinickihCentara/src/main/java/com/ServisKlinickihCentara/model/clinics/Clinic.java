package com.ServisKlinickihCentara.model.clinics;

import java.util.List;

import javax.persistence.*;

import com.ServisKlinickihCentara.model.employees.Doctor;
import com.ServisKlinickihCentara.model.employees.Nurse;
import com.ServisKlinickihCentara.model.users.ClinicAdmin;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Clinic 
{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	@JsonBackReference
	private List<Doctor> staff;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	@JsonBackReference
	private List<Nurse> assistingStaff;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	@JsonBackReference
	private List<Room> rooms;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PriceItem> pricelist;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Term> freeTerms;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	@JsonBackReference
	private List<ClinicAdmin> admins;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clinic")
	@JsonBackReference
	private List<ClinicRating> clinicRatings;
	
	
	public Clinic() {};
	
	public Clinic(String name, String address)
	{
		this.name = name;
		this.address = address;
	}

	public Clinic(String name, String address, List<Doctor> staff, List<Nurse> assistingStaff, List<Room> rooms,
			List<PriceItem> pricelist, List<Term> freeTerms, List<ClinicAdmin> admins) {
		super();
		this.name = name;
		this.address = address;
		this.staff = staff;
		this.assistingStaff = assistingStaff;
		this.rooms = rooms;
		this.pricelist = pricelist;
		this.freeTerms = freeTerms;
		this.admins = admins;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Doctor> getStaff() {
		return staff;
	}

	public void setStaff(List<Doctor> staff) {
		this.staff = staff;
	}

	public List<Nurse> getAssistingStaff() {
		return assistingStaff;
	}

	public void setAssistingStaff(List<Nurse> assistingStaff) {
		this.assistingStaff = assistingStaff;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<PriceItem> getPricelist() {
		return pricelist;
	}

	public void setPricelist(List<PriceItem> pricelist) {
		this.pricelist = pricelist;
	}

	public List<Term> getFreeTerms() {
		return freeTerms;
	}

	public void setFreeTerms(List<Term> freeTerms) {
		this.freeTerms = freeTerms;
	}

	public List<ClinicAdmin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<ClinicAdmin> admins) {
		this.admins = admins;
	}
	
	
	
	
}