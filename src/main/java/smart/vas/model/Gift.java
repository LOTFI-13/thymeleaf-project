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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name= "Gift")

public class Gift {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Gift_Ky")
	private Long GiftKy;
	
	@Column(name="Gift_Name",nullable=false, unique=true, length=45)
	private String GiftName;
	
	@Column(name="Gift_Nb", length=45)
	private Integer GiftNb;
	
	@Column(name="Gift_Cost", length=45)
	private double GiftCost;
	
	public double getGiftCost() {
		return GiftCost;
	}

	public void setGiftCost(double giftCost) {
		GiftCost = giftCost;
	}

	public Date getGiftTsCreate() {
		return GiftTsCreate;
	}

	public void setGiftTsCreate(Date giftTsCreate) {
		GiftTsCreate = giftTsCreate;
	}

	public Date getGiftTsUpdate() {
		return GiftTsUpdate;
	}

	public void setGiftTsUpdate(Date giftTsUpdate) {
		GiftTsUpdate = giftTsUpdate;
	}

	public Set<DetailTirageGift> getDetailTirageGift() {
		return DetailTirageGift;
	}

	public void setDetailTirageGift(Set<DetailTirageGift> detailTirageGift) {
		DetailTirageGift = detailTirageGift;
	}

	public void setGiftPrntlntUser(User giftPrntlntUser) {
		GiftPrntlntUser = giftPrntlntUser;
	}

	@Column(name="Gift_Tscreate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date GiftTsCreate;
	
	@Column(name="GiftTsupdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date GiftTsUpdate;
	
	@ManyToOne
	@JoinColumn(name="Gift_Prntlntuser")
	private User GiftPrntlntUser;
	
	@OneToMany(mappedBy= "PrntlnGift")
	private Set <DetailTirageGift> DetailTirageGift = new  HashSet<>();
	
	
	public Integer getGiftNb() {
		return GiftNb;
	}

	public void setGiftNb(Integer GiftNb) {
		this.GiftNb = GiftNb;
	}

	public Long getGiftKy() {
		return GiftKy;
	}

	public void setGiftKy(Long id_cadeau) {
		this.GiftKy = id_cadeau;
	}


	public User getGiftPrntlntUser() {
		return GiftPrntlntUser;
	}

	public void setAdmin(User GiftPrntlntUser) {
		this.GiftPrntlntUser = GiftPrntlntUser;
	}

	public String getGiftName() {
		return GiftName;
	}

	public void setGiftName(String name) {
		this.GiftName = name;
	}
	
	
	

}
