package com.jdc.sdoctor.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ManyToOne;
import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
public class Consultant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private LocalDate refDate;
	private LocalTime refTime;
	@ManyToOne
	private PersonalInfo person;

	private String chiefComplain;
	@ElementCollection
	private List<String> complains;

	private double pulse;
	private double temperature;
	private double bodyWight;
	private double bloodPressureUpper;
	private double bloodPressureLower;

	private String diagnosis;
	private String remark;

	private double consultantFees;
	private double medicineCharges;
	private double tax;

	@OneToMany(mappedBy = "consultant", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private List<Treatment> treatments;

	@OneToOne
	private Registration registration;

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDate refDate) {
		this.refDate = refDate;
	}

	public LocalTime getRefTime() {
		return refTime;
	}

	public void setRefTime(LocalTime refTime) {
		this.refTime = refTime;
	}

	public PersonalInfo getPerson() {
		return person;
	}

	public void setPerson(PersonalInfo person) {
		this.person = person;
	}

	public String getChiefComplain() {
		return chiefComplain;
	}

	public void setChiefComplain(String chiefComplain) {
		this.chiefComplain = chiefComplain;
	}

	public List<String> getComplains() {
		return complains;
	}

	public void setComplains(List<String> complains) {
		this.complains = complains;
	}

	public double getPulse() {
		return pulse;
	}

	public void setPulse(double pulse) {
		this.pulse = pulse;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getBodyWight() {
		return bodyWight;
	}

	public void setBodyWight(double bodyWight) {
		this.bodyWight = bodyWight;
	}

	public double getBloodPressureUpper() {
		return bloodPressureUpper;
	}

	public void setBloodPressureUpper(double bloodPressureUpper) {
		this.bloodPressureUpper = bloodPressureUpper;
	}

	public double getBloodPressureLower() {
		return bloodPressureLower;
	}

	public void setBloodPressureLower(double bloodPressureLower) {
		this.bloodPressureLower = bloodPressureLower;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getConsultantFees() {
		return consultantFees;
	}

	public void setConsultantFees(double consultantFees) {
		this.consultantFees = consultantFees;
	}

	public double getMedicineCharges() {
		return medicineCharges;
	}

	public void setMedicineCharges(double medicineCharges) {
		this.medicineCharges = medicineCharges;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

}
