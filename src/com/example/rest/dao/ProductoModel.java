package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.rest.entidades.Producto;
import com.example.rest.util.MySqlDBConexion;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductoModel {

	private static final Log log = LogFactory.getLog(MarcaModel.class);
	public int insertaProducto(Producto p) {
		int salida = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "insert into producto values(null,?,?,?,?,?,?,?)";
			pstm = con.prepareCall(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getSerie());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getStock());
			pstm.setInt(5, p.getMarca().getIdMarca());
			pstm.setInt(6, p.getPais().getIdPais());
			pstm.setInt(7, p.getProveedor().getIdproveedor());

			log.info("SQL-->" + pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				
			}
		}
		return salida;
	}
}
