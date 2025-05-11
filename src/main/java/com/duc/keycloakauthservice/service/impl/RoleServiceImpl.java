package com.duc.keycloakauthservice.service.impl;

import com.duc.keycloakauthservice.service.RoleService;
import com.duc.keycloakauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final UserService userService;
    private final Keycloak keycloak;
    @Value("${app.keycloak.realm}")
    private String realm;

    @Override
    public void assignRole(String userId, String roleName) {
        UserResource user = userService.getUser(userId);

        RolesResource rolesResource = getRolesResource();
        RoleRepresentation representation = rolesResource.get(roleName).toRepresentation();
        user.roles().realmLevel().add(Collections.singletonList(representation));
    }

    @Override
    public void deleteRoleFromUser(String userId, String roleName) {
        UserResource user = userService.getUser(userId);

        RolesResource rolesResource = getRolesResource();
        RoleRepresentation representation = rolesResource.get(roleName).toRepresentation();
        user.roles().realmLevel().remove(Collections.singletonList(representation));
    }

    private RolesResource getRolesResource() {
        return keycloak.realm(realm).roles();
    }
}
