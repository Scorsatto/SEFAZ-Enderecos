/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModeloAgenciaFazendaria;
import model.ModeloContato;
import model.ModeloEndereco;

/**
 *
 * @author Scorsatto
 */
public class SGBDAgenciaFazendaria {

    private final Connection conexao = new SGBDConexao().Conectar();
    private PreparedStatement preparedStatement = null;
    private PreparedStatement preparedStatement2 = null;
    private PreparedStatement preparedStatement3 = null;
    private PreparedStatement preparedStatement4 = null;
    private ResultSet resultSet = null;

    // Adiciona um servidor
    public int incluirAgenciaFazendaria(ModeloAgenciaFazendaria objAgenciaFazendaria) {

        int idAgencia = 0;

        try {
            conexao.setAutoCommit(false);
            
            preparedStatement = conexao.prepareStatement("insert into unidade_fazendaria (sigla_uni, nome_uni, unisup_uni, area_uni, orgao_uni, respon_uni) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, objAgenciaFazendaria.getSigla());
            preparedStatement.setString(2, objAgenciaFazendaria.getNome());
            preparedStatement.setString(3, objAgenciaFazendaria.getUnidadeSuperior());
            preparedStatement.setString(4, objAgenciaFazendaria.getArea());
            preparedStatement.setString(5, objAgenciaFazendaria.getOrgao());
            preparedStatement.setString(6, objAgenciaFazendaria.getResponsavel());
            preparedStatement.executeUpdate();

            //preparedStatement2 = conexao.prepareStatement("select LAST_INSERT_ID()");
            preparedStatement2 = conexao.prepareStatement("select LAST_INSERT_ROWID()");
            resultSet = preparedStatement2.executeQuery();
            if (resultSet.next()) {
                idAgencia = resultSet.getInt(1);
            }
            
            preparedStatement3 = conexao.prepareStatement("insert into endereco (coduni_end, lograd_end, numero_end, bairro_end, comple_end, ponref_end, munici_end, uf_end, cep_end) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement3.setInt(1, idAgencia);
            preparedStatement3.setString(2, objAgenciaFazendaria.getEndereco().getLogradouro());
            preparedStatement3.setString(3, objAgenciaFazendaria.getEndereco().getNumero());
            preparedStatement3.setString(4, objAgenciaFazendaria.getEndereco().getBairro());
            preparedStatement3.setString(5, objAgenciaFazendaria.getEndereco().getComplemento());
            preparedStatement3.setString(6, objAgenciaFazendaria.getEndereco().getPontoReferencia());
            preparedStatement3.setString(7, objAgenciaFazendaria.getEndereco().getMunicipio());
            preparedStatement3.setString(8, objAgenciaFazendaria.getEndereco().getUf());
            preparedStatement3.setString(9, objAgenciaFazendaria.getEndereco().getCep());
            preparedStatement3.executeUpdate();
            
            preparedStatement4 = conexao.prepareStatement("insert into contato (coduni_con, telefo_con, fax_con, cxpost_con, email_con) values (?, ?, ?, ?, ?)");
            preparedStatement4.setInt(1, idAgencia);
            preparedStatement4.setString(2, objAgenciaFazendaria.getContato().getTelefo());
            preparedStatement4.setString(3, objAgenciaFazendaria.getContato().getFax());
            preparedStatement4.setString(4, objAgenciaFazendaria.getContato().getCaixaPostal());
            preparedStatement4.setString(5, objAgenciaFazendaria.getContato().getEmail());
            preparedStatement4.executeUpdate();
            
            conexao.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SGBDAgenciaFazendaria.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } finally {
            try {
                preparedStatement4.close();
                preparedStatement3.close();
                preparedStatement2.close();
                preparedStatement.close();
                conexao.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return idAgencia;
    }
    
    public ArrayList<ModeloAgenciaFazendaria> pesquisaAgenciaFazendaria(String pesquisa, String campo) {
        ArrayList<ModeloAgenciaFazendaria> lstAgenciaFazendaria = new ArrayList<>();
        String sql;

        try {
            sql = "select * from unidade_fazendaria \n" +
                    "inner join endereco on codigo_uni = coduni_end\n" +
                    "inner join contato on codigo_uni = coduni_con\n" +
                    "where " + campo + " like ?";
            
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + pesquisa + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                ModeloAgenciaFazendaria agenciaFazendaria = new ModeloAgenciaFazendaria();
                agenciaFazendaria.setCodigo(Integer.parseInt(resultSet.getString("codigo_uni")));
                agenciaFazendaria.setSigla(resultSet.getString("sigla_uni"));
                agenciaFazendaria.setNome(resultSet.getString("nome_uni"));
                agenciaFazendaria.setUnidadeSuperior(resultSet.getString("unisup_uni"));
                agenciaFazendaria.setArea(resultSet.getString("area_uni"));
                agenciaFazendaria.setOrgao(resultSet.getString("orgao_uni"));
                agenciaFazendaria.setResponsavel(resultSet.getString("respon_uni"));
               
                ModeloEndereco endereco = new ModeloEndereco();
                endereco.setCodigo(Integer.parseInt(resultSet.getString("codigo_end")));
                endereco.setCoduni_end(Integer.parseInt(resultSet.getString("coduni_end")));
                endereco.setLogradouro(resultSet.getString("lograd_end"));
                endereco.setNumero(resultSet.getString("numero_end"));
                endereco.setBairro(resultSet.getString("bairro_end"));
                endereco.setComplemento(resultSet.getString("comple_end"));
                endereco.setPontoReferencia(resultSet.getString("ponref_end"));
                endereco.setMunicipio(resultSet.getString("munici_end"));
                endereco.setUf(resultSet.getString("uf_end"));
                endereco.setCep(resultSet.getString("cep_end"));
                agenciaFazendaria.setEndereco(endereco);

                ModeloContato contato = new ModeloContato();
                contato.setCodigo(Integer.parseInt(resultSet.getString("codigo_con")));
                contato.setCoduni_con(Integer.parseInt(resultSet.getString("coduni_con")));
                contato.setTelefo(resultSet.getString("telefo_con"));
                contato.setFax(resultSet.getString("fax_con"));
                contato.setCaixaPostal(resultSet.getString("cxpost_con"));
                contato.setEmail(resultSet.getString("email_con"));
                agenciaFazendaria.setContato(contato);

                lstAgenciaFazendaria.add(agenciaFazendaria);
            }
        } catch (SQLException | NumberFormatException e) {
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conexao.close();
            } catch (Exception e) {
                Logger.getLogger(SGBDAgenciaFazendaria.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return lstAgenciaFazendaria;
    }
    
    public boolean excluirUsuario(ModeloAgenciaFazendaria objAgenciaFazendaria) {

        boolean registroExcluido = false;

        try {
            conexao.setAutoCommit(false);
            preparedStatement = conexao.prepareStatement("delete from contato where codigo_con = ?");
            preparedStatement.setInt(1, objAgenciaFazendaria.getContato().getCodigo());
            preparedStatement.executeUpdate();

            preparedStatement2 = conexao.prepareStatement("delete from endereco where codigo_end = ?");
            preparedStatement2.setInt(1, objAgenciaFazendaria.getEndereco().getCodigo());
            preparedStatement2.executeUpdate();
            
            preparedStatement3 = conexao.prepareStatement("delete from unidade_fazendaria where codigo_uni = ?");
            preparedStatement3.setInt(1, objAgenciaFazendaria.getCodigo());
            preparedStatement3.executeUpdate();

            conexao.commit();
            registroExcluido = true;
        } catch (Exception e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SGBDAgenciaFazendaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                preparedStatement3.close();
                preparedStatement2.close();
                preparedStatement.close();
                conexao.close();
            } catch (Exception e) {
                Logger.getLogger(SGBDAgenciaFazendaria.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return registroExcluido;

    }

    public boolean alterarAgenciaFazendaria(ModeloAgenciaFazendaria objAgenciaFazendaria) {
        
        boolean registroAlterado = false;

        try {
            conexao.setAutoCommit(false);
            
            preparedStatement = conexao.prepareStatement("update contato set telefo_con = ?, fax_con = ?, cxpost_con = ?, email_con = ? where codigo_con = ?");
            preparedStatement.setString(1, objAgenciaFazendaria.getContato().getTelefo());
            preparedStatement.setString(2, objAgenciaFazendaria.getContato().getFax());
            preparedStatement.setString(3, objAgenciaFazendaria.getContato().getCaixaPostal());
            preparedStatement.setString(4, objAgenciaFazendaria.getContato().getEmail());
            preparedStatement.setInt(5, objAgenciaFazendaria.getContato().getCodigo());
            preparedStatement.executeUpdate();
            
            preparedStatement2 = conexao.prepareStatement("update endereco set lograd_end = ?, numero_end = ?, bairro_end = ?, comple_end = ?, ponref_end = ?, munici_end = ?, uf_end = ?, cep_end = ? where codigo_end = ?");
            preparedStatement2.setString(1, objAgenciaFazendaria.getEndereco().getLogradouro());
            preparedStatement2.setString(2, objAgenciaFazendaria.getEndereco().getNumero());
            preparedStatement2.setString(3, objAgenciaFazendaria.getEndereco().getBairro());
            preparedStatement2.setString(4, objAgenciaFazendaria.getEndereco().getComplemento());
            preparedStatement2.setString(5, objAgenciaFazendaria.getEndereco().getPontoReferencia());
            preparedStatement2.setString(6, objAgenciaFazendaria.getEndereco().getMunicipio());
            preparedStatement2.setString(7, objAgenciaFazendaria.getEndereco().getUf());
            preparedStatement2.setString(8, objAgenciaFazendaria.getEndereco().getCep());
            preparedStatement2.setInt(9, objAgenciaFazendaria.getEndereco().getCodigo());
            preparedStatement2.executeUpdate();
            
            preparedStatement3 = conexao.prepareStatement("update unidade_fazendaria set sigla_uni = ?, nome_uni = ?, unisup_uni = ?, area_uni = ?, orgao_uni = ?, respon_uni = ? where codigo_uni = ?");
            preparedStatement3.setString(1, objAgenciaFazendaria.getSigla());
            preparedStatement3.setString(2, objAgenciaFazendaria.getNome());
            preparedStatement3.setString(3, objAgenciaFazendaria.getUnidadeSuperior());
            preparedStatement3.setString(4, objAgenciaFazendaria.getArea());
            preparedStatement3.setString(5, objAgenciaFazendaria.getOrgao());
            preparedStatement3.setString(6, objAgenciaFazendaria.getResponsavel());
            preparedStatement3.setInt(7, objAgenciaFazendaria.getCodigo());
            preparedStatement3.executeUpdate();

            conexao.commit();
            registroAlterado = true;

        } catch (Exception e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SGBDAgenciaFazendaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                preparedStatement3.close();
                preparedStatement2.close();
                preparedStatement.close();
                conexao.close();
            } catch (Exception e) {
                Logger.getLogger(SGBDAgenciaFazendaria.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return registroAlterado;
    }
}