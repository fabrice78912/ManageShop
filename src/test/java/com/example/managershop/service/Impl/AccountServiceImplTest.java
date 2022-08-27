package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.service.AccountService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class AccountServiceImplTest {
    @MockBean
    private PersonneRepository personneRepository;

    @Autowired
    private AccountService accountService;

    @Test
    void saveUserTest() {

    }

    @Test
    void saveTest() {
    }

    @Test
    void loadUserByUsername() {
    }

    @Test
    void addRoleToUser() {
    }

    @Test
    void loadRoleByRolename() {
    }

    @Test
    void testAddRoleToUser() {
    }

    @Test
    void verifyIfUserHaveRole() {
    }

    @Test
    void moveRoleToUser() {
    }
}