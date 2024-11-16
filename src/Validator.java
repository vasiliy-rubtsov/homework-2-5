import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import java.util.regex.Pattern;

public class Validator {
    private static final int MAX_LOGIN_LENGTH = 20;
    private static final int MAX_PASSWORD_LENGTH = 20;
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9_]+$");

    public static void validate(String login, String password, String confirmPassword) {
        String result = "";
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            result += "Ошибки проверки логина:\r\n" + e.getMessage();
        } catch (WrongPasswordException e) {
            result +="Ошибки проверки пароля:\r\n" + e.getMessage();
        } finally {
            if (!result.isEmpty()) {
                System.out.println(result);
            }
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        String result = "";
        if (login.length() > MAX_LOGIN_LENGTH) {
            result += "Длина логина не должна превышать " + MAX_LOGIN_LENGTH + " символов\r\n";
        }

        if (!PATTERN.matcher(login).find()) {
            result += "Логин содержит недопустимые символы\r\n";
        }

        if (!result.isEmpty()) {
            throw new WrongLoginException(result);
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        String result = "";

        if (password.length() > MAX_PASSWORD_LENGTH) {
            result += "Длина пароля не должна превышать " + MAX_PASSWORD_LENGTH + " символов\r\n";
        }

        if (!PATTERN.matcher(password).find()) {
            result += "Пароль содержит недопустимые символы\r\n";
        }

        if (!password.equals(confirmPassword)) {
            result += "Введенные пароли не совпадают\r\n";
        }

        if (!result.isEmpty()) {
            throw new WrongPasswordException(result);
        }
    }
}
