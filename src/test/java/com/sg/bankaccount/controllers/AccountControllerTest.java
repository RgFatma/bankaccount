package com.sg.bankaccount.controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sg.bankaccount.rest.controllers.AccountController;


@WebMvcTest(value = AccountController.class)
@ExtendWith(SpringExtension.class)
public class AccountControllerTest {

}
