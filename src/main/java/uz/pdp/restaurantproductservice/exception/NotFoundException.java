package uz.pdp.restaurantproductservice.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg + " not found");
    }
}
