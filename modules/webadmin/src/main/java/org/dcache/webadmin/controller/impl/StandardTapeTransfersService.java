package org.dcache.webadmin.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.dcache.webadmin.controller.TapeTransfersService;
import org.dcache.webadmin.controller.exceptions.TapeTransfersServiceException;
import org.dcache.webadmin.controller.util.BeanDataMapper;
import org.dcache.webadmin.model.businessobjects.RestoreInfo;
import org.dcache.webadmin.model.dataaccess.DAOFactory;
import org.dcache.webadmin.model.dataaccess.MoverDAO;
import org.dcache.webadmin.model.exceptions.DAOException;
import org.dcache.webadmin.view.pages.tapetransferqueue.beans.RestoreBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jans
 */
public class StandardTapeTransfersService implements TapeTransfersService {

    private static final Logger _log = LoggerFactory.getLogger(StandardTapeTransfersService.class);
    private DAOFactory _daoFactory;

    public StandardTapeTransfersService(DAOFactory DAOFactory) {
        _daoFactory = DAOFactory;
    }

    @Override
    public List<RestoreBean> getRestores() throws TapeTransfersServiceException {
        List<RestoreBean> beans = new ArrayList<RestoreBean>();
        try {
            Set<RestoreInfo> restores = getMoverDAO().getRestores();
            for (RestoreInfo currentRestore : restores) {
                beans.add(createRestoreBean(currentRestore));
            }
        } catch (DAOException ex) {
            throw new TapeTransfersServiceException(ex);
        }
        return beans;
    }

    private MoverDAO getMoverDAO() {
        return _daoFactory.getMoverDAO();
    }

    public void setDAOFactory(DAOFactory daoFactory) {
        _daoFactory = daoFactory;
    }

    private RestoreBean createRestoreBean(RestoreInfo info) {
        return BeanDataMapper.restoreInfoModelToView(info);
    }
}
