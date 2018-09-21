/**
 * Phone.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.farmatodo.ws.schema;

public class Phone  implements java.io.Serializable {
    private java.util.Calendar createDate;

    private java.lang.String phone;

    private co.farmatodo.ws.schema.PhoneType phoneType;

    private co.farmatodo.ws.schema.PhonePk pk;

    private java.lang.Boolean primary;

    private java.lang.Boolean validated;

    public Phone() {
    }

    public Phone(
           java.util.Calendar createDate,
           java.lang.String phone,
           co.farmatodo.ws.schema.PhoneType phoneType,
           co.farmatodo.ws.schema.PhonePk pk,
           java.lang.Boolean primary,
           java.lang.Boolean validated) {
           this.createDate = createDate;
           this.phone = phone;
           this.phoneType = phoneType;
           this.pk = pk;
           this.primary = primary;
           this.validated = validated;
    }


    /**
     * Gets the createDate value for this Phone.
     * 
     * @return createDate
     */
    public java.util.Calendar getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this Phone.
     * 
     * @param createDate
     */
    public void setCreateDate(java.util.Calendar createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the phone value for this Phone.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this Phone.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the phoneType value for this Phone.
     * 
     * @return phoneType
     */
    public co.farmatodo.ws.schema.PhoneType getPhoneType() {
        return phoneType;
    }


    /**
     * Sets the phoneType value for this Phone.
     * 
     * @param phoneType
     */
    public void setPhoneType(co.farmatodo.ws.schema.PhoneType phoneType) {
        this.phoneType = phoneType;
    }


    /**
     * Gets the pk value for this Phone.
     * 
     * @return pk
     */
    public co.farmatodo.ws.schema.PhonePk getPk() {
        return pk;
    }


    /**
     * Sets the pk value for this Phone.
     * 
     * @param pk
     */
    public void setPk(co.farmatodo.ws.schema.PhonePk pk) {
        this.pk = pk;
    }


    /**
     * Gets the primary value for this Phone.
     * 
     * @return primary
     */
    public java.lang.Boolean getPrimary() {
        return primary;
    }


    /**
     * Sets the primary value for this Phone.
     * 
     * @param primary
     */
    public void setPrimary(java.lang.Boolean primary) {
        this.primary = primary;
    }


    /**
     * Gets the validated value for this Phone.
     * 
     * @return validated
     */
    public java.lang.Boolean getValidated() {
        return validated;
    }


    /**
     * Sets the validated value for this Phone.
     * 
     * @param validated
     */
    public void setValidated(java.lang.Boolean validated) {
        this.validated = validated;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Phone)) return false;
        Phone other = (Phone) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.createDate==null && other.getCreateDate()==null) || 
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.phoneType==null && other.getPhoneType()==null) || 
             (this.phoneType!=null &&
              this.phoneType.equals(other.getPhoneType()))) &&
            ((this.pk==null && other.getPk()==null) || 
             (this.pk!=null &&
              this.pk.equals(other.getPk()))) &&
            ((this.primary==null && other.getPrimary()==null) || 
             (this.primary!=null &&
              this.primary.equals(other.getPrimary()))) &&
            ((this.validated==null && other.getValidated()==null) || 
             (this.validated!=null &&
              this.validated.equals(other.getValidated())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getPhoneType() != null) {
            _hashCode += getPhoneType().hashCode();
        }
        if (getPk() != null) {
            _hashCode += getPk().hashCode();
        }
        if (getPrimary() != null) {
            _hashCode += getPrimary().hashCode();
        }
        if (getValidated() != null) {
            _hashCode += getValidated().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Phone.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("/co/farmatodo/ws/schema", "phone"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneType"));
        elemField.setXmlType(new javax.xml.namespace.QName("/co/farmatodo/ws/schema", "phoneType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk"));
        elemField.setXmlType(new javax.xml.namespace.QName("/co/farmatodo/ws/schema", "phonePk"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primary");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
