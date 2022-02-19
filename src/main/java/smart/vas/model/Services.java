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
@Table(name = "Services")
public class Services {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "Service_Ky")
			 private Long ServiceKy;
			
			@Column(name = "Service_Nom" , nullable=false, unique=true, length=45)
			 private String ServiceNom;
			
			@Column(name = "Service_Description", nullable=false, unique=true, length=45)
			 private String ServiceDescription;
			 
			@Column(name = "Service_Activate")
			 private boolean  ServiceActivate;
			
			@Column(name = "Service_Tscr")
			@Temporal(TemporalType.TIMESTAMP)
			 private Date ServiceTsCreate;
			
			@Column(name = "service_Tsup")
			@Temporal(TemporalType.TIMESTAMP)
			 private Date ServiceTsUpdate;
			
			@PrePersist
			private void onCreate() {


				ServiceTsCreate = new Date();
				
			}
			
			@OneToMany(mappedBy= "PrntlnService")
			private Set <ServiceLink> Servicelink = new  HashSet<>();
			
			
			public Long getServiceKy() {
				return ServiceKy;
			}


			public void setServiceKy(Long serviceKy) {
				ServiceKy = serviceKy;
			}

			
			public boolean isServiceActivate() {
				return ServiceActivate;
			}

			public void setServiceActivate(boolean serviceActivate) {
				this.ServiceActivate = serviceActivate;
			}

			public String getServiceNom() {
				return ServiceNom;
			}

			public void setServiceNom(String serviceNom) {
				this.ServiceNom = serviceNom;
			}

			public String getServiceDescription() {
				return ServiceDescription;
			}

			public void setServiceDescription(String serviceDescription) {
				this.ServiceDescription = serviceDescription;
			}


			public Date getServiceTsCreate() {
				return ServiceTsCreate;
			}



			public void setServiceTsCreate(Date serviceTsCreate) {
				this.ServiceTsCreate = serviceTsCreate;
			}



			public Date getServiceTsUpdate() {
				return ServiceTsUpdate;
			}



			public void setServiceTsUpdate(Date serviceTsUpdate) {
				this.ServiceTsUpdate = serviceTsUpdate;
			}

	}

		
