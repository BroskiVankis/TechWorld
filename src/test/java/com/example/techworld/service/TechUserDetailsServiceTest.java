package com.example.techworld.service;

import com.example.techworld.model.entity.UserEntity;
import com.example.techworld.model.entity.UserRoleEntity;
import com.example.techworld.model.enums.UserRoleEnum;
import com.example.techworld.model.user.TechUserDetails;
import com.example.techworld.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TechUserDetailsServiceTest {

    @Mock
    private UserRepository mockUserRepo;

    private TechUserDetailsService toTest;

    @BeforeEach
    void setUp() {
        toTest = new TechUserDetailsService(mockUserRepo);
    }

    @Test
    void testLoadUserByUsername_UserExists() {

        UserEntity testUserEntity =
                new UserEntity().
                        setEmail("gosho@example.com").
                        setPassword("topsecret").
                        setFirstName("Gosho").
                        setLastName("Goshev").
                        setActive(true).
                        setImageUrl("http://image.com/image").
                        setUserRoles(List.of(new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN), new UserRoleEntity().setUserRole(UserRoleEnum.USER)));

        when(mockUserRepo.findByEmail(testUserEntity.getEmail())).
                thenReturn(Optional.of(testUserEntity));

        TechUserDetails userDetails = (TechUserDetails)
           toTest.loadUserByUsername(testUserEntity.getEmail());

        Assertions.assertEquals(testUserEntity.getEmail(), userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUserEntity.getFirstName() + " " + testUserEntity.getLastName(), userDetails.getFullName());

        var authorities = userDetails.getAuthorities();

        Assertions.assertEquals(2, authorities.size());

        var authoritiesIter = authorities.iterator();

        Assertions.assertEquals("ROLE_" + UserRoleEnum.ADMIN.name(), authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + UserRoleEnum.USER.name(), authoritiesIter.next().getAuthority());

    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {

        Assertions.assertThrows(UsernameNotFoundException.class, () -> toTest.loadUserByUsername("non-existant@example.com"));
    }
}
