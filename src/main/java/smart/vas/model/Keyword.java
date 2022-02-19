package smart.vas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table (name= "Keyword")
public class Keyword {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Keyword_Ky")
	private Long KeywordKy;
	
	@Column(name="Keyword_Value", nullable=false, length=45)
	private String KeywordValue;
	
	@Column(name="Keyword_Alias", nullable=false, unique=true, length=45)
	 private String KeywordAlias;
	
	@Column( name="Keyword_Messageretour", nullable=false, length=45)
	 private String KeywordMessageRetour;
	
	@Column( name="Keyword_Activate")
     private boolean  KeywordActivate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name="Keyword_Tscreate")
	 private Date KeywordTsCreate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name="Keyword_Tsupdate")
	 private Date KeywordTsUpdate;
	
	@PrePersist
	private void onCreate() {


		KeywordTsCreate = new Date();
		
	}
	 public String getMessageRetour() {
		return KeywordMessageRetour;
	}

	public void setMessageRetour(String messageRetour) {
		this.KeywordMessageRetour = messageRetour;
	}

	
	@ManyToOne
	@JoinColumn(name ="Servicelink_Ky")
	private ServiceLink PrtlnSrvcLink;

	public Long getKeywordKy() {
		return KeywordKy;
	}
	public void setKeywordKy(Long keywordKy) {
		KeywordKy = keywordKy;
	}
	public String getKeywordValue() {
		return KeywordValue;
	}
	public void setKeywordValue(String keywordValue) {
		KeywordValue = keywordValue;
	}
	public String getKeywordAlias() {
		return KeywordAlias;
	}
	public void setKeywordAlias(String keywordAlias) {
		KeywordAlias = keywordAlias;
	}
	public String getKeywordMessageRetour() {
		return KeywordMessageRetour;
	}
	public void setKeywordMessageRetour(String keywordMessageRetour) {
		KeywordMessageRetour = keywordMessageRetour;
	}
	public boolean isKeywordActivate() {
		return KeywordActivate;
	}
	public void setKeywordActivate(boolean keywordActivate) {
		KeywordActivate = keywordActivate;
	}
	public Date getKeywordTsCreate() {
		return KeywordTsCreate;
	}
	public void setKeywordTsCreate(Date keywordTsCreate) {
		KeywordTsCreate = keywordTsCreate;
	}
	public Date getKeywordTsUpdate() {
		return KeywordTsUpdate;
	}
	public void setKeywordTsUpdate(Date keywordTsUpdate) {
		KeywordTsUpdate = keywordTsUpdate;
	}
	public ServiceLink getPrtlnSrvcLink() {
		return PrtlnSrvcLink;
	}
	public void setPrtlnSrvcLink(ServiceLink prtlnSrvcLink) {
		PrtlnSrvcLink = prtlnSrvcLink;
	}

	

}