package penjualan.interfc;
import penjualan.entity.productEntity;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author choerul.sofyan
 */
public interface productInterface {
    productEntity insert (productEntity o) throws SQLException;
    void update (productEntity o) throws SQLException;
    void delete (String kode_barang) throws SQLException;
    List getAll() throws SQLException;
    ObservableList<productEntity> ProductList() throws SQLException;
}
