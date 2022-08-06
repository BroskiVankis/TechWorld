package com.example.techworld.util;

import com.example.techworld.model.entity.*;
import com.example.techworld.model.enums.CategoryEnum;
import com.example.techworld.model.enums.StateEnum;
import com.example.techworld.model.enums.UserRoleEnum;
import com.example.techworld.repository.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.example.techworld.model.enums.StatusEnum.AVAILABLE;

@Component
public class TestDataUtils {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private OfferRepository offerRepository;

    private ModelRepository modelRepository;

    private BrandRepository brandRepository;

    public TestDataUtils(UserRepository userRepository, UserRoleRepository userRoleRepository, OfferRepository offerRepository,
                         ModelRepository modelRepository, BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setUserRole(UserRoleEnum.USER);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
        }
    }

    public UserEntity createTestAdmin(String email) {
        initRoles();

        var admin = new UserEntity().
                setEmail(email).
                setFirstName("Admin").
                setLastName("Adminov").
                setActive(true).
                setUserRoles(userRoleRepository.findAll());

        return userRepository.save(admin);
    }

    public UserEntity createTestUser(String email) {

        initRoles();

        var user = new UserEntity().
                setEmail(email).
                setFirstName("User").
                setLastName("Userov").
                setActive(true).
                setUserRoles(userRoleRepository.findAll().stream().filter(r -> r.getUserRole() != UserRoleEnum.ADMIN).toList());

        return userRepository.save(user);
    }

    public OfferEntity createTestOffer(UserEntity seller, ModelEntity model) {

        var offerEntity = new OfferEntity().
                setState(StateEnum.NEW).
                setYearsUsed(5).
                setPrice(BigDecimal.TEN).
                setDescription("Test description").
                setStatus(AVAILABLE).
                setYear(2000).
                setModel(model).
                setSeller(seller);

        return offerRepository.save(offerEntity);
    }

    public BrandEntity createTestBrand() {
        var brandEntity = new BrandEntity().setName("Apple");

        return brandRepository.save(brandEntity);
    }

    public ModelEntity createTestModel(BrandEntity brandEntity) {
        ModelEntity model = new ModelEntity().
                setName("MacBook").
                setBrand(brandEntity).
                setCategory(CategoryEnum.LAPTOP).
                setImageUrl("http://image.com/image.png").
                setStartYear(2000);

        return modelRepository.save(model);
    }

    public void cleanUpDataBase() {
        offerRepository.deleteAll();
        userRepository.deleteAll();
        userRoleRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }
}




