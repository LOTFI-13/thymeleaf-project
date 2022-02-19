package smart.vas.model;

import java.sql.Time;
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
@Table(name = "Detailtiragegift")
public class DetailTirageGift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Detailtiragegif_Ky")
	 private Long DetailTirageGiftKy;
	
	@Column(name = "Detailtiragegif_Nbwinner")
	 private int DetailTirageGifWinnerCount;
	
	@Column(name = "Detailtiragegif_Order")
	 private int DetailTirageGifOrder;
	
	@Column(name = "Detailtiragegif_Tscr")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date DetailtiragegifTsCreate;
	
	@Column(name = "Detailtiragegif_Tsup")
	@Temporal(TemporalType.TIMESTAMP)
	 private Date DetailtiragegifTsUpdate;
	
	@ManyToOne
	@JoinColumn(name="PrntlnTiragedetailky")
	private DetailTirage PrntlnDetailTirage;
	
	@ManyToOne
	@JoinColumn(name="Prntlngiftky")
	private Gift PrntlnGift;
	
	@PrePersist
	private void onCreate() {


		DetailtiragegifTsCreate = new Date();
		
	}

	public Long getDetailTirageGiftKy() {
		return DetailTirageGiftKy;
	}

	public void setDetailTirageGiftKy(Long detailTirageGiftKy) {
		DetailTirageGiftKy = detailTirageGiftKy;
	}


	public int getDetailTirageGifWinnerCount() {
		return DetailTirageGifWinnerCount;
	}

	public void setDetailTirageGifWinnerCount(int detailTirageGifWinnerCount) {
		DetailTirageGifWinnerCount = detailTirageGifWinnerCount;
	}

	public int getDetailTirageGifOrder() {
		return DetailTirageGifOrder;
	}

	public void setDetailTirageGifOrder(int detailTirageGifOrder) {
		DetailTirageGifOrder = detailTirageGifOrder;
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

	public Gift getPrntlnGift() {
		return PrntlnGift;
	}

	public void setPrntlnGift(Gift prntlnGift) {
		PrntlnGift = prntlnGift;
	}
	
	
	

}
