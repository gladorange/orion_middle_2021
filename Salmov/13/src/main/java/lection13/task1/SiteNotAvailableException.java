package lection13.task1;

public class SiteNotAvailableException  extends Exception{
    public SiteNotAvailableException(){
        super("Unfortunately, one or more sites are not available!");
    }
}