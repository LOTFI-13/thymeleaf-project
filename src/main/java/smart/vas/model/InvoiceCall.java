package smart.vas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Invoicecall")
public class InvoiceCall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Invoicecall_Ky")
	private long 	Ky;
	
	@Column(name = "Invoicecall_Period")
	 private String 	Period;
	
	@Column(name = "Invoicecall_Operator", length=20)
	 private String 	Operateur;
	
	@Column(name = "Invoicecall_Shortcode", length=5)
	 public String  Shortcode;
	 
	@Column(name = "Invoicecall_Nbsms")
	 public long  NbSms;
	 
	@Column(name = "Invoicecall_Revenue")
	 public double 	Revenue;
	 
	@Column(name = "Invoicecall_Tscreate")
	@Temporal(TemporalType.TIMESTAMP)
	 public Date 	TsCreate;
	 
	@Column(name = "Invoicecall_Tsupdate")
	@Temporal(TemporalType.TIMESTAMP)
	 public Date 	TsUpdate;
	
	
	@PrePersist
	private void onCreate() {
		TsCreate = new Date();
		
	}

	public String getPeriod() {
		return Period;
	}
	
	

	public long getKy() {
		return Ky;
	}


	public void setKy(long ky) {
		Ky = ky;
	}


	

	public void setPeriod(String period) {
		Period = period;
	}


	


	
	public String getOperateur() {
		return Operateur;
	}

	public void setOperateur(String operateur) {
		Operateur = operateur;
	}

	public String getShortcode() {
		return Shortcode;
	}


	public void setShortcode(String shortcode) {
		Shortcode = shortcode;
	}


	public long getNbSms() {
		return NbSms;
	}


	public void setNbSms(long nbSms) {
		NbSms = nbSms;
	}


	public double getRevenue() {
		return Revenue;
	}


	public void setRevenue(double revenue) {
		Revenue = revenue;
	}


	public Date getTsCreate() {
		return TsCreate;
	}


	public void setTsCreate(Date tsCreate) {
		TsCreate = tsCreate;
	}


	public Date getTsUpdate() {
		return TsUpdate;
	}


	public void setTsUpdate(Date tsUpdate) {
		TsUpdate = tsUpdate;
	}
	
	
	

}
