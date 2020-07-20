package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.Pedido;
import com.example.rest.entidades.Ubigeo;
import com.example.rest.util.MySqlDBConexion;

public class PedidoModel {

	private static final Log log = LogFactory.getLog(PedidoModel.class);

	public List<String> listarFechaRegistro() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<String> lista = new ArrayList<String>();
		try {
			String sql = "select distinct (fechaRegistro) from pedido";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();

			while (rs.next()) {
				lista.add(rs.getString(1));
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	public List<String> listarFechaEntrega(Pedido obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<String> lista = new ArrayList<String>();
		try {
			//String sql = "select distinct (fechaEntrega) from pedido where idpedido=?";
			String sql = "select distinct (fechaEntrega) from pedido where fechaRegistro=?";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getFechaRegistro());
			log.info(pstm);
			rs = pstm.executeQuery();
			while (rs.next()) {
				lista.add(rs.getString(1));
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return lista;
	}
	
	

	public List<Pedido> listarLugarEntrega(Pedido obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<Pedido> lista = new ArrayList<Pedido>();
		try {
			String sql = "select idpedido, lugarEntrega from pedido where fechaRegistro=? and fechaEntrega=?";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getFechaRegistro());
			pstm.setString(2, obj.getFechaEntrega());
			log.info(pstm);
			rs = pstm.executeQuery();
			Pedido aux = null;
			while (rs.next()) {
				aux = new Pedido();
				aux.setIdPedido(rs.getInt(1));
				aux.setLugarEntrega(rs.getString(2));
				lista.add(aux);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return lista;
	}

}



