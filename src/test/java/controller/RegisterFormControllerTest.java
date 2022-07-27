package controller;

//import static org.junit.jupiter.api.Assertions.*;

class RegisterFormControllerTest {
    public static void main(String[] args) {
        RegisterFormController ctrl = new RegisterFormController();
        assert ctrl.isName("Kasun Sampat");
        assert (ctrl.isName("Kasun Sampat 123") == false);
        assert (ctrl.isName("Kasun[] Sampat 123") == false);
    }

}