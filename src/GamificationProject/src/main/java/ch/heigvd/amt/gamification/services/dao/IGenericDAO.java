package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.AbstractDomainModelEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * @Edit by : Parfait Noubissi (parfait.noubissi@heig-vd.ch)
 * But  : here are methods needef for all entities.
 * @param <T>
 * @param <PK>
 */
@Local
public interface IGenericDAO<T extends AbstractDomainModelEntity, PK> {


    public PK create(T t);


    public T createAndReturnManagedEntity(T t);

 
    public void update(T t) throws GamificationDomainEntityNotFoundException;


    public void delete(T t) throws GamificationDomainEntityNotFoundException;


    public long count();


    public T findById(PK id) throws GamificationDomainEntityNotFoundException;


    public List<T> findAll();


    public List<T> findAllByPage(int pageSize, int pageIndex);

}
