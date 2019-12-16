package tw.com.iisi.fgs.demo.fgsdonation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * This is an object that contains data related to the FgsUnitMapping table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="FgsUnitMapping"
 */

@Entity
@Table(name = "FgsUnitMappingRemote")
public class FgsUnitMapping implements Serializable {

	private static final long serialVersionUID = -8350522052618849139L;
	public static String REF = "FgsUnitMapping";
    public static String PROP_TW_FGS_UNIT_I_D = "TwFgsUnitID";
    public static String PROP_OV_FGS_UNIT_I_D = "OvFgsUnitID";
    public static String PROP_OV_FGS_UNIT_NAME = "OvFgsUnitName";
    
    // constructors
    public FgsUnitMapping() {
    }

    /**
     * Constructor for primary key
     */
    public FgsUnitMapping(java.lang.Integer fgsUnitMappingKey) {
        this.setFgsUnitMappingKey(fgsUnitMappingKey);
    }

    @Transient
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FgsUnitMappingKey")
    private java.lang.Integer fgsUnitMappingKey;

    // fields
    @Column(name = "TwFgsUnitID")
    private java.lang.String twFgsUnitID;
    
    @Column(name = "OvFgsUnitID")
    private java.lang.String ovFgsUnitID;
    
    @Column(name = "OvFgsUnitName")
    private java.lang.String ovFgsUnitName;
    
    @Column(name = "CreateDate")
    private Date createDate;
    
    @Column(name = "UpdateDate")
    private Date updateDate;
    
    @Column(name = "Version")
    private Integer version;

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id generator-class="native" column="FgsUnitMappingKey"
     */
    public java.lang.Integer getFgsUnitMappingKey() {
        return fgsUnitMappingKey;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param fgsUnitMappingKey
     *            the new ID
     */
    public void setFgsUnitMappingKey(java.lang.Integer fgsUnitMappingKey) {
        this.fgsUnitMappingKey = fgsUnitMappingKey;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: TwFgsUnitID
     */
    public java.lang.String getTwFgsUnitID() {
        return twFgsUnitID;
    }

    /**
     * Set the value related to the column: TwFgsUnitID
     * 
     * @param twFgsUnitID
     *            the TwFgsUnitID value
     */
    public void setTwFgsUnitID(java.lang.String twFgsUnitID) {
        this.twFgsUnitID = twFgsUnitID;
    }

	public java.lang.String getOvFgsUnitID() {
		return ovFgsUnitID;
	}

	public void setOvFgsUnitID(java.lang.String ovFgsUnitID) {
		this.ovFgsUnitID = ovFgsUnitID;
	}

	public java.lang.String getOvFgsUnitName() {
		return ovFgsUnitName;
	}

	public void setOvFgsUnitName(java.lang.String ovFgsUnitName) {
		this.ovFgsUnitName = ovFgsUnitName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}