package ch.heigvd.amt.gamification.util;

public abstract class Pagination {
    
    public static long computeTotalNbPages(long nbItems, long nbItemsPerPage) {
        return (long) Math.ceil((double) nbItems / nbItemsPerPage);
    }
    
}
