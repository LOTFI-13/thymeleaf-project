package smart.vas.model;

import java.sql.Time;
import java.sql.Timestamp;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Detailtirage")
public class DetailTirage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Detailtirage_Ky")
	 private Long DetailTirageKy;
	
	@Column(name = "Detailtirage_Name")
	 private String DetailTirageName;
	
	@Column(name = "Detailtirage_Keyword")
	 private String DetailTirageKeyword;
	
	@Column(name = "Detailtirage_Huissier")
	 private long DetailTirageHuissierKy;


	@Column(name = "Detailtirage_Nbwinner")
	 private int DetailTirageWinners;
	
	@Column(name = "Detailtirage_Type")
	 private String DetailTirageType;
	
	@Column(name = "Detailtirage_Status")
	 private int DetailTirageStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Detailtirage_Date")
	private Date DetailTirageDate;
	
	@Column(name = "Detailtirage_Hour")
	private String DetailTirageHour;
	 
	@Column(name = "Detailtirage_Begindate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DetailTirageBeginDate;
	
	@Column(name = "Detailtirage_Enddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DetailTirageEndDate;
	
	@Column(name = "Detailtirage_Tscr")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date DetailTirageTsCreate;
	
	@Column(name = "Detailtirage_Tsup")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date DetailTirageTsUpdate;
	
	
	@ManyToOne
	@JoinColumn(name="Detailtirage_Prntsrvclink")
	private ServiceLink PrntlnSrvcLink;
	
	@OneToMany(mappedBy= "PrntlnDetailTirage")
	private Set <DetailTirageGift> DetailTirageGift = new  HashSet<>();
	
	@OneToMany(mappedBy= "PrntlnDetailTirage")
	private Set <DetailTirageGift> DataTirage = new  HashSet<>();
	
	@PrePersist
	private void onCreate() {


		DetailTirageTsCreate = new Date();
		DetailTirageStatus=0;
		
		
	}

	public Long getDetailTirageKy() {
		return DetailTirageKy;
	}

	public void setDetailTirageKy(Long detailTirageKy) {
		DetailTirageKy = detailTirageKy;
	}

	public String getDetailTirageName() {
		return DetailTirageName;
	}

	public void setDetailTirageName(String detailTirageName) {
		DetailTirageName = detailTirageName;
	}

	public int getDetailTirageWinners() {
		return DetailTirageWinners;
	}

	public void setDetailTirageWinners(int detailTirageWinners) {
		DetailTirageWinners = detailTirageWinners;
	}

	public String getDetailTirageType() {
		return DetailTirageType;
	}

	public void setDetailTirageType(String detailTirageType) {
		DetailTirageType = detailTirageType;
	}

	public int getDetailTirageStatus() {
		return DetailTirageStatus;
	}

	public void setDetailTirageStatus(int detailTirageStatus) {
		DetailTirageStatus = detailTirageStatus;
	}

	public Date getDetailTirageDate() {
		return DetailTirageDate;
	}

	public void setDetailTirageDate(Date detailTirageDate) {
		DetailTirageDate = detailTirageDate;
	}

	public String getDetailTirageHour() {
		return DetailTirageHour;
	}

	public void setDetailTirageHour(String detailTirageHour) {
		DetailTirageHour = detailTirageHour;
	}

	public Date getDetailTirageBeginDate() {
		return DetailTirageBeginDate;
	}

	public void setDetailTirageBeginDate(Date detailTirageBeginDate) {
		DetailTirageBeginDate = detailTirageBeginDate;
	}

	public Date getDetailTirageEndDate() {
		return DetailTirageEndDate;
	}

	public void setDetailTirageEndDate(Date detailTirageEndDate) {
		DetailTirageEndDate = detailTirageEndDate;
	}

	public Date getDetailTirageTsCreate() {
		return DetailTirageTsCreate;
	}

	public void setDetailTirageTsCreate(Date detailTirageTsCreate) {
		DetailTirageTsCreate = detailTirageTsCreate;
	}

	public Date getDetailTirageTsUpdate() {
		return DetailTirageTsUpdate;
	}

	public void setDetailTirageTsUpdate(Date detailTirageTsUpdate) {
		DetailTirageTsUpdate = detailTirageTsUpdate;
	}

	public ServiceLink getPrntlnSrvcLink() {
		return PrntlnSrvcLink;
	}

	public void setPrntlnSrvcLink(ServiceLink prntlnSrvcLink) {
		PrntlnSrvcLink = prntlnSrvcLink;
	}

	public Set<DetailTirageGift> getDetailTirageGift() {
		return DetailTirageGift;
	}

	public void setDetailTirageGift(Set<DetailTirageGift> detailTirageGift) {
		DetailTirageGift = detailTirageGift;
	}

	public Set<DetailTirageGift> getDataTirage() {
		return DataTirage;
	}

	public void setDataTirage(Set<DetailTirageGift> dataTirage) {
		DataTirage = dataTirage;
	}
	
	
	
	public String getDetailTirageKeyword() {
		return DetailTirageKeyword;
	}

	public void setDetailTirageKeyword(String detailTirageKeyword) {
		DetailTirageKeyword = detailTirageKeyword;
	}

	public long getDetailTirageHuissierKy() {
		return DetailTirageHuissierKy;
	}

	public void setDetailTirageHuissierKy(long detailTirageHuissierKy) {
		DetailTirageHuissierKy = detailTirageHuissierKy;
	}

	
	
	

}
