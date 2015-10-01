package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Raphaël Racine
 */

public class EndUser implements Serializable {
   private Application apps;
   private String  userID;
   private Date  regDate;
}
