package com.anjawanj.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${surname}")
    private String surname;

    @PostMapping(path="/add")
    public @ResponseBody void addNewUser (@RequestParam String name, @RequestParam String email) {
            User u = new User();
            u.setName(name);
            u.setEmail(email);
            userRepository.save(u);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
