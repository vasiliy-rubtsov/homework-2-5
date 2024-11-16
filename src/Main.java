public class Main {
    public static void main(String[] args) {

        String login = "vasiliy_rubtsov";
        String password = "390Ax.BWlb";
        String confirmPassword = "390Ax_BWlb";

        Validator.validate(login, password, confirmPassword);

        System.out.println("Логин: " + login);
        System.out.println("Пароль: " + password);
        System.out.println("Подтверждение пароля: " + confirmPassword);

    }

}