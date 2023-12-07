package com.isep.acme.application.mapper;

import com.isep.acme.model.User;
import com.isep.acme.model.UserView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserViewMapper {

    public abstract UserView toUserView(User user);
}
