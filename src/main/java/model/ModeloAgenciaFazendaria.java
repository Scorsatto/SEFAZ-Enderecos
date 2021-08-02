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
public class ModeloAgenciaFazendaria {
    private int codigo; 
    private String sigla;
    private String nome; 
    private String unidadeSuperior;
    private String area;
    private String orgao;
    private String responsavel;
    private ModeloEndereco endereco;
    private ModeloContato contato;

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
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the unidadeSuperior
     */
    public String getUnidadeSuperior() {
        return unidadeSuperior;
    }

    /**
     * @param unidadeSuperior the unidadeSuperior to set
     */
    public void setUnidadeSuperior(String unidadeSuperior) {
        this.unidadeSuperior = unidadeSuperior;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the orgao
     */
    public String getOrgao() {
        return orgao;
    }

    /**
     * @param orgao the orgao to set
     */
    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the endereco
     */
    public ModeloEndereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(ModeloEndereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the contato
     */
    public ModeloContato getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(ModeloContato contato) {
        this.contato = contato;
    }
}