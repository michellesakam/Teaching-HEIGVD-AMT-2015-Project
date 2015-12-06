package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.ApiKey;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Rule;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.LockModeType;

/**
 *
 * @author parfait But : implements ApplicationDOALocal
 */
@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @EJB
    private ApiKeyDAOLocal apikeyDAO;

    @Override
    public void assignApplicationToAccount(Application app, Account acc) {

        ApiKey key = apikeyDAO.getNewApiKey();

        app.setAcount(acc);
        acc.getApps().add(app);

        app.setApiKey(key);
        key.setApplication(app);

        create(app);
    }

    @Override
    public long numberOfApplicationsManaged() {
        return (long) em.createNamedQuery("Application.numberOfApplications").getSingleResult();
    }

    @Override
    public void assignApplicationToEndUser(Application application, EndUser endUser) {

        application.getEndUsers().add(endUser);
        endUser.setApplication(application);

    }

    @Override
    public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account) {
        return em.createNamedQuery("Application.findByAccountWithEndUsersNumber")
                .setParameter("idAccount", account.getId()).getResultList();
    }

    @Override
    public long nbEndUsersOfApplication(Application application) {
        return (long) em.createNamedQuery("Application.nbEndUsersOfApplication")
                .setParameter("idApplication", application.getId())
                .getSingleResult();
    }

    @Override
    public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException {
        app.setIsEnable(true);
        update(app);
    }

    @Override
    public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException {
        app.setIsEnable(false);
        update(app);
    }

    @Override
    public List<EndUser> findEndUsersAndPaginate(Application app, int index, int limit) throws GamificationDomainEntityNotFoundException {
        return em.createNamedQuery("Application.findEndUsers")
                .setParameter("idApplication", app.getId())
                .setFirstResult(index * limit)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public void updateApplication(Application app) throws GamificationDomainEntityNotFoundException {
        update(app);
    }

    @Override
    public Application findByApiKey(String apikey) {
        List<Application> app = em.createNamedQuery("Application.findByApiKey")
                .setParameter("key", apikey)
                .setMaxResults(1).getResultList();

        return app.size() > 0 ? app.get(0) : null;
    }

    @Override
    public void assignRuleToAnApplication(Application application, Rule rule) {
        rule.setApplication(application);
        application.getRules().add(rule);
    }

    @Override
    public void assignBadgeToAnApplication(Application application, Badge badge) {
        badge.setApplication(application);
        application.getBadges().add(badge);
    }

}
