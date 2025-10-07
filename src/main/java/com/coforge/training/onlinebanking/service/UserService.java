package com.coforge.training.onlinebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.onlinebanking.model.User;
import com.coforge.training.onlinebanking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	
		
	    private final UserRepository userRepository;

	   
	    /**
		 * @param userRepository
		 */
		public UserService(UserRepository userRepository) {
			super();
			this.userRepository = userRepository;
		}


		public User register(User user) {
	        return userRepository.save(user);
	    }

	 
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username).orElse(null);
	    }

	    
//	    public List<User> pendingApprovals() {
//	        return userRepository.findAll().stream().filter(u -> !u.isEnabled()).toList();
//	    }
//
//	
//	    public User approveUser(Long userId) {
//	        User user = userRepository.findById(userId).orElseThrow();
//	        user.setEnabled(true);
//	        return userRepository.save(user);
//	    }
}
