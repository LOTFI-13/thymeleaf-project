package smart.vas.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


	
	@Entity
	@Table (name= "Service_Link")
	public class ServiceLink {

			@Id
			@GeneratedValue(strategy= GenerationType.IDENTITY)
			@Column(name = "Servicelink_Ky")
            private Long ServiceLinkKy;
			
			@Column(name="Servicelink_Name", nullable=false, length=45)
			private String ServiceLinkName;
			
			
			@Column(name = "Servicelink_Datedebut")
			 private String ServiceLinkDateDebut;
			
			
			@Column(name = "Servicelink_Datefin" )
			 private String ServiceLinkDateFin;
			
			@Temporal(TemporalType.TIMESTAMP)
			@Column(name = "Servicelink_Tscr")
			 private Date ServiceLinkTsCreate;
			
			@Temporal(TemporalType.TIMESTAMP)
			@Column(name = "Servicelink_Tsup")
			 private Date ServiceLinkTsUpdate;
			
			@PrePersist
			private void onCreate() {
				ServiceLinkTsCreate = new Date();	
			}
			
			public Date getServiceLinkTsCreate() {
				return ServiceLinkTsCreate;
			}


			public void setServiceLinkTsCreate(Date serviceLinkTsCreate) {
				this.ServiceLinkTsCreate = serviceLinkTsCreate;
			}


			public Date getServiceLinkTsUpdate() {
				return ServiceLinkTsUpdate;
			}


			public void setServiceLinkTsUpdate(Date serviceLinkTsUpdate) {
				this.ServiceLinkTsUpdate = serviceLinkTsUpdate;
			}

			@ManyToOne
			@JoinColumn(name ="User_Ky")
			private  User PrntlnUser;
			
			@ManyToOne
			@JoinColumn(name ="Service_Ky")
			private Services PrntlnService;
				
			@ManyToOne
			@JoinColumn(name ="Shortcode_Ky")
			private ShortCode PrntlnShortCode;
			
			
			@OneToMany(mappedBy= "PrtlnSrvcLink")
			private Set <Keyword> keyword = new  HashSet<>();
			
			@OneToMany(mappedBy= "PrntlnSrvcLink")
			private Set <DetailTirage> DetailTirage = new  HashSet<>();
			
			public ServiceLink() {
				
			}
			
			
			public ServiceLink(Long serviceLink_id, Date serviceLinkTsCreate, Date serviceLinkTsUpdate,
					User user, Services service, ShortCode shortcode) {
				super();
				this.ServiceLinkKy = serviceLink_id;
				this.ServiceLinkTsCreate = serviceLinkTsCreate;
				this.ServiceLinkTsUpdate = serviceLinkTsUpdate;
				this.PrntlnUser = user;
				this.PrntlnService = service;
				this.PrntlnShortCode = shortcode;
			}

			public Long getServiceLinkKy() {
				return ServiceLinkKy;
			}

			public void setServiceLinkKy(Long serviceLinkKy) {
				ServiceLinkKy = serviceLinkKy;
			}

			public User getPrntlnUser() {
				return PrntlnUser;
			}

			public void setPrntlnUser(User prntlnUser) {
				PrntlnUser = prntlnUser;
			}

			public Services getPrntlnService() {
				return PrntlnService;
			}

			public void setPrntlnService(Services prntlnService) {
				PrntlnService = prntlnService;
			}

			public ShortCode getPrntlnShortCode() {
				return PrntlnShortCode;
			}

			public void setPrntlnShortCode(ShortCode prntlnShortCode) {
				PrntlnShortCode = prntlnShortCode;
			}

			public String getServiceLinkName() {
				return ServiceLinkName;
			}

			public void setServiceLinkName(String serviceLinkName) {
				ServiceLinkName = serviceLinkName;
			}

			

			public Set<Keyword> getKeyword() {
				return keyword;
			}

			public void setKeyword(Set<Keyword> keyword) {
				this.keyword = keyword;
			}

			public String getServiceLinkDateDebut() {
				return ServiceLinkDateDebut;
			}

			public void setServiceLinkDateDebut(String serviceLinkDateDebut) {
				ServiceLinkDateDebut = serviceLinkDateDebut;
			}

			public String getServiceLinkDateFin() {
				return ServiceLinkDateFin;
			}

			public void setServiceLinkDateFin(String serviceLinkDateFin) {
				ServiceLinkDateFin = serviceLinkDateFin;
			}
			
			
			
			


}
