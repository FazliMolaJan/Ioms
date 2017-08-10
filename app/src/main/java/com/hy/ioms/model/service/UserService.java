package com.hy.ioms.model.service;

import com.hy.ioms.model.interaction.UserInteraction;
import com.hy.ioms.model.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by wsw on 2017/8/9.
 */

public class UserService implements UserInteraction {

    private UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Completable login(String account, String password) {
        return userRepository.login(account, password);
    }
}
