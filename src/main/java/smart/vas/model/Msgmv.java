package smart.vas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Msgmv")
public class Msgmv 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Msgmv_Ky")
	private long 	Ky;
	
	@Column(name = "Msgmv_Msisdn")
	 private String 	MSISDN;
	
	@Column(name = "Msgmv_Operator")
	 private String 	OPERATOR;
	
	@Column(name = "Msgmv_Shortcodein")
	 public String  SHORTNUMBER_IN;
	 
	@Column(name = "Msgmv_Shortcodeout")
	 public String  SHORTNUMBER_OUT;
	 
	@Column(name = "Msgmv_Messagemo")
	 public String 	MESSAGE_IN;
	 
	@Column(name = "Msgmv_Messagemt")
	 public String 	MESSAGE_OUT;
	 
	@Column(name = "Msgmv_Tsin")
	 public String 	TIMESTAMP_IN;
	 
	@Column(name = "Msgmv_Tsout")
	 public String 	TIMESTAMP_OUT;
	 
	@Column(name = "Msgmv_DLR")
	 public Integer     DLR;
	 
	@Column(name = "Msgmv_Keyword")
	 public String 	Keyword_Alias;
	 
	public String getSMSID() {
		return SMSID;
	}

	public void setSMSID(String sMSID) {
		SMSID = sMSID;
	}

	public void setDLR(Integer dLR) {
		DLR = dLR;
	}

	@Column(name = "Msgmv_SMSid")
	 public String  SMSID;
	 
	@Column(name = "Msgmv_Srvclink")
	 public long     SRVCLINK;

	public Msgmv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getKy() {
		return Ky;
	}

	public void setKy(long ky) {
		Ky = ky;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public String getOPERATOR() {
		return OPERATOR;
	}

	public void setOPERATOR(String oPERATOR) {
		OPERATOR = oPERATOR;
	}

	public String getSHORTNUMBER_IN() {
		return SHORTNUMBER_IN;
	}

	public void setSHORTNUMBER_IN(String sHORTNUMBER_IN) {
		SHORTNUMBER_IN = sHORTNUMBER_IN;
	}

	public String getSHORTNUMBER_OUT() {
		return SHORTNUMBER_OUT;
	}

	public void setSHORTNUMBER_OUT(String sHORTNUMBER_OUT) {
		SHORTNUMBER_OUT = sHORTNUMBER_OUT;
	}

	public String getMESSAGE_IN() {
		return MESSAGE_IN;
	}

	public void setMESSAGE_IN(String mESSAGE_IN) {
		MESSAGE_IN = mESSAGE_IN;
	}

	public String getMESSAGE_OUT() {
		return MESSAGE_OUT;
	}

	public void setMESSAGE_OUT(String mESSAGE_OUT) {
		MESSAGE_OUT = mESSAGE_OUT;
	}

	public String getTIMESTAMP_IN() {
		return TIMESTAMP_IN;
	}

	public void setTIMESTAMP_IN(String tIMESTAMP_IN) {
		TIMESTAMP_IN = tIMESTAMP_IN;
	}

	public String getTIMESTAMP_OUT() {
		return TIMESTAMP_OUT;
	}

	public void setTIMESTAMP_OUT(String tIMESTAMP_OUT) {
		TIMESTAMP_OUT = tIMESTAMP_OUT;
	}

	public int getDLR() {
		return DLR;
	}

	public void setDLR(int dLR) {
		DLR = dLR;
	}

	public String getKeyword_Alias() {
		return Keyword_Alias;
	}

	public void setKeyword_Alias(String keyword_Alias) {
		Keyword_Alias = keyword_Alias;
	}

	public String getIDSMS() {
		return SMSID;
	}

	public void setIDSMS(String iDSMS) {
		SMSID = iDSMS;
	}

	public long getSRVCLINK() {
		return SRVCLINK;
	}

	public void setSRVCLINK(long sRVCLINK) {
		SRVCLINK = sRVCLINK;
	}
	

}
