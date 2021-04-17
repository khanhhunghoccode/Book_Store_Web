/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class UserErrorDTO implements Serializable{
    private String userIdError, userPasswordError, fullNameError, addressError, emailError;
    private String phoneNumberError, roleIdError, confirmError;

    public UserErrorDTO() {
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getUserIdError() {
        return userIdError;
    }

    public void setUserIdError(String userIdError) {
        this.userIdError = userIdError;
    }

    public String getUserPasswordError() {
        return userPasswordError;
    }

    public void setUserPasswordError(String userPasswordError) {
        this.userPasswordError = userPasswordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

    public String getRoleIdError() {
        return roleIdError;
    }

    public void setRoleIdError(String roleIdError) {
        this.roleIdError = roleIdError;
    }

}
