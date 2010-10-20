package org.dcache.webadmin.model.dataaccess.impl;

import org.dcache.webadmin.model.dataaccess.DomainsDAO;
import org.dcache.webadmin.model.dataaccess.InfoDAO;
import org.dcache.webadmin.model.dataaccess.LinkGroupsDAO;
import org.dcache.webadmin.model.dataaccess.PoolGroupDAO;
import org.dcache.webadmin.model.dataaccess.communication.CommandSenderFactory;
import org.dcache.webadmin.model.dataaccess.PoolsDAO;
import org.dcache.webadmin.model.dataaccess.DAOFactory;

/**
 * Helperclass to instantiate Helper-DAOs for Unittesting
 * @author jans
 */
public class DAOFactoryImplHelper implements DAOFactory {

    PoolsDAOImplHelper _poolsDao = new PoolsDAOImplHelper();
    PoolGroupDAOHelper _poolGroupDao = new PoolGroupDAOHelper();
    DomainsDAOHelper _domainsDao = new DomainsDAOHelper();
    LinkGroupsDAOHelper _linkGroupsDao = new LinkGroupsDAOHelper();

    @Override
    public PoolsDAO getPoolsDAO() {
        return _poolsDao;
    }

    @Override
    public void setDefaultCommandSenderFactory(CommandSenderFactory commandSenderFactory) {
//  meant not to do anything -- feel free to implement later when needed
    }

    @Override
    public PoolGroupDAO getPoolGroupDAO() {
        return _poolGroupDao;
    }

    @Override
    public InfoDAO getInfoDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DomainsDAO getDomainsDAO() {
        return _domainsDao;
    }

    @Override
    public LinkGroupsDAO getLinkGroupsDAO() {
        return _linkGroupsDao;
    }
}
