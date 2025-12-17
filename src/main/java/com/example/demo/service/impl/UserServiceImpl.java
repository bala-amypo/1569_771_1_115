package com.example.demo.service.impl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import com.example.demo.repository.AlertRecordRepository;

@Service
public UserServiceImpl implements UserService{

    @Autowired
    UserRepository userrepository;

    @Override
    public User registerUser(User user){
        return userrepository.save(user);
    }

    @Override
    public User findByEmail(String email){
        return userrepository.findByEmail(email);
    }
}



      