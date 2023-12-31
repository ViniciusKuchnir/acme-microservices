package com.isep.acme.application.mapper;

import com.isep.acme.model.User;
import com.isep.acme.model.UserView;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-27T18:53:31+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class UserViewMapperImpl extends UserViewMapper {

    @Override
    public UserView toUserView(User user) {
        if ( user == null ) {
            return null;
        }

        UserView userView = new UserView();

        if ( user.getUserId() != null ) {
            userView.setUserId( String.valueOf( user.getUserId() ) );
        }
        userView.setUsername( user.getUsername() );
        userView.setFullName( user.getFullName() );

        return userView;
    }
}
