package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.AbstractDomainModelEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olivier Liechti
 * @Edited by : Parfait Noubissi (parfait.noubissi@heig-vd.ch)

 * @param <T>
 * @param <PK>
 * But : implémenté les méthodes génériques
 */
public class GenericDAO<T extends AbstractDomainModelEntity<PK>, PK> implements IGenericDAO<T, PK> {

  
  @PersistenceContext
  EntityManager em;

  // 
  private final Class<T> jpaEntityClass;

  public GenericDAO() {
    this.jpaEntityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  @Override
  public PK create(T t) {
    T managedEntity = createAndReturnManagedEntity(t);
    PK id = managedEntity.getId();
    return id;
  }

  /**
   * But : returns corresponding managed entity
   * @param t
   * @return 
   */
  @Override
  public T createAndReturnManagedEntity(T t) {
    em.persist(t);
    em.flush();
    return t;
  }

  /**
   * @param t
   * @throws GamificationDomainEntityNotFoundException 
   */
  @Override
  public void update(T t) throws GamificationDomainEntityNotFoundException {
    findById(t.getId()); // find element
    em.merge(t);         // use merge to update entity
  }

  @Override
  public void delete(T t) throws GamificationDomainEntityNotFoundException {
      // find entity and delete it
    if (!em.contains(t)) {
      t = findById(t.getId());
    }
    em.remove(t);
  }

  @Override
  public long count() {
    return (long)em.createQuery("Select count(t) from " + jpaEntityClass.getSimpleName() + " t").getSingleResult();
  }

  @Override
  public T findById(PK id) throws GamificationDomainEntityNotFoundException {
    T result = em.find(jpaEntityClass, id);
    if (result == null) {
      throw new GamificationDomainEntityNotFoundException("Entity with id " + id + " not found");
    }
      return em.find(jpaEntityClass, id);
  }

  @Override
  public List<T> findAll() {
    return em.createQuery("Select t from " + jpaEntityClass.getSimpleName() + " t").getResultList();
  }

  @Override
  public List<T> findAllByPage(int pageSize, int pageIndex) {
    return em.createQuery("Select t from " + jpaEntityClass.getSimpleName() + " t").setMaxResults(pageSize).setFirstResult(pageIndex*pageSize).getResultList();
  }
  
}
