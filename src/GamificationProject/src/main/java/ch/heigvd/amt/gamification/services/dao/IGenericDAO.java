package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.AbstractDomainModelEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * edit : Parfait Noubissi (parfait.noubissi@heig-vd.ch)
 * But : permettre de définir les méthodes communes à toutes les entitées.
 */
@Local
public interface IGenericDAO<T extends AbstractDomainModelEntity, PK> {

    /**
     * But : Permet de créer un nouvel élément de type T
     * @param t
     * @return 
     */
    public PK create(T t);

    /**
     * But : Permet de créer une entity manager.
     * @param t
     * @return 
     */
    public T createAndReturnManagedEntity(T t);

    /**
     * 
     * @param t
     * @throws GamificationDomainEntityNotFoundException 
     */
    public void update(T t) throws GamificationDomainEntityNotFoundException;

    /**
     * Permet de détruire une entité 
     * @param t
     * @throws GamificationDomainEntityNotFoundException 
     */
    public void delete(T t) throws GamificationDomainEntityNotFoundException;

    /**
     * But : permet de compter les entitées
     * @return 
     */
    public long count();

    /**
     * But : permet de cherche une entité en fonction de son ID
     * @param id
     * @return
     * @throws GamificationDomainEntityNotFoundException 
     */
    public T findById(PK id) throws GamificationDomainEntityNotFoundException;

    /**
     * But : permet de retourner toute les entitées 
     * @return 
     */
    public List<T> findAll();

    /**
     * But : permet de mettre chercher les entités par pages.
     * @param pageSize
     * @param pageIndex
     * @return 
     */
    public List<T> findAllByPage(int pageSize, int pageIndex);

}
