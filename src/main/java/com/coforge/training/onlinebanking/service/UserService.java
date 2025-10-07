package com.coforge.training.onlinebanking.service;

import com.coforge.training.onlinebanking.model.User;
import com.coforge.training.onlinebanking.repository.UserRepository;
import com.coforge.training.onlinebanking.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }

    public User create(User user){ return repo.save(user); }
    public User getById(Long id){ return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found: " + id)); }
    public List<User> getAll(){ return repo.findAll(); }
    public User update(Long id, User update){
        User u = getById(id);
        u.setFName(update.getFName());
        u.setLName(update.getLName());
        u.setEmail(update.getEmail());
        u.setAadharNumber(update.getAadharNumber());
        u.setPhoneNumber(update.getPhoneNumber());
        u.setResidentialAddress(update.getResidentialAddress());
        u.setPermanentAddress(update.getPermanentAddress());
        u.setOccupation(update.getOccupation());
        return repo.save(u);
    }
    public void delete(Long id){ repo.delete(getById(id)); }
}
