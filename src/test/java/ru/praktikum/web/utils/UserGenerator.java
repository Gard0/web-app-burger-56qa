package ru.praktikum.web.utils;

import ru.praktikum.web.api.model.CreateUserRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public final class UserGenerator {

    private static final String DEFAULT_PASSWORD = "Test123!_";
    private static final String DEFAULT_NAME = "Mikhail UI";

    private UserGenerator() {
    }

    public static CreateUserRequest randomUser() {
        return randomUser(DEFAULT_PASSWORD);
    }

    public static CreateUserRequest randomUser(String password) {
        return new CreateUserRequest(
                randomEmail(),
                password,
                DEFAULT_NAME
        );
    }

    public static String randomEmail() {
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return "mikhail.ui." + suffix + "@mail.test";
    }

    public static boolean isFirefoxInstalled() {
        return Files.exists(Path.of("C:\\Program Files\\Mozilla Firefox\\firefox.exe"))
                || Files.exists(Path.of("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
    }
}
