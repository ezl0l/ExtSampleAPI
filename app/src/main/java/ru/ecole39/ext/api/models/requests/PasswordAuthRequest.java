package ru.ecole39.ext.api.models.requests;

public class PasswordAuthRequest extends AuthRequestBase {
    public String username;
    public String password;

    public PasswordAuthRequest(String systemId, String username, String password) {
        super("password", systemId);
        this.username = username;
        this.password = password;
    }
}
