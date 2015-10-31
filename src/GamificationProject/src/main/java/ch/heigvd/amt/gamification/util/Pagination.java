package ch.heigvd.amt.gamification.util;

/**
 *
 * @author Raphaël Racine
 */
public class Pagination {
    
    /**
     * Get the total numbers of the pages if we want nbItems per page et we have
     * nbItems in total
     * @param nbItems
     * @param nbItemsPerPage
     * @return the total numbers of the pages
     */
    public static long computeTotalNbPages(long nbItems, long nbItemsPerPage) {
        return (long) Math.ceil((double) nbItems / nbItemsPerPage);
    }
    
}
