package net.xgui4.Exception;

public class NoFreeStorageConnectorLeftException extends IllegalStateException {
    public NoFreeStorageConnectorLeftException(String message) {
        super(message);
    }
}
