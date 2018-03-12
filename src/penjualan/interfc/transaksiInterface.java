/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.interfc;
import penjualan.entity.transaksi;
import java.sql.SQLException;

/**
 *
 * @author choerul.sofyan
 */
public interface transaksiInterface {
    transaksi insert (transaksi o) throws SQLException;
    transaksi insertItem (transaksi o) throws SQLException;
}
