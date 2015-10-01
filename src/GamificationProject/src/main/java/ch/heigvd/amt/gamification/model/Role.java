package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Raphaël Racine
 */

public class Role implements Serializable {
   private String roleName;
   private String id;
   private List<Account> list;
}
