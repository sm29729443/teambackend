package com.twoTeam.groupProject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.twoTeam.groupProject.Vo.StoreInfoReq;
import com.twoTeam.groupProject.Vo.StoreInfoRes;
import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.constants.UserRoles;
import com.twoTeam.groupProject.entity.StoreInfo;
import com.twoTeam.groupProject.entity.UsersEntity;
import com.twoTeam.groupProject.repository.UserDao;
import com.twoTeam.groupProject.repository.storeInfoDao;

@SpringBootTest
class GroupProjectApplicationTests {

}
