package ch.heigvd.amt.gamification.services.dao;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * @edit by Noubissi Parfait(parfait.noubissi@heig-vd.ch)
 */
public class GamificationDomainEntityNotFoundException extends Exception {

  /**
   * Creates a new instance of
   * <code>BusinessDomainEntityNotFoundException</code> without detail message.
   */
  public GamificationDomainEntityNotFoundException() {
  }

  /**
   * Constructs an instance of
   * <code>BusinessDomainEntityNotFoundException</code> with the specified
   * detail message.
   *
   * @param msg the detail message.
   */
  public GamificationDomainEntityNotFoundException(String msg) {
    super(msg);
  }
}
