/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Scorsatto
 */
public class ModeloContato {
    private int codigo;
    private int coduni_con; 
    private String telefo;
    private String fax;
    private String caixaPostal;
    private String email;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the coduni_con
     */
    public int getCoduni_con() {
        return coduni_con;
    }

    /**
     * @param coduni_con the coduni_con to set
     */
    public void setCoduni_con(int coduni_con) {
        this.coduni_con = coduni_con;
    }

    /**
     * @return the telefo
     */
    public String getTelefo() {
        if (telefo.equals("(__) ____-____"))
            return "";
        else
            return telefo;
    }

    /**
     * @param telefo the telefo to set
     */
    public void setTelefo(String telefo) {
        this.telefo = telefo;
    }

    /**
     * @return the fax
     */
    public String getFax() {
         if (fax.equals("(__) ____-____"))
            return "";
        else
            return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the caixaPostal
     */
    public String getCaixaPostal() {
        return caixaPostal;
    }

    /**
     * @param caixaPostal the caixaPostal to set
     */
    public void setCaixaPostal(String caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}