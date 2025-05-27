package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String userList(Model model) {
        // ROLE_ADMIN이 아닌 사용자만 필터링
        List<User> nonAdminUsers = userRepository.findAll().stream()
                .filter(user -> !"ROLE_ADMIN".equals(user.getRole()))
                .toList();

        model.addAttribute("users", nonAdminUsers);
        return "userList"; // 또는 "admin/userList" 경로일 경우 그에 맞춰 수정
    }
}
