package smart.vas.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Shortcode")
public class ShortCode 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Shortcode_Ky")
	private long ShortCodeKy;
	
	@Column(name = "Shortcode_Defaultmsg", length=500)
	private String ShortCodeDefaultMsg;
	
	@Column(name = "Shortcode_Activate",nullable=false)
	 private boolean ShortCodeActivate;
	
	@Column(name = "Shortcode_Prix",nullable=false )
	private double ShortCodePrix;
	 
	@Column(name = "Shortcode_Value",nullable=false, length=20)
	private String ShortCodeValue;

	@Column(name = "Shortcode_Dateoptention")
	private  String ShortCodeDateOp;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Shortcode_Datedesactivation")
	private Date ShortCodeDateDesactivation;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Shortcode_Tscr")
	 private Date ShortCodeTsCreate;
	
	@Column(name = "Shortcode_Tsup")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date ShortCodeTsUpdate;
	
	@PrePersist
	private void onCreate() {
		ShortCodeTsCreate = new Date();
		
	}
	
	@OneToMany(mappedBy= "PrntlnShortCode")
	private Set <ServiceLink> Servicelink = new  HashSet<>();
	
	
		public ShortCode() {
			super();
			// TODO Auto-generated constructor stub
		}


		public long getShortCodeKy() {
			return ShortCodeKy;
		}


		public void setShortCodeKy(long shortCodeKy) {
			ShortCodeKy = shortCodeKy;
		}


		public String getShortCodeDefaultMsg() {
			return ShortCodeDefaultMsg;
		}


		public void setShortCodeDefaultMsg(String shortCodeDefaultMsg) {
			ShortCodeDefaultMsg = shortCodeDefaultMsg;
		}


		public boolean isShortCodeActivate() {
			return ShortCodeActivate;
		}


		public void setShortCodeActivate(boolean shortCodeActivate) {
			ShortCodeActivate = shortCodeActivate;
		}


		public double getShortCodePrix() {
			return ShortCodePrix;
		}


		public void setShortCodePrix(double shortCodePrix) {
			ShortCodePrix = shortCodePrix;
		}


		public String getShortCodeValue() {
			return ShortCodeValue;
		}


		public void setShortCodeValue(String shortCodeValue) {
			ShortCodeValue = shortCodeValue;
		}


		public String getShortCodeDateOp() {
			return ShortCodeDateOp;
		}


		public void setShortCodeDateOp(String shortCodeDateOp) {
			ShortCodeDateOp = shortCodeDateOp;
		}


		public Date getShortCodeDateDesactivation() {
			return ShortCodeDateDesactivation;
		}


		public void setShortCodeDateDesactivation(Date shortCodeDateDesactivation) {
			ShortCodeDateDesactivation = shortCodeDateDesactivation;
		}


		public Date getShortCodeTsCreate() {
			return ShortCodeTsCreate;
		}


		public void setShortCodeTsCreate(Date shortCodeTsCreate) {
			ShortCodeTsCreate = shortCodeTsCreate;
		}


		public Date getShortCodeTsUpdate() {
			return ShortCodeTsUpdate;
		}


		public void setShortCodeTsUpdate(Date shortCodeTsUpdate) {
			ShortCodeTsUpdate = shortCodeTsUpdate;
		}


		public Set<ServiceLink> getServicelink() {
			return Servicelink;
		}


		public void setServicelink(Set<ServiceLink> servicelink) {
			Servicelink = servicelink;
		}
}
