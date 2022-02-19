package smart.vas.model;

import java.sql.Timestamp;
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
@Table(name = "Datatirage")
public class DataTirage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Datatirage_Ky")
	 private Long DataTirageKy;
	
	@Column(name = "Datatirage_Msisdn")
	 private String DataTirageMsisdn;
	
	@Column(name = "Datatirage_Ts")
	 private Timestamp DataTirageTs;
	
	@Column(name = "Datatirage_Name")
	 private String DataTirageName;
	
	@Column(name = "Datatirage_CIN")
	 private long DataTirageCIN;
	
	@Column(name = "Datatirage_Adress")
	 private String DataTirageAdresse;
	
	@Column(name = "Datatirage_Region")
	 private String DataTirageRegion;
	
	@Column(name = "Datatirage_Ville")
	 private String DataTirageVille;
	
	@Column(name = "Datatirage_Codepostal")
	 private long DataTirageCodePostal;
	
	@Column(name = "Datatirage_Genre")
	 private String DataTirageGenre;

	@Column(name = "Datatirage_Status")
	 private int DataTirageStatus;
	
	@Column(name = "Datatirage_Gift")
	 private String DataTirageGift;
	
	@Column(name = "Datatirage_Datenaiss")
	 private String DataTirageDateNaissance;
	
	@Column(name = "Datatirage_Tscr")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date DetailtiragegifTsCreate;
	
	@Column(name = "Datatirage_Tsup")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date DetailtiragegifTsUpdate;
	
	@ManyToOne
	@JoinColumn(name="PrntlnTiragedetailky")
	private DetailTirage PrntlnDetailTirage;
	
	
	@PrePersist
	private void onCreate() {


		DetailtiragegifTsCreate = new Date();
		
	}


	public Long getDataTirageKy() {
		return DataTirageKy;
	}


	public void setDataTirageKy(Long dataTirageKy) {
		DataTirageKy = dataTirageKy;
	}


	public String getDataTirageMsisdn() {
		return DataTirageMsisdn;
	}


	public void setDataTirageMsisdn(String dataTirageMsisdn) {
		DataTirageMsisdn = dataTirageMsisdn;
	}


	public Timestamp getDataTirageTs() {
		return DataTirageTs;
	}


	public void setDataTirageTs(Timestamp dataTirageTs) {
		DataTirageTs = dataTirageTs;
	}


	public String getDataTirageName() {
		return DataTirageName;
	}


	public void setDataTirageName(String dataTirageName) {
		DataTirageName = dataTirageName;
	}


	public long getDataTirageCIN() {
		return DataTirageCIN;
	}


	public void setDataTirageCIN(long dataTirageCIN) {
		DataTirageCIN = dataTirageCIN;
	}


	public String getDataTirageAdresse() {
		return DataTirageAdresse;
	}


	public void setDataTirageAdresse(String dataTirageAdresse) {
		DataTirageAdresse = dataTirageAdresse;
	}


	public String getDataTirageVille() {
		return DataTirageVille;
	}


	public void setDataTirageVille(String dataTirageVille) {
		DataTirageVille = dataTirageVille;
	}


	public long getDataTirageCodePostal() {
		return DataTirageCodePostal;
	}


	public void setDataTirageCodePostal(long dataTirageCodePostal) {
		DataTirageCodePostal = dataTirageCodePostal;
	}


	public String getDataTirageGenre() {
		return DataTirageGenre;
	}


	public void setDataTirageGenre(String dataTirageGenre) {
		DataTirageGenre = dataTirageGenre;
	}


	public int getDataTirageStatus() {
		return DataTirageStatus;
	}


	public void setDataTirageStatus(int dataTirageStatus) {
		DataTirageStatus = dataTirageStatus;
	}


	public String getDataTirageGift() {
		return DataTirageGift;
	}


	public void setDataTirageGift(String dataTirageGift) {
		DataTirageGift = dataTirageGift;
	}


	public String getDataTirageDateNaissance() {
		return DataTirageDateNaissance;
	}


	public void setDataTirageDateNaissance(String dataTirageDateNaissance) {
		DataTirageDateNaissance = dataTirageDateNaissance;
	}


	public Date getDetailtiragegifTsCreate() {
		return DetailtiragegifTsCreate;
	}


	public void setDetailtiragegifTsCreate(Date detailtiragegifTsCreate) {
		DetailtiragegifTsCreate = detailtiragegifTsCreate;
	}


	public Date getDetailtiragegifTsUpdate() {
		return DetailtiragegifTsUpdate;
	}


	public void setDetailtiragegifTsUpdate(Date detailtiragegifTsUpdate) {
		DetailtiragegifTsUpdate = detailtiragegifTsUpdate;
	}


	public DetailTirage getPrntlnDetailTirage() {
		return PrntlnDetailTirage;
	}


	public void setPrntlnDetailTirage(DetailTirage prntlnDetailTirage) {
		PrntlnDetailTirage = prntlnDetailTirage;
	}


	public String getDataTirageRegion() {
		return DataTirageRegion;
	}


	public void setDataTirageRegion(String dataTirageRegion) {
		DataTirageRegion = dataTirageRegion;
	}
	
	

}
