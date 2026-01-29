package src.it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.MonitoraggioDB;

import java.util.List;

public interface IMonitoraggioDAO {

	int insertMonitoraggio(it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.MonitoraggioDB tDb);
	List<it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.MonitoraggioDB> selectMonitoraggioByAlertAttivo();
	boolean updateAlertMonitoraggio(it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio.MonitoraggioDB mDb);
    MonitoraggioDB selectMonitoraggioById(int idMonitoraggio);
}
